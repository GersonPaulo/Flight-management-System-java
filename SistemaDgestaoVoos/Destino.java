package SistemaDgestaoVoos;

public class Destino {

    //objectos da classe destino
    private int id_d; // identificador do Destino
    private String pais; // pais a qual se quer viajar

    public Destino() { }

    public int getId_d() {
        return id_d;
    }

    public void setId_d(int id_d) {
        this.id_d = id_d;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void print() {
        System.out.println(id_d+"\t"+pais);
    }


}
