package SistemaDgestaoVoos;

public class Passageiro {

    // dados do passageiro podemos apenas aceder apenas apartir da classe passageiro
    private String pr_Nome; // first name
    private String ul_Nome; // last name
    private String passport;  // passaporte
    private String idade; // age
    private int id; //id unico do passageiro

    //classe passageiro
    public Passageiro() {}


    //instacia id
    public void setId ( int id){
        this.id = id;
    }
    public int getId () {
        return id;
    }


    // instancia primeiro nome
    public void setPr_Nome (String pr_Nome){
        this.pr_Nome = pr_Nome;
    }
    public String getPr_Nome () {
        return pr_Nome;

    }
    //instancia do ultimo nome
    public void setUl_Nome (String ul_Nome){
        this.ul_Nome = ul_Nome;
    }
    public String getUl_Nome () {
        return ul_Nome;
    }


    //instancia do numero do passaporte
    public void setPassport (String passport){
        this.passport = passport;
    }
    public String getPassport () {
        return passport;
    }

    //instancia da age
    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }
}








