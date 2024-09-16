package View.Eventos;

import Domain.Pessoas.Jogador;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static Tools.Audio.playMusic;
import static Tools.BibliotecaFuncoes.printFile;

public class Universidade {

    /**
     * Método em que ao jogador é perguntado se quer ingressar no Ensino Superior
     * @param jogador Protagonista do jogo
     */
    public static void universidade(Jogador jogador) throws FileNotFoundException {
        System.out.println();
        System.out.println("•••••••••••••••••••••••••••••• UNIVERSIDADE •••••••••••••••••••••••••••••");
        System.out.println();
        System.out.println("Já és um homenzinho e chegou o momento de tomares uma decisão importante para o teu futuro.");
        System.out.println("Queres ir para a Universidade, " + jogador.getNome() + "?");
        System.out.println("Custa €3000, mas ganhas 50 pontos de nível de Educação, e recebes um Diploma!");
        int opcaoUniversidade;
        do {
            System.out.println();
            System.out.println("[1] SIM");
            System.out.println("[2] NÃO");
            Scanner inputUniversidade = new Scanner(System.in);
            opcaoUniversidade = inputUniversidade.nextInt();
        } while (opcaoUniversidade < 1 || opcaoUniversidade > 2);
        switch (opcaoUniversidade) {
            case 1:
                System.out.println();
                playMusic("Files/audio/universidade_s.wav"); // Correr ficheiro de áudio
                printFile("Files/ascii/universidade.txt"); // Imprimir ficheiro na consola
                System.out.println();
                System.out.println("Parabéns! Ingressaste na U.E.V. (Universidade da Escola da Vida)!");
                System.out.println("Tinhas €" + jogador.getDinheiro() + " na conta bancária e eras um burro, com uns míseros " + jogador.getEducacao() + " pontos de nível de Educação.");
                jogador.setEducacao(jogador.getEducacao() + 50); // Subir 50 níveis de Educação
                jogador.setDinheiro(jogador.getDinheiro() - 3000); // Retirar €3000 ao dinheiro do jogador
                jogador.setDiploma(true); // Atribuir valor true ao atributo diploma, indicando que concluiu Ensino Superior
                System.out.println("Agora ficaste mais pobre, porque gastaste €3000 e passaste a ter €" + jogador.getDinheiro() + " na conta bancária, mas para compensar agora tens " + jogador.getEducacao() + " pontos de nível de Educação, e um Diploma!");
                System.out.println();
                break;
            case 2:
                playMusic("Files/audio/universidade_n.wav"); // Correr ficheiro de áudio
                System.out.println("Parabéns! Escolheste poupar os teus €" + jogador.getDinheiro() + " e continuar a ser um burro, porque continuas a ter os mesmos " + jogador.getEducacao() + " pontos de nível de Educação, e não tens Diploma nenhum...");
                System.out.println();
                break;
            default:
                // Opção controlada pelo do while em cima, que só permite escolher uma das opções válidas
                break;
        }
        System.out.println();
        System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
        System.out.println();
    }
}