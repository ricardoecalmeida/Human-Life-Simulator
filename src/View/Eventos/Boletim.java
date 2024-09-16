package View.Eventos;

import Domain.Pessoas.Jogador;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static Tools.Audio.playMusic;
import static Tools.BibliotecaFuncoes.printFile;
import static Tools.BibliotecaFuncoes.sorteioEuromilhoes;

public class Boletim {

    /**
     * Método em que o jogador encontra um boletim do Euromilhões e tem de tomar uma decisão
     *
     * @param jogador Protagonista do jogo
     */
    public static void boletim(Jogador jogador) throws FileNotFoundException {
        System.out.println();
        System.out.println("••••••••••••••••••••••••• BOLETIM DO EUROMILHÕES ••••••••••••••••••••••••");
        System.out.println();
        System.out.println(jogador.getNome() + ", encontraste um boletim do Euromilhões à porta da tabacaria!");
        System.out.println("Olhas para a data e o sorteio ainda não saiu.");
        System.out.println("O que fazes?");
        System.out.println("- Olhas em redor para te certificares que não estão a ver-te, apanhas o boletim e metes ao bolso. Pode sair-te a sorte grande!");
        System.out.println("- Pões-lhe uma pedra em cima para não voar, porque pode ser de alguém que o tenha perdido.");
        int opcaoEuromilhoes;
        do {
            System.out.println();
            System.out.println("[1] Siga para o bolso, antes que alguém veja");
            System.out.println("[2] Calhau pra cima dele");
            System.out.print("Introduz uma das opções: ");
            Scanner inputEuromilhoes = new Scanner(System.in);
            opcaoEuromilhoes = inputEuromilhoes.nextInt();
        } while (opcaoEuromilhoes < 1 || opcaoEuromilhoes > 2);
        switch (opcaoEuromilhoes) {
            case 1: // Leva o boletim
                System.out.println();
                System.out.println("Levas o boletim para casa, ligas a televisão e aguardas ansiosamente pelo sorteio...");
                System.out.println("Estão a sair os números...");
                sorteioEuromilhoes(jogador); // Invocar o método de sortear um boletim
                System.out.println();
                System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
                System.out.println();
                break;
            case 2: // Deixa o boletim
                System.out.println();
                System.out.println("Um velhote está a remexer os bolsos com ar de quem perdeu alguma coisa...");
                System.out.println("Perguntas-lhe se está à procura de um boletim do Euromilhões, ao que ele responde que sim.");
                System.out.println("Para agradecer o gesto, convida-te para ir tomar um Singleton ao tasco, e ficam amigos.");
                System.out.println("Passado uns dias, liga-te e ficas a saber que ganhou o primeiro prémio!");
                System.out.println();
                playMusic("Files/audio/dinheiro.wav"); // Correr ficheiro de áudio
                printFile("Files/ascii/dinheiro.txt"); // Imprimir ficheiro na consola
                System.out.println();
                System.out.println("Como foste um querido, transfere €1000000 para a tua conta, porque o resto do prémio já lhe chega bem para o resto da vida.");
                jogador.setDinheiro(jogador.getDinheiro() + 1000000); // Adicionar €1000000 ao dinheiro do jogador
                System.out.println(jogador.getNome() + ", tens agora na conta bancária €" + jogador.getDinheiro() + ".");
                System.out.println();
                System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
                System.out.println();
                break;
            default:
                // Opção controlada pelo do while em cima, que só permite escolher uma das opções válidas
                break;
        }
    }
}