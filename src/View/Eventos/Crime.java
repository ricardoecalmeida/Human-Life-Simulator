package View.Eventos;

import Domain.Pessoas.Jogador;
import Domain.Pessoas.Profissao;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import static Tools.Audio.playMusic;
import static Tools.BibliotecaFuncoes.printFile;

public class Crime {

    /**
     * Método em que o jogador tem de decidir se comete ou não um crime
     *
     * @param jogador Protagonista do jogo
     */
    public static void crime(Jogador jogador) throws FileNotFoundException {
        System.out.println();
        System.out.println("••••••••••••••••••••••••••••••••• CRIME •••••••••••••••••••••••••••••••••");
        System.out.println();
        System.out.println(jogador.getNome() + ", devido à tua posição priveligiada no negócio de " + jogador.getProfissao().getNome() + ",\nsurgiu a oportunidade de desviar uma avultada quantia em dinheiro para ti, sem que ninguém descubra.");
        System.out.println("Existe sempre a hipótese de seres apanhado, claro, e se isso acontecer estás quilhado.");
        System.out.println("Por outro lado, a oportunidade de conseguir €500000 sem que ninguém repare em nada muito é tentadora.");
        System.out.println("Estás a pensar se vale a pena arriscar...");
        int opcaoCrime;
        do {
            System.out.println();
            System.out.println("[1] SIM");
            System.out.println("[2] NÃO");
            System.out.print("Insere uma das opções: ");
            Scanner inputCrime = new Scanner(System.in);
            opcaoCrime = inputCrime.nextInt();
        } while (opcaoCrime < 1 || opcaoCrime > 2);
        switch (opcaoCrime) {
            case 1: // Se o jogador arrisca cometer o crime
                Random policia = new Random();
                int cadeia = policia.nextInt(0, 2); // Número aleatório entre 0 e 1 (50% de probabilidade de ser ou não apanhado)
                if (cadeia == 0) { // Se o número aleatório for 0, o jogador foi apanhado
                    System.out.println();
                    playMusic("Files/audio/crime.wav"); // Correr ficheiro de áudio
                    printFile("Files/ascii/crime.txt"); // Imprimir ficheiro na consola
                    System.out.println();
                    System.out.println("Foste apanhado, " + jogador.getNome() + "! Vais de cana para o xilindró! Agora o sol é aos quadrados!");
                    System.out.println();
                    if (jogador.getCelebridade()) {
                        jogador.setCelebridade(false);
                        System.out.println("És completamente arrasado na comunicação social e nas redes sociais.");
                        System.out.println("Deixaste de ser uma celebridade, e se esse era o teu objectivo, esquece...");
                        System.out.println();
                    }
                    if (jogador.getDiploma()) {
                        jogador.setDiploma(false);
                        System.out.println("O reitor da tua Universidade recita-te um dicionário de insultos de fio a pavio.");
                        System.out.println("O teu diploma não te vai valer de nada se algum dia atribuírem prémios de mérito aos profissionais de " + jogador.getProfissao().getNome() + ".");
                        System.out.println();
                    }
                    System.out.println("Escusado será dizer que foste despedido do cargo de " + jogador.getProfissao().getNome() + ".");
                    jogador.setProfissao(new Profissao("Recluso", "Apanhar sabonetes", 0, false, 0, 0));
                    System.out.println("Nova profissão: " + jogador.getProfissao().getNome() + " • Nova morada: Custóias • Novas funções: " + jogador.getProfissao().getFuncoes());
                    System.out.println();
                } else { // Se o número aleatório for 1, o jogador não foi apanhado
                    System.out.println();
                    playMusic("Files/audio/dinheiro.wav"); // Correr ficheiro de áudio
                    printFile("Files/ascii/dinheiro.txt"); // Imprimir ficheiro na consola
                    System.out.println();
                    System.out.println("Safaste-te e conseguiste gamar €500000 sem uma nódoa na tua reputação! Ninguém descobriu!");
                    jogador.setDinheiro(jogador.getDinheiro() + 500000); // Somar €500000 à conta bancária do jogador
                    System.out.println("Tens agora na conta bancária €" + jogador.getDinheiro() + ".");
                }
                break;
            case 2: // Se o jogador decide não cometer o crime
                System.out.println();
                System.out.println(jogador.getNome() + ", foste um lindo menino e não fizeste asneiras.");
                System.out.println("Podes seguir com a tua vida de consciência tranquila, mas és uma seca do carago.");
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