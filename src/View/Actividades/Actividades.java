package View.Actividades;

import Domain.Pessoas.Jogador;
import Domain.Pessoas.NPC;
import Domain.Pessoas.Profissao;
import View.Shopping.Shopping;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static Controllers.LevelsController.levelsController;
import static Tools.BibliotecaFuncoes.endCredits;
import static View.Actividades.Emprego.centroEmprego;
import static View.Actividades.Dormir.dormir;
import static View.Actividades.Aprender.formacao;
import static View.Actividades.OutrasActividades.outrasActividades;
import static View.Actividades.Comer.restaurante;
import static View.Actividades.Adoptar.adoptar;
import static View.Actividades.Socializar.tasco;
import static View.Actividades.Trabalhar.trabalhar;

public class Actividades {

    /**
     * Método para o jogador escolher a actividade a realizar nos diferentes momentos do dia
     *
     * @param jogador      Protagonista do jogo
     * @param profissoes   Conjunto de profissões
     * @param pessoas      Conjunto de pessoas NPC
     * @param contadorDias Contador de dias
     * @param chopisCentis Shopping
     */
    public static void actividades(Jogador jogador, ArrayList<Profissao> profissoes, ArrayList<NPC> pessoas, int contadorDias, Shopping chopisCentis) throws FileNotFoundException, InterruptedException {
        int fazer; // Definir uma variável onde vai ser gravada a escolha do jogador
        do {
            System.out.println(jogador.getNome() + ", o que queres fazer?");
            // Esta opção só é apresentada se o protagonista for casado, até ao limite de 7 elementos na família e só até ao dia 60
            if (jogador.getCasado() && jogador.getFamilia().size() < 7 && contadorDias <= 60) {
                System.out.println();
                System.out.println("[0] Adoptar crianças");
            }
            System.out.println("[1] Trabalhar •••••••••• [Salário: €" + jogador.getProfissao().getSalarioDia() + "/dia]");
            System.out.println("[2] Dormir ••••••••••••• [Nível Sono: " + jogador.getSono() + "%]");
            System.out.println("[3] Comer •••••••••••••• [Nível Fome: " + jogador.getFome() + "%]");
            System.out.println("[4] Socializar ••••••••• [Nível Social: " + jogador.getSocial() + "%]");
            System.out.println("[5] Comprar/Vender ••••• [Nível Estatuto: " + jogador.getEstatuto() + " • Saldo: €" + jogador.getDinheiro() + "]");
            System.out.println("[6] Aprender ••••••••••• [Nível Educação: " + jogador.getEducacao() + "]");
            System.out.println("[7] Procurar emprego ••• [Profissão: " + jogador.getProfissao().getNome() + "]");
            System.out.println("[8] Outras actividades");
            System.out.println("[9] Quem é o " + jogador.getNome() + "?");
            System.out.println("[123] SAIR");
            System.out.print("Escolhe uma das hipóteses: ");
            Scanner fazerActividade = new Scanner(System.in); // Instanciar um scanner para receber o input do utilizador
            fazer = fazerActividade.nextInt(); // Gravar o input na variável "fazer"
            if (fazer == 123) { // Se a opção for sair
                endCredits(); // Invocar o método dos créditos do jogo
                System.exit(0); // Encerrar o programa (fui pesquisar na internet como fazer)
            }
            fazer = levelsController(jogador, fazer); // Invoca o método que controla os níveis de sono, fome e social do protagonista
        } while (fazer < 0 || fazer > 9); // Mostra as opções de novo até que "fazer" tenha um valor compreendido entre 0 e 9
        System.out.print("O " + jogador.getNome() + " foi ");
        switch (fazer) {
            case 0: // Adoptar crianças
                if (jogador.getCasado() && jogador.getFamilia().size() < 7 && contadorDias <= 60) {
                    adoptar(jogador, pessoas); // Invocar o método de adoptar filhos
                } else {
                    System.out.println("adoptar filhos, mas não pode...");
                    System.out.println();
                    System.out.println("Requisitos:");
                    System.out.println("- Estado Civil: Casado");
                    System.out.println("- Data limite: Dia 60");
                    System.out.println("- Máximo: 6 filhos");
                    System.out.println();
                }
                break;
            case 1: // Trabalhar
                trabalhar(jogador); // Invocar o método de trabalhar
                break;
            case 2: // Dormir
                dormir(jogador, pessoas); // Invocar método de dormir
                break;
            case 3: // Comer
                restaurante(jogador, pessoas); // Invocar método de comer
                break;
            case 4: // Socializar
                tasco(jogador); // Invocar método de socializar
                break;
            case 5: // Comprar
                // Invocar o método que leva o jogador até ao Shopping
                chopisCentis.hallShopping(jogador, profissoes, pessoas, contadorDias, chopisCentis);
                break;
            case 6: // Aprender
                formacao(jogador); // Invocar método de aprender
                break;
            case 7: // Procurar emprego
                centroEmprego(jogador, profissoes); // Invocar o método do Centro de Emprego
                break;
            case 8: // Outras actividades
                // Fazer outras coisas
                outrasActividades(jogador,pessoas);
                System.out.println();
                break;
            case 9: // Informação do Jogador
                System.out.println("ver-se ao espelho...");
                jogador.exibirDetalhesJogador(); // Invocar o método de exibir os detalhes do jogador
                break;
            default:
                // Nunca aparece porque o valor já está controlado no ciclo do while e não chega ao switch caso não esteja compreendido entre 0 e 9
                break;
        }
    }
}