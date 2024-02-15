package SistemaDgestaoVoos;

// imports

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


public class ControllerViagem {

    // para podermos colocar a data e usammos a classe time
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd::HH:mm:ss");

    // parta adicionar o novo passageiro
    public static void AddNovoViagem(Basedados basedados, Scanner s) throws SQLException {

        // geramos o id manualmente
        System.out.println("Inserir a id do aviao: \n(-1 Ver lista dos avioes)");
        int planeID = s.nextInt();
        if (planeID==-1) {
            ControllerVoos.PrintAllVoos(basedados);
            System.out.println("Inserir a id do aviao: ");
            planeID = s.nextInt();
        }
        Aviao aviao = ControllerVoos.getAviaoByID(basedados, planeID);

        // para inserir id de origem ao fazer reserva
        System.out.println("Inserir id de origem: \n(-1 Ver todas Origens)");
        int originID = s.nextInt();
        if (originID==-1) {
            ControllerDestino.PreintAllDestinos(basedados);
            System.out.println("iserir id do pais de origem: ");
            originID = s.nextInt();
        }
        Destino  origem = ControllerDestino.GetDestino(basedados, originID);

        // para inserir id de destino ao fazer reserva
        System.out.println("Inserir id de destino: \n(-1 Ver todos destinos)");
        int destinationID = s.nextInt();
        if (destinationID==-1) {
            ControllerDestino.PreintAllDestinos(basedados);
            System.out.println("Enter destination Destino id (int): ");
            destinationID = s.nextInt();
        }
        Destino arrival = ControllerDestino.GetDestino(basedados, destinationID);

        // para inserir data e hora do voo de acordo ao formato indicado
        System.out.println("Inserir a data de Partida formato(yyyy-MM-dd::HH:mm:ss): ");
        String dTime = s.next();
        LocalDateTime departureTime = LocalDateTime.parse(dTime, formatter);

        System.out.println("Inserir a data de Partida formato(yyyy-MM-dd::HH:mm:ss): ");
        String aTime = s.next();
        LocalDateTime arrivalTime = LocalDateTime.parse(aTime, formatter);

        Viagem viagem = new Viagem();
        viagem.setAviao(aviao);
        viagem.setOrigemDestino(origem);
        viagem.setDestinoArrival(arrival);
        viagem.setDepartureTime(departureTime);
        viagem.setArrivalTime(arrivalTime);

        ArrayList<Viagem> viagens = getAllViagens(basedados);
        int id_viagem = 0;
        if (viagens.size()!=0) id_viagem = viagens.size();

        viagem.setId_viagem(id_viagem);


        String insert = "INSERT INTO `viagem`(`id_viagem`, `aviao`, `origem`, `arrival`,"
                +" `departureTime`, `arrivalTime`, `buyassentos_B`, `buyassentos_J`, `buyassentos_C`, `buyassentos_E`,"
                +" `passengers`) VALUES ('"+viagem.getId_viagem()+"','"+planeID+"','"+originID+"','"+destinationID+"','"+
                dTime+"','"+aTime+"','0','0','0','0', '<%%/>');";

        basedados.getStatement().execute(insert);
        System.out.println("Viagem adicionada com sucesso!");

    }
    public static ArrayList<Viagem> getAllViagens(Basedados basedados) throws SQLException {
        ArrayList<Viagem> viagens = new ArrayList<>();
        String select = "SELECT * FROM `viagem`;";
        ResultSet rs = basedados.getStatement().executeQuery(select);

        ArrayList<Integer> IDs = new ArrayList<>();
        ArrayList<Integer> planeIDs = new ArrayList<>();
        ArrayList<Integer> originIDs = new ArrayList<>();
        ArrayList<Integer> destIDs = new ArrayList<>();
        ArrayList<String> depTimes = new ArrayList<>();
        ArrayList<String> arrTimes = new ArrayList<>();
        ArrayList<Integer> buyassentos_ESeats = new ArrayList<>();
        ArrayList<Integer> buyassentos_JSeats = new ArrayList<>();
        ArrayList<Integer> buyassentos_CSeats = new ArrayList<>();
        ArrayList<Integer> buyassentos_BSeats = new ArrayList<>();
        ArrayList<String> sts = new ArrayList<>();
        ArrayList<String> pass = new ArrayList<>();

        while (rs.next()) {

            IDs.add(rs.getInt("id_viagem"));
            planeIDs.add(rs.getInt("aviao"));
            originIDs.add(rs.getInt("origem"));
            destIDs.add(rs.getInt("arrival"));
            depTimes.add(rs.getString("departureTime"));
            arrTimes.add(rs.getString("arrivalTime"));
            buyassentos_ESeats.add(rs.getInt("buyassentos_E"));
            buyassentos_JSeats.add(rs.getInt("buyassentos_J"));
            buyassentos_CSeats.add(rs.getInt("buyassentos_C"));
            buyassentos_BSeats.add(rs.getInt("buyassentos_C"));
            pass.add(rs.getString("passengers"));
        }

        for (int i=0; i<IDs.size();i++) {

            Viagem viagem = new Viagem();
            viagem.setId_viagem(IDs.get(i));
            int planeID = planeIDs.get(i);
            int originID = originIDs.get(i);
            int destID = destIDs.get(i);
            String depTime = depTimes.get(i);
            String arrTime = arrTimes.get(i);
            viagem.setBuyAssentos_E(buyassentos_ESeats.get(i));
            viagem.setBuyAssentos_J(buyassentos_JSeats.get(i));
            viagem.setBuyAssentos_C(buyassentos_CSeats.get(i));
            viagem.setBuyAssentos_B(buyassentos_BSeats.get(i));
            String pas = pass.get(i);

            Aviao aviao = ControllerVoos.getAviaoByID(basedados, planeID);
            viagem.setAviao(aviao);
            viagem.setOrigemDestino(ControllerDestino.GetDestino(basedados, originID));
            viagem.setDestinoArrival(ControllerDestino.GetDestino(basedados, destID));
            LocalDateTime departure = LocalDateTime.parse(depTime, formatter);
            viagem.setDepartureTime(departure);
            LocalDateTime arrival = LocalDateTime.parse(arrTime, formatter);
            viagem.setArrivalTime(arrival);


            String[] passageirosID = pas.split("<%%/>");
            int totalCapacity = aviao.getAssentos_E() + aviao.getAssentos_B() + aviao.getAssentos_C() + aviao.getAssentos_J();
            Passageiro [] pasageiros = new Passageiro[totalCapacity];
            for (int j = 0; j < passageirosID.length; j++) {
                int id = Integer.parseInt(passageirosID[j]);
                pasageiros[j] = ControllerPassageiros.getPassageiroByID(basedados, id);
            }
            viagem.setPassageiros(pasageiros);

            viagens.add(viagem);
        }

        return viagens;
    }




}
