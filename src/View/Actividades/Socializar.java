package View.Actividades;

import Domain.Bebida;
import Domain.Pessoas.Jogador;

import java.util.Scanner;

public class Socializar {

    /**
     * Método em que o jogador vai fazer a actividade socializar
     *
     * @param jogador Protagonista do jogo
     */
    public static void tasco(Jogador jogador) {
        // Instanciar objectos do tipo Bebida
        // Vai sair sempre esta bebida, independentemente da escolha do jogador
        Bebida whiskey = Bebida.getInstance("Uísque Singleton");
        Bebida aguardente = Bebida.getInstance("Aguardente CRF");
        Bebida brandy = Bebida.getInstance("Brandy Macieira");
        Bebida gin = Bebida.getInstance("Gin Gondon's");
        Bebida vermute = Bebida.getInstance("Vermute Martini");
        Bebida cachaca = Bebida.getInstance("Cachaça Leblon");
        Bebida vodka = Bebida.getInstance("Vodca Smirnoff");
        Bebida rum = Bebida.getInstance("Rum Captain Morgan");
        Bebida tequila = Bebida.getInstance("Tequila Silevr Sierra");
        Bebida porto = Bebida.getInstance("Vinho do Porto Kopke");

        System.out.println("ter com os amigos.");
        System.out.println();
        System.out.println("Bem-vindo ao TASCO'TAU!");
        int opcaoTasco;
        do {
            System.out.println();
            System.out.println("O que queres beber, " + jogador.getNome() + "?");
            System.out.println("[0] Aguardente CRF");
            System.out.println("[1] Brandy Macieira");
            System.out.println("[2] Gin Gondon's");
            System.out.println("[3] Vermute Martini");
            System.out.println("[4] Cachaça Leblon");
            System.out.println("[5] Uísque Jack Daniel's");
            System.out.println("[6] Vodca Smirnoff");
            System.out.println("[7] Rum Captain Morgan");
            System.out.println("[8] Tequila Silevr Sierra");
            System.out.println("[9] Vinho do Porto Kopke");
            System.out.print(jogador.getNome() + ", insere a tua opção: ");
            Scanner inputBebida = new Scanner(System.in);
            opcaoTasco = inputBebida.nextInt();
        } while (opcaoTasco < 0 || opcaoTasco > 9);
        System.out.println();
        switch (opcaoTasco) {
            case 0:
                System.out.println("O " + jogador.getNome() + " pediu Aguardente CRF.");
                System.out.println("Passado uns minutos foi-lhe servido " + aguardente.getNome() + ".");
                System.out.println();
                break;
            case 1:
                System.out.println("O " + jogador.getNome() + " pediu Brandy Macieira.");
                System.out.println("Passado uns minutos foi-lhe servido " + brandy.getNome() + ".");
                System.out.println();
                break;
            case 2:
                System.out.println("O " + jogador.getNome() + " pediu Gin Gondon's.");
                System.out.println("Passado uns minutos foi-lhe servido " + gin.getNome() + ".");
                System.out.println();
                break;
            case 3:
                System.out.println("O " + jogador.getNome() + " pediu Vermute Martini.");
                System.out.println("Passado uns minutos foi-lhe servido " + vermute.getNome() + ".");
                System.out.println();
                break;
            case 4:
                System.out.println("O " + jogador.getNome() + " pediu Cachaça Leblon.");
                System.out.println("Passado uns minutos foi-lhe servido " + cachaca.getNome() + ".");
                System.out.println();
                break;
            case 5:
                System.out.println("O " + jogador.getNome() + " pediu Uísque Jack Daniel's.");
                System.out.println("Passado uns minutos foi-lhe servido " + whiskey.getNome() + ".");
                System.out.println();
                break;
            case 6:
                System.out.println("O " + jogador.getNome() + " pediu Vodka Smirnoff.");
                System.out.println("Passado uns minutos foi-lhe servido " + vodka.getNome() + ".");
                System.out.println();
                break;
            case 7:
                System.out.println("O " + jogador.getNome() + " pediu Rum Captain Morgan.");
                System.out.println("Passado uns minutos foi-lhe servido " + rum.getNome() + ".");
                System.out.println();
                break;
            case 8:
                System.out.println("O " + jogador.getNome() + " pediu Tequila Silevr Sierra.");
                System.out.println("Passado uns minutos foi-lhe servido " + tequila.getNome() + ".");
                System.out.println();
                break;
            case 9:
                System.out.println("O " + jogador.getNome() + " pediu Vinho do Porto Kopke.");
                System.out.println("Passado uns minutos foi-lhe servido " + porto.getNome() + ".");
                System.out.println();
                break;
            default: // Nunca chega ao default porque as opções já estão controladas no ciclo do while acima
                break;
        }
        System.out.println("\"Sabe, é que esta lista já é antiga e agora temos um patrocínio de uma marca de uísque,");
        System.out.println("e com esta situação do contrato de exclusividade que assinamos, só podemos vender a marca deles...\"");
        System.out.println();
        System.out.println("O uísque custou-te €5.");
        jogador.setDinheiro(jogador.getDinheiro() - 5); // Retirar €5 ao dinheiro do jogador
        jogador.setSocial(100); // Repor a necessidade social de volta a 100 (máximo)
        System.out.println();
    }
}
