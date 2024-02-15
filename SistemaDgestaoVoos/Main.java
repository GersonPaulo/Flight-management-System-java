package SistemaDgestaoVoos;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {


    //auto generated
    // trhows is for sql exceptions to keep the program running after sql error
    public static void main(String[] args)  throws SQLException {

        // input para os objecto da classe main
        Basedados basedados = new Basedados();
        Scanner s = new Scanner(System.in);

        int i = 0;
        do {
            // comandos para o terminal
            System.out.println("Bem vindo ao Sistema de reserva de voos");
            System.out.println("1.  inserir novo passageiro");
            System.out.println("2.  Lista de passageiros");
            System.out.println("3.  Adicionar Detalhes do aviao");
            System.out.println("4.  Listar Detalhes do aviao");
            System.out.println("5.  Adicionar novo destino ao Aviao");
            System.out.println("6.  Listar Destinos do Aviao");
            System.out.println("7.  Adicionar Novo Voo");

            System.out.println(".10 Fechar programa");

            // condiçao para fazer as escolhas3
            i = s.nextInt();
            switch (i) {
                case 1:
                    ControllerPassageiros.addNovoPassageiro(basedados, s);
                    break;
                case 2:
                    ControllerPassageiros.PrintAllPassageiros(basedados);
                case 3:
                    ControllerVoos.AddNovoVoo(basedados, s);
                    break;
                case 4:
                    ControllerVoos.PrintAllVoos(basedados);
                case 5:
                    ControllerDestino.AddNovoDestino(basedados, s);
                    break;
                case 6:
                    ControllerDestino.PreintAllDestinos(basedados);
                    break;
                case 7:
                    ControllerViagem.AddNovoViagem(basedados, s);
                    break;
            }
        }while (i!=10);
    }
}

