package View;

import Domain.Pessoas.Jogador;
import Domain.Pessoas.NPC;
import Domain.Pessoas.Profissao;
import View.Shopping.Shopping;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static Controllers.ResetAll.resetAll;
import static Tools.Audio.playMusic;
import static Tools.BibliotecaFuncoes.endCredits;
import static View.Ciclos.ciclos;
import static View.Sims.jogo;

public class Repetir {

    /**
     * Método que pergunta se o utilizador quer jogar de novo.
     *
     * @param jogador      Protagonista do jogo
     * @param profissoes   Conjunto de profissões
     * @param pessoas      Conjunto de pessoas NPC
     * @param contadorDias Contador de dias
     * @param chopisCentis Shopping
     */
    public static void repetir(Jogador jogador, ArrayList<Profissao> profissoes, ArrayList<NPC> pessoas, int contadorDias, Shopping chopisCentis) throws FileNotFoundException, InterruptedException {
        int opcaoRepeat;
        do {
            System.out.println();
            System.out.println("Queres jogar de novo?");
            System.out.println("[1] SIM, outra vez com o " + jogador.getNome());
            System.out.println("[2] SIM, mas agora quero encontrar outro recém-nascido no lixo");
            System.out.println("[3] NÃO");
            System.out.print("Introduz uma das opções: ");
            Scanner inputRepeat = new Scanner(System.in); // Instanciar um scanner para receber o input do utilizador
            opcaoRepeat = inputRepeat.nextInt(); // Gravar o input
            System.out.println();
        } while (opcaoRepeat < 1 || opcaoRepeat > 3); // Garante que a opção seja uma das indicadas (de 1 a 3), caso contrário mostra novamente as opções.
        contadorDias = 1; // Fazer reset ao contador de dias independentemente da escolha
        switch (opcaoRepeat) {
            case 1: // Jogar de novo com o mesmo protagonista
                resetAll(jogador); // Invocar método que faz reset a todos os atributos do protagonista (excepto nome e objectivo)
                ciclos(jogador, profissoes, pessoas, contadorDias, chopisCentis); // Invocar o método de percorrer os ciclos diários da vida do protagonista
                break;
            case 2: // Jogar de novo com um novo protagonista
                resetAll(jogador); // Invocar método que faz reset a todos os atributos do protagonista
                jogo(); // Invocar o método para correr de novo o jogo do início
                break;
            case 3: // Não (sair)
                endCredits(); // Invocar o método que faz correr os créditos finais do jogo
                System.exit(0); // Encerrar o programa (fui pesquisar na internet como fazer)
                break;
            default:
                // Nunca aparece porque o ciclo do while acima já controla se a opção está compreendida entre 1 e 3
                break;
        }
    }
}