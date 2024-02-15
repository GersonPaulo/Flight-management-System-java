package SistemaDgestaoVoos;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.ArrayList;


public class ControllerPassageiros {

    //recolha dos inputs e add os dados as vars por meio do s
    public static void addNovoPassageiro(Basedados basedados, Scanner s) throws SQLException {

        System.out.println("Primeiro nome: ");
        String pr_Nome = s.next();
        System.out.println("Ultimo nome: ");
        String ul_Nome = s.next();
        System.out.println("Numero de Passaporte: ");
        String passport = s.next();
        System.out.println("idade: ");
        String idade = s.next();


        Passageiro passageiro = new Passageiro();
        passageiro.setPr_Nome(pr_Nome);
        passageiro.setUl_Nome(ul_Nome);
        passageiro.setPassport(passport);
        passageiro.setIdade(idade);


        //lista passageiros onde fica guardados os dados dos passageiros
        ArrayList<Passageiro> passageiros = basedados.getAllPassageiros();
        int id;

        //se a lista nao estiver vazia na posicao lista passageiros get id
        if (passageiros.size()!=0) {
            id = passageiros.get(passageiros.size()-1).getId()+1;
        } else {
            id = 0;
        }
        passageiro.setId(id);
        basedados.AddPassageiro(passageiro);
        System.out.println("Passageiro adicionado com sucesso");

    }



    public static void PrintAllPassageiros(Basedados basedados) throws SQLException{
            listAllPassageiros(basedados);
    }
    //Mostra todos os passageiros
    public static void listAllPassageiros(Basedados basedados) throws SQLException{

        ArrayList<Passageiro> passageiros = basedados.getAllPassageiros();

        System.out.println("\n---------------------------------------------");
        System.out.println("--lista de passageiros--");
        for (Passageiro p : passageiros) {

            System.out.println("id: "+p.getId());
            System.out.println("Nome: "+p.getPr_Nome()+" "+p.getUl_Nome());
            System.out.println("Passaporte: "+p.getPassport());
            System.out.println("Idade: "+p.getIdade());
            System.out.println("\n-----------------");


        }
        System.out.println("\n---------------------------------------------");




    }


    public static Passageiro getPassageiroByID(Basedados basedados, int id) throws SQLException {
        String get = "SELECT `id`, `pr_Nome`, `ul_Nome`, `passport`, `idade` FROM `passageiros` WHERE `id` = "+id+" ;";
        ResultSet rs = basedados.getStatement().executeQuery(get);
        rs.next();

        Passageiro p = new Passageiro();
        p.setId(Integer.parseInt(rs.getString("id")));
        p.setPr_Nome(rs.getString("pr_Nome"));
        p.setUl_Nome(rs.getString("ul_Nome"));
        p.setIdade(rs.getString("idade"));
        p.setPassport(rs.getString("passport"));
        return p;
    }
}