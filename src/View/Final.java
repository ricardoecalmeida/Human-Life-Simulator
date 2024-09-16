package View;

import Domain.Pessoas.Jogador;
import Domain.Pessoas.NPC;
import Domain.Pessoas.Profissao;
import View.Shopping.Shopping;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static Controllers.FinalController.finalController;
import static Domain.Pessoas.Jogador.exibirDetalhesFamilia;
import static Domain.Propriedades.Propriedade.exibirDetalhesPropriedades;
import static Tools.Audio.playMusic;
import static Tools.BibliotecaFuncoes.endCredits;
import static Tools.BibliotecaFuncoes.printFile;
import static View.Repetir.repetir;
import static java.lang.Thread.sleep;

public class Final {

    /**
     * Método que avalia se o jogador cumpriu o primeiro objectivo do jogo (terminar sem dívidas).
     *
     * @param jogador      Protagonista do jogo
     * @param profissoes   Conjunto de profissões
     * @param pessoas      Conjunto de pessoas NPC
     * @param contadorDias Contador de dias
     * @param chopisCentis Shopping
     */
    public static void finalJogo(Jogador jogador, ArrayList<Profissao> profissoes, ArrayList<NPC> pessoas, int contadorDias, Shopping chopisCentis) throws FileNotFoundException, InterruptedException {
        System.out.println();
        System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
        System.out.println();
        playMusic("Files/audio/morte.wav"); // Correr ficheiro de áudio
        printFile("Files/ascii/morte.txt"); // Imprimir ficheiro na consola
        sleep(3200); // Esperar 19 segundos para que o áudio seja corrido
        System.out.println();
        System.out.println(jogador.getNome() + ", estás no teu leito de morte, a pensar se deves dinheiro a alguém e se cumpriste o objectivo de vida a que te propuseste.");
        sleep(3200); // Esperar 19 segundos para que o áudio seja corrido
        System.out.println();
        // Avaliar se o protagonista terminou o jogo com dívidas
        if (jogador.getDinheiro() < 0) { // Se tem dívidas
            System.out.println("Não se morre assim, a dever €" + jogador.getDinheiro() + " aos outros!");
            sleep(5300); // Esperar 19 segundos para que o áudio seja corrido
            System.out.println();
            System.out.println("Devias ter morrido só depois de pagar o que deves!");
            sleep(5300); // Esperar 19 segundos para que o áudio seja corrido
            System.out.println();
            System.out.println(jogador.getNome() + ", perdeste a vida e também perdeste o jogo, seu falhado!");
            sleep(5300); // Esperar 19 segundos para que o áudio seja corrido
            repetir(jogador, profissoes, pessoas, contadorDias, chopisCentis); // Invocar o método que pergunta se o utilizador quer jogar de novo
            System.out.println();
        } else { // Se não tem dívidas
            System.out.println(jogador.getNome() + ", morreste, mas ao menos não ficaste a dever dinheiro a ninguém...");
            sleep(3200); // Esperar 19 segundos para que o áudio seja corrido
            System.out.println();
            System.out.println("Deixaste €" + jogador.getDinheiro() + " na conta bancária e €" + jogador.calcularValorPatrimonial() + " de património estimado.");
            sleep(3200); // Esperar 19 segundos para que o áudio seja corrido
            System.out.println();
            exibirDetalhesPropriedades(jogador.getPropriedades());
            if (jogador.getPropriedades().size() == 0) {
                System.out.println("— Nada desta vida. Sabes o que é nada desta vida?");
            }
            sleep(3200); // Esperar 19 segundos para que o áudio seja corrido
            System.out.println();
            System.out.print("Herdeiros/Membros da ");
            exibirDetalhesFamilia(jogador.getFamilia());
            if (jogador.getFamilia().size() == 0) {
                System.out.println("— Ninguém...");
            }
            System.out.println();
            sleep(3200); // Esperar 19 segundos para que o áudio seja corrido
            finalController(jogador); // Invocar o método que verifica se o jogador atingiu o segundo objectivo do jogo
        }
        repetir(jogador, profissoes, pessoas, contadorDias, chopisCentis); // Invocar o método que pergunta se o utilizador quer jogar de novo
    }
}