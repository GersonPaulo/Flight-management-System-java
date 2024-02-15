package SistemaDgestaoVoos;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

// controller aviao mudei de nome por erros
public class ControllerVoos {

    // metodo da classe acima para ler o scnner adicionar voos
    public static void AddNovoVoo(Basedados basedados, Scanner s) throws SQLException {

        System.out.println("Capacidade do Voo: ");
        int assentos = s.nextInt(); //total de assentos int

        System.out.println("Assentos Economica: ");
        int economica_E = s.nextInt(); // lugares economica

        System.out.println("Assentos Business: ");
        int assentos_B = s.nextInt();  // business Class

        System.out.println("Assentos ao lado da janela: ");
        int assentos_J = s.nextInt(); // assentos lado janela

        System.out.println("Assento lado do corredor: ");
        int assentos_C = s.nextInt(); // Assentos no corredor

        //metodos da classe aviao
        Aviao aviao = new Aviao();
        aviao.setAssentos(assentos);
        aviao.setAssentos_E(economica_E);
        aviao.setAssentos_B(assentos_B);
        aviao.setAssentos_C(assentos_C);
        aviao.setAssentos_J(assentos_J);

        int id_voo;
        ArrayList<Aviao> aviaos = getAllVoos(basedados);

        if (aviaos.size()!=0) {
            id_voo = aviaos.get(aviaos.size()-1).getId_voo()+1;
        }
        else {
            id_voo = 0;
        }
        //
        aviao.setId_voo(id_voo);
        String insert = "INSERT INTO `voos`(`id_voo`, `assentos`, `assentos_B`,"
                +" `assentos_E`, `assentos_J`, `assentos_C`) VALUES ('"+aviao.getId_voo()+"','" +
                aviao.getAssentos()+"','"+aviao.getAssentos_B()+"','"+aviao.getAssentos_E()+"','"+
                aviao.getAssentos_J()+"','"+aviao.getAssentos_C()+"');";
        basedados.getStatement().execute(insert); //
        System.out.println("Detalhes do voo adicionados corretamente!");//
    }

    //
    public static void PrintAllVoos(Basedados basedados) throws SQLException {

        System.out.println("------------------------------------------------------------");
        for (Aviao aviao : getAllVoos(basedados)) {
            aviao.print();
        }
        System.out.println("-------------------------------------------------------------");
    }

    public static ArrayList<Aviao> getAllVoos(Basedados basedados) throws SQLException {
        ArrayList<Aviao> aviaos = new ArrayList<>();
        String get = "SELECT * FROM `voos`;"; // REVER bem essa parte

        ResultSet rs = basedados.getStatement().executeQuery(get);

        while (rs.next()) {
            Aviao a = new Aviao();
            a.setId_voo(rs.getInt("id_voo"));
            a.setAssentos(rs.getInt("assentos"));
            a.setAssentos_J(rs.getInt("assentos_J"));
            a.setAssentos_C(rs.getInt("assentos_C"));
            a.setAssentos_B(rs.getInt("assentos_B"));
            a.setAssentos_E(rs.getInt("assentos_E"));
            aviaos.add(a);
        }
        return aviaos;
    }

    public static Aviao getAviaoByID(Basedados basedados , int id_voo) throws SQLException {
        Aviao a = new Aviao();
        String get = "SELECT `id_voo`, `assentos`, `assentos_B`, `assentos_E`, `assentos_J`, `assentos_C` "
        +"FROM `voos` WHERE `id_voo` = "+id_voo+" ;";
        ResultSet rs = basedados.getStatement().executeQuery(get);
        rs.next();
        a.setId_voo(rs.getInt("id_voo"));
        a.setAssentos(rs.getInt("assentos"));
        a.setAssentos_J(rs.getInt("assentos_J"));
        a.setAssentos_C(rs.getInt("assentos_C"));
        a.setAssentos_B(rs.getInt("assentos_B"));
        a.setAssentos_E(rs.getInt("assentos_E"));
        return a;
    }
}
