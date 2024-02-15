package SistemaDgestaoVoos;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Viagem {

    private int id_viagem; // id da viagem
    private Aviao aviao; // voo
    private Destino origem; // pais saida
    private Destino arrival; // pais entrada
    private LocalDateTime departureTime; // hora de saida
    private LocalDateTime arrivalTime; // hora de entrada
    private int buyassentos_E; // economica
    private int buyassentos_B; // business
    private int buyassentos_C; // lado do corredor
    private int buyassentos_J; // lado da janela
    private Passageiro[] passageiros; // passageiros
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd::HH:mm:ss");

    public Viagem (){
        buyassentos_E= 0;
        buyassentos_B= 0;
        buyassentos_C= 0;
        buyassentos_J= 0;

        //stuff = new Employee[10];
    }


    public int getId_viagem() {
        return id_viagem;
    }

    public void setId_viagem(int id_viagem) {
        this.id_viagem = id_viagem;
    }

    public Aviao getAviao() {
        return aviao;
    }


    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
        int totalCapacity = aviao.getAssentos_B()+ aviao.getAssentos_E()+ aviao.getAssentos_J()+aviao.getAssentos_C();
        passageiros= new Passageiro[totalCapacity];
    }

    public Destino getOrigem() {
        return origem;
    }

    public void setOrigem(Destino origem) {
        this.origem = origem;
    }

    public Destino getArrival() {
        return arrival;
    }

    public void setArrival(Destino arrival) {
        this.arrival = arrival;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getBuyAssentos_E() {
        return buyassentos_E;
    }

    public void setBuyAssentos_E(int buyassentos_E) {
        this.buyassentos_E = buyassentos_E;
    }

    public int getBuyAssentos_B() {
        return buyassentos_B;
    }

    public void setBuyAssentos_B(int buyassentos_B) {
        this.buyassentos_B = buyassentos_B;
    }

    public Passageiro[] getPassageiros() {
        return passageiros;
    }

    public void setPassageiros(Passageiro[] passageiros) {
        this.passageiros = passageiros;
    }

    public DateTimeFormatter getFormatter() {
        return formatter;
    }

    public void setFormatter(DateTimeFormatter formatter) {
        this.formatter = formatter;
    }

    public int getBuyAssentos_C() {
        return buyassentos_C;
    }

    public void setBuyAssentos_C(int buyassentos_C) {
        this.buyassentos_C = buyassentos_C;
    }

    public int getBuyAssentos_J() {
        return buyassentos_J;
    }

    public void setBuyAssentos_J(int buyAssentosJ) {
        buyassentos_J = buyassentos_J;
    }

    public Destino getOriginDestino() {
        return origem;
    }
    public void setOrigemDestino(Destino origem) {
        this.origem = origem;
    }
    public Destino getDestinoArrival() {
        return arrival;
    }
    public void setDestinoArrival(Destino arrival) {
        this.arrival = arrival;
    }
}
