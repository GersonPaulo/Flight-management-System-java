package SistemaDgestaoVoos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Basedados {

    //objectos da classse basedados e vars de acesso a base de dados.
    private String url = "jdbc:mysql://localhost/sgd";
    private String user = "igor";
    private String password = "2000";
    private Statement statement;


    //metodo da base de dados
    public Basedados() throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                               ResultSet.CONCUR_READ_ONLY);

    }

    //Metodos para addicionar novos passageiros a tabela passageiros
    public void AddPassageiro(Passageiro p) throws SQLException{
        String insert = "INSERT INTO `passageiros`(`id`, `pr_Nome`, `ul_Nome`,"
                +" `passport`, `idade`) VALUES ('"+p.getId()+"','"+p.getPr_Nome()+"','"
                +p.getUl_Nome()+"','"+p.getPassport()+"','"+p.getIdade()+"');";
        statement.execute(insert);
    }
    public ArrayList<Passageiro> getAllPassageiros() throws SQLException{

        String get = "SELECT * FROM `passageiros`;"; // get dados da table passageiros
        ResultSet rs = statement.executeQuery(get);// query
        ArrayList<Passageiro> passageiros = new ArrayList<>();



        while(rs.next()){
            Passageiro p = new Passageiro();
            p.setId(Integer.parseInt(rs.getString("id")));
            p.setPr_Nome(rs.getString(("pr_Nome")));
            p.setUl_Nome(rs.getString(("ul_Nome")));
            p.setPassport(rs.getString(("passport")));
            p.setIdade(rs.getString(("idade")));
            passageiros.add(p);
        }
        return passageiros;


    }
    public Statement getStatement() {
        return statement;
    }





}