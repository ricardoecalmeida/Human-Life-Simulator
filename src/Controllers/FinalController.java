package Controllers;

import Domain.Pessoas.Jogador;

import java.io.FileNotFoundException;

import static Tools.Audio.playMusic;
import static Tools.BibliotecaFuncoes.printFile;
import static java.lang.Thread.sleep;

public class FinalController {

    /**
     * Método que verifica se o jogador atingiu o segundo objectivo do jogo [milionário, celebridade, familia, sucesso]
     * @param jogador Protagonista do jogo
     */
    public static void finalController(Jogador jogador) throws FileNotFoundException, InterruptedException {
        switch (jogador.getObjectivo()) {
            case MILIONARIO -> {
                // Availiar se cumpriu o objectivo Milionário
                if (jogador.calcularPatrimonioTotal() >= 1000000) { // Se a soma de dinheiro com património for igual ou superior a 1000000
                    playMusic("Files/audio/objectivo_s.wav"); // Correr ficheiro de áudio
                    printFile("Files/ascii/objectivo.txt"); // Imprimir ficheiro na consola
                    printFile("Files/ascii/cumprido.txt"); // Imprimir ficheiro na consola
                    System.out.println();
                    System.out.println("PARABÉNS " + jogador.getNome() + "! Conseguiste terminar o jogo como MILIONÁRIO e atingiste o objectivo!");
                    System.out.println();
                } else { // Se a soma de dinheiro com património não for igual ou superior a 1000000
                    playMusic("Files/audio/objectivo_n.wav"); // Correr ficheiro de áudio
                    printFile("Files/ascii/objectivo.txt"); // Imprimir ficheiro na consola
                    printFile("Files/ascii/falhado.txt"); // Imprimir ficheiro na consola
                    System.out.println();
                    System.out.println("Não conseguiste atingir o objectivo de ser MILIONÁRIO. Perdeste o jogo...");
                    System.out.println();
                }
                break; // IDE diz que é desnecessário e fora das chavetas dá erro, pelo que deixo ficar só para dizer que não me esqueci.
            }
            case CELEBRIDADE -> {
                // Availiar se cumpriu o objectivo Celebridade
                if (jogador.getCelebridade()) { // Se o jogador for uma celebridade
                    playMusic("Files/audio/objectivo_s.wav"); // Correr ficheiro de áudio
                    printFile("Files/ascii/objectivo.txt"); // Imprimir ficheiro na consola
                    printFile("Files/ascii/cumprido.txt"); // Imprimir ficheiro na consola
                    System.out.println();
                    System.out.println("PARABÉNS " + jogador.getNome() + "! Conseguiste terminar o jogo como CELEBRIDADE e atingiste o objectivo!");
                    System.out.println();
                } else {
                    playMusic("Files/audio/objectivo_n.wav"); // Correr ficheiro de áudio
                    printFile("Files/ascii/objectivo.txt"); // Imprimir ficheiro na consola
                    printFile("Files/ascii/falhado.txt"); // Imprimir ficheiro na consola
                    System.out.println();
                    System.out.println("Não conseguiste atingir o objectivo de ser CELEBRIDADE. Perdeste o jogo...");
                    System.out.println();
                }
                break; // IDE diz que é desnecessário e fora das chavetas dá erro, pelo que deixo ficar só para dizer que não me esqueci.
            }
            case FAMILIA -> {
                // Availiar se cumpriu o objectivo Família
                if (jogador.getFamilia().size() >= 5) { // Se o jogador tiver 5 ou mais NPC na família
                    playMusic("Files/audio/objectivo_s.wav"); // Correr ficheiro de áudio
                    printFile("Files/ascii/objectivo.txt"); // Imprimir ficheiro na consola
                    printFile("Files/ascii/cumprido.txt"); // Imprimir ficheiro na consola
                    System.out.println();
                    System.out.println("PARABÉNS " + jogador.getNome() + "! Conseguiste terminar o jogo com uma FAMÍLIA numerosa e atingiste o objectivo!");
                    System.out.println();
                } else {
                    playMusic("Files/audio/objectivo_n.wav"); // Correr ficheiro de áudio
                    printFile("Files/ascii/objectivo.txt"); // Imprimir ficheiro na consola
                    printFile("Files/ascii/falhado.txt"); // Imprimir ficheiro na consola
                    System.out.println();
                    System.out.println("Não conseguiste atingir o objectivo de ter uma FAMÍLIA numerosa. Perdeste o jogo...");
                    System.out.println();
                }
                break; // IDE diz que é desnecessário e fora das chavetas dá erro, pelo que deixo ficar só para dizer que não me esqueci.
            }
            case SUCESSO -> {
                // Availiar se cumpriu o objectivo Sucesso
                if (jogador.getDiploma() && jogador.getEducacao() >= 70) { // Se o jogador tiver curso superior (Universidade) e pelo menos 70 de nível de Educação
                    playMusic("Files/audio/objectivo_s.wav"); // Correr ficheiro de áudio
                    printFile("Files/ascii/objectivo.txt"); // Imprimir ficheiro na consola
                    printFile("Files/ascii/cumprido.txt"); // Imprimir ficheiro na consola
                    System.out.println();
                    System.out.println("PARABÉNS " + jogador.getNome() + "! Conseguiste terminar o jogo com SUCESSO profissional e atingiste o objectivo!");
                    System.out.println();
                } else {
                    playMusic("Files/audio/objectivo_n.wav"); // Correr ficheiro de áudio
                    printFile("Files/ascii/objectivo.txt"); // Imprimir ficheiro na consola
                    printFile("Files/ascii/falhado.txt"); // Imprimir ficheiro na consola
                    System.out.println();
                    System.out.println("Não conseguiste atingir o objectivo de ter SUCESSO profissional. Perdeste o jogo...");
                    System.out.println();
                }
                break; // IDE diz que não é necessário, mas deixo ficar só para dizer que não me esqueci.
            }
            case null, default -> {
                // Se chegou aqui, algo de errado não está certo... O jogador é sempre instanciado com um
                // objectivo definido, portanto a variável deve conter sempre um dos valores acima.
                break; // IDE diz que é desnecessário e fora das chavetas dá erro, pelo que deixo ficar só para dizer que não me esqueci.
            }
        }
        sleep(5000); // Esperar 5 segundos para que o áudio seja corrido
    }
}