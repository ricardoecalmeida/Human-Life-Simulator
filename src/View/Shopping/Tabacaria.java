package View.Shopping;

import Domain.Pessoas.Jogador;
import Domain.Pessoas.NPC;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static Tools.BibliotecaFuncoes.sorteioEuromilhoes;

public class Tabacaria {

    /**
     * Método onde o jogador pode escolher várias opções da Tabacaria.
     * @param jogador Protagonista do jogo
     * @param pessoas Conjunto de pessoas NPC
     */
    public static void tabacaria(Jogador jogador, ArrayList<NPC> pessoas) throws FileNotFoundException {
        System.out.println();
        System.out.println(jogador.getNome() + ", o que queres da Tabacaria?");
        int opcaoTabacaria;
        do {
            System.out.println();
            System.out.println("[1] Jogar no Euromilhões");
            System.out.println("[2] Enviar uma carta");
            System.out.println("[3] Comprar um maço de tabaco");
            System.out.print("Insere a tua escolha: ");
            Scanner inputTabacaria = new Scanner(System.in);
            opcaoTabacaria = inputTabacaria.nextInt();
        } while (opcaoTabacaria < 1 || opcaoTabacaria > 3); // Vai correr o ciclo enquanto as opções não forem compreendidas entre 1 e 3
        switch (opcaoTabacaria) {
            case 1:
                euromilhoes(jogador); // Invocar a função de jogar no Euromilhões
                break;
            case 2:
                carta(jogador, pessoas); // Invocar a função de enviar uma carta
                break;
            case 3:
                tabaco(jogador); // Invocar a função de comprar tabaco
                break;
            default: // Opção inválida, mas nunca aparece porque já está controlada no ciclo do while em cima
                break;
        }
    }

    /**
     * Método para o Jogador fazer uma aposta no Euromilhões.
     *
     * @param jogador Protagonista do jogo
     */
    public static void euromilhoes(Jogador jogador) throws FileNotFoundException {
        System.out.println();
        System.out.println("Este Euromilhões é uma versão alternativa do original, portanto não tem 5 números de 1 a 50, nem 2 estrelas de 1 a 12.");
        System.out.println("Tem um número de 0 a 999999 que é para não complicar muito, e é se queres...");
        System.out.println("O programador acha que não ia conseguir desenvolver essa proeza dos 5 números e das 2 estrelas.");
        System.out.println("E, mesmo que conseguisse, não se pode dar ao luxo de andar a perder esse tempo com essas brincadeiras porque tem mais que fazer.");
        System.out.println("Preço: €10");
        int opcaoEuromilhoes;
        do {
            System.out.println();
            System.out.println(jogador.getNome() + ", queres jogar no Euromilhões?");
            System.out.println("[1] SIM");
            System.out.println("[2] NÃO");
            System.out.print("Insere uma das opções: ");
            Scanner inputEuromilhoes = new Scanner(System.in);
            opcaoEuromilhoes = inputEuromilhoes.nextInt();
        } while (opcaoEuromilhoes < 1 || opcaoEuromilhoes > 2);
        switch (opcaoEuromilhoes) {
            case 1:
                System.out.println();
                System.out.println("A aposta custou-te €10.");
                jogador.setDinheiro(jogador.getDinheiro() - 10); // Retirar €10 ao dinheiro  para pagamento da aposta
                sorteioEuromilhoes(jogador); // Invocar o método que sorteia um prémio do Euromilhões
                break;
            case 2:
                System.out.println("Dizes ao funcionário da tabacaria que tens de ir à casa de banho, e bazas...");
                System.out.println();
                break;
            default:
                break;
        }
        System.out.println();
    }

    /**
     * Método para o Jogador enviar uma carta a um/a amigo/a.
     * @param jogador Protagonista do jogo
     * @param pessoas Conjunto de pessoas NPC
     */
    public static void carta(Jogador jogador, ArrayList<NPC> pessoas) {
        System.out.println();
        System.out.print("Muito querido, " + jogador.getNome() + "! ");
        Random randomNumber = new Random(); // Instanciar um objecto Random
        // Gerar um número aleatório com base no tamanho da ArrayList de pessoas e gravar numa variável
        int randomNPC = randomNumber.nextInt(0, pessoas.size()); // Definir como limite o tamanho do ArrayList pessoas
        NPC destinatario = pessoas.get(randomNPC); // Aceder ao elemento (pessoa NPC) na posição foi que gerada aleatoriamente
        jogador.setDinheiro(jogador.getDinheiro() - 1); // Retirar €1 ao dinheiro do jogador
        System.out.println("Enviaste uma carta para " + destinatario.getNome() + " e gastaste €1.");
        System.out.println();
    }

    /**
     * Método para o jogador comprar tabaco.
     *
     * @param jogador Protagonista do jogo
     */
    public static void tabaco(Jogador jogador) {
        System.out.println();
        jogador.setDinheiro(jogador.getDinheiro() - 5); // Retirar €5 da conta do Jogador
        System.out.println("O maço de tabaco custou €5.");
        System.out.println("Isto faz-te mal à saúde, " + jogador.getNome() + ", e estás a gastar dinheiro sem necessidade...");
        System.out.println();
    }
}