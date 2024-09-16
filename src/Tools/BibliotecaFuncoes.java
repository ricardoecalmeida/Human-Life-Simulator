package Tools;

import Domain.Pessoas.Jogador;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import static Tools.Audio.playMusic;
import static java.lang.Thread.sleep;

public class BibliotecaFuncoes {

    /**
     * Método que imprime uma introdução no arranque do jogo
     * @throws FileNotFoundException
     */
    public static void intro () throws FileNotFoundException {
        System.out.println();
        playMusic("Files/audio/hls_theme.wav"); // Correr ficheiro de áudio
        printFile("Files/ascii/logo.txt"); // Imprimir ficheiro na consola
        System.out.println();
        System.out.println("               [ H U M A N • L I F E • S I M U L A T O R ]               ");
        System.out.println();
        System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
        System.out.println();
        System.out.println("— Trivia:\nKlapaucius was one of the \"constructors\" in Stanislaw Lem's The Cyberiad.\nThe Cyberiad, along [the first word is a cheat code] with other books,\nwas cited by Will Wright as inspiration for his 1989 game SimCity.");
        System.out.println();
        System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
        System.out.println();
    }

    /**
     * Método que apresenta uma mensagem caso o cheat code "klapaucius" seja activado no início do jogo
     */
    public static void cheatCodeActivated() throws InterruptedException {
        playMusic("Files/audio/cheatcode.wav"); // Correr ficheiro de áudio
        sleep(9000); // Esperar 19 segundos para que o áudio seja corrido
        System.out.println();
        System.out.println("Parabéns! Introduziste o cheat code \"klapaucius\" do The Sims original.");
        System.out.println();
        System.out.println("Ganhaste o HUMAN LIFE SIMULATOR!");
        System.out.println();
        endCredits(); // Invocar o método que mostra os créditos finais
        System.exit(0); // Encerrar o programa (fui pesquisar na internet como fazer)
    }

    /**
     * Método que imprime o resumo dos níveis de necessidades [sono, fome, social] do jogador
     *
     * @param jogador Protagonista do jogo
     */
    public static void printLevels(Jogador jogador) {
        System.out.println("••••••••••••••••••••••••••••••••••••");
        System.out.println("• Sono " + jogador.getSono() + "% • Fome " + jogador.getFome() + "% • Social " + jogador.getSocial() + "% •");
        System.out.println("••••••••••••••••••••••••••••••••••••");
        System.out.println();
    }

    /**
     * Método para imprimir o conteúdo de um ficheiro na consola
     *
     * @param path Caminho do ficheiro
     * @throws FileNotFoundException Lança excepção para ficheiro não encontrado
     */
    public static void printFile(String path) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File(path)); // Instanciar um scanner com o caminho do ficheiro passado como parâmetro
        String line; // Instanciar variável que corresponde a uma linha do ficheiro
        while (fileScanner.hasNextLine()) { // Ciclo while que corre enquanto o scanner encontrar uma próxima linha
            line = fileScanner.nextLine(); // Guardar o conteúdo da linha encontrada na variável "line"
            System.out.println(line); // Imprimir o conteúdo em "line"
        }
    }

    /**
     * Método para sortear um boletim do Euromilhões
     * @param jogador Protagonista do jogo
     */
    public static void sorteioEuromilhoes(Jogador jogador) throws FileNotFoundException {
        System.out.println();
        System.out.println("Que número tens no boletim?");
        System.out.print("Insere um número de 0 a 999999: ");
        Scanner inputAposta = new Scanner(System.in); // Instanciar um scanner para ler o input do utilizador
        int aposta = inputAposta.nextInt(); // Grava o input numa variável
        Random random = new Random(); // Instanciar um objecto Random
        int sorteioEuromilhoes = random.nextInt(0, 1000000); // Probabilidade de saio o prémio de 1 num milhão
        System.out.println();
        if (aposta == sorteioEuromilhoes) { // Se o número apostado for o número sorteado...
            playMusic("Files/audio/yeah.wav"); // Correr ficheiro de áudio
            printFile("Files/ascii/dinheiro.txt"); // Imprimir ficheiro na consola
            jogador.setDinheiro(jogador.getDinheiro() + 1000000); // Ganha 1 milhão de €
            System.out.println("Saiu-te a sorte grande! Ganhaste €1000000 e agora tens na conta bancária €" + jogador.getDinheiro() + "!"); // Saiu o prémio
        } else { // Não saiu o prémio
            playMusic("Files/audio/premio_n.wav"); // Correr ficheiro de áudio
            System.out.println("Não saiu prémio...");
        }
        System.out.println();
    }

    /**
     * Método que imprime os créditos finais do jogo
     */
    public static void endCredits() throws InterruptedException {
        playMusic("Files/audio/end_credits.wav"); // Correr ficheiro de áudio
        System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
        System.out.println();
        System.out.println("               [ H U M A N • L I F E • S I M U L A T O R ]               ");
        System.out.println();
        System.out.println("                     Desenvolvido por Ricardo Almeida                    ");
        System.out.println("                        Curso Software Developer                         ");
        System.out.println("            Programação Orientada a Objectos • Design Patterns           ");
        System.out.println("                          Formador: Vítor Santos                         ");
        System.out.println("                        CESAE Digital • 2023/2024                        ");
        System.out.println();
        System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
        sleep(9000); // Esperar 9 segundos para que o áudio seja corrido
    }
}