package SistemaDgestaoVoos;

//imports

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerDestino {
    //metodos da classe,  abaixo -

    //metodo para adicionar novos destinos
    public static void AddNovoDestino(Basedados basedados, Scanner scanner) throws SQLException{

        //input para pais de destion
        System.out.println("Adicionar pais de destino: ");
        String pais = scanner.next();
        int id_d;
        ArrayList<Destino> destinos = getAllDestinos(basedados);

        // tira o valor da base de dados para a lista destinos
        if(destinos.size()!=0) {
            id_d = destinos.get(destinos.size() - 1).getId_d() + 1;
        }
        else {
            id_d = 0;
        }

        // instacia da classe
        Destino destino = new Destino();
        destino.setId_d(id_d);
        destino.setPais(pais);

        // para inserir os inputs a base de dados
        String insert = "INSERT INTO `destinos`(`id_d`, `pais`) VALUES ('"+
                destino.getId_d()+"','"+destino.getPais()+"');";
        basedados.getStatement().execute(insert);
        System.out.println("Destino adicionado com sucesso: ");
    }
    // metodo para cria a lista com todas as cidades
    public static ArrayList<Destino> getAllDestinos(Basedados basedados) throws SQLException {
        ArrayList<Destino> destinos = new ArrayList<>();
        String select = "SELECT * FROM `destinos`;";
        ResultSet rs = basedados.getStatement().executeQuery(select);

        // loop para adicionar valores a lista destinos
        while (rs.next()){

            //intancia da classe
            Destino d = new Destino();
            d.setId_d(rs.getInt("id_d"));
            d.setPais(rs.getString("pais"));
            destinos.add(d);
        }
        return destinos;
    }

    //printa todos dados da lista destinos
    public static void PreintAllDestinos(Basedados basedados) throws SQLException{
        System.out.println("--------------------------------------------------");
        System.out.println("id\tPais");
        // ciclo para printar cada lista destino gerada
        for (Destino d : getAllDestinos(basedados)){
            d.print();
        }
        System.out.println("--------------------------------------------------");
    }
    /*para recordar

   */
    //controller class para os metodos da classe destino = ControllerDestinos
    //id = id_D
    // pais = Destino
    // city = pais

    public static Destino GetDestino(Basedados basedados, int id_d) throws SQLException {
        Destino destino = new Destino();
        String select = "SELECT `id_d`, `pais` FROM `destinos` WHERE `id_d` = "+id_d+" ;";
        ResultSet rs = basedados.getStatement().executeQuery(select);
        rs.next();
        destino.setId_d(rs.getInt("id_d"));
        destino.setPais(rs.getString("pais"));
        return destino;
    }
}
