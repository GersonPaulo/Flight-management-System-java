package SistemaDgestaoVoos;




// seria a classe Voos mas devido erros mudei para aviao
public class Aviao {

    public Aviao() {}

    private int assentos; // Número de assentos disponíveis
    private int assentos_J; // Assentos na janela
    private int assentos_C;  // Assentos no corredor
    private int assentos_B; // Business Classe
    private int assentos_E; // económico
    private int id_voo; //id unico  do voo


    // objectos (set and get) auto generated by generate getter and setter
    public int getAssentos() {
        return assentos;
    }

    public void setAssentos(int assentos) {
        this.assentos = assentos;
    }

    public int getAssentos_J() {
        return assentos_J;
    }

    public void setAssentos_J(int assentos_J) {
        this.assentos_J = assentos_J;
    }

    public int getAssentos_C() {
        return assentos_C;
    }

    public void setAssentos_C(int assentos_C) {
        this.assentos_C = assentos_C;
    }

    public int getAssentos_B() {
        return assentos_B;
    }

    public void setAssentos_B(int assentos_B) {
        this.assentos_B = assentos_B;
    }

    public int getAssentos_E() {
        return assentos_E;
    }

    public void setAssentos_E(int assentos_E) {
        this.assentos_E = assentos_E;
    }

    public int getId_voo() {
        return id_voo;
    }

    public void setId_voo(int id_voo) {
        this.id_voo = id_voo;
    }

    public void print(){
        System.out.println("id_voo: "+id_voo);
        System.out.println("Total de Assentos: "+assentos);
        System.out.println("Assentos do lado da janela: "+assentos_J);
        System.out.println("Assentos do lado do corredor: "+assentos_C);
        System.out.println("Asssentos Classe Economica: "+assentos_E);
        System.out.println("Assentos Classe Business: "+assentos_B);
    }
}
