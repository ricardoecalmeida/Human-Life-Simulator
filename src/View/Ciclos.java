package View;

import Domain.Pessoas.Jogador;
import Domain.Pessoas.NPC;
import Domain.Pessoas.Profissao;
import View.Shopping.Shopping;
import com.sun.security.jgss.GSSUtil;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static Controllers.ControllerPack.controllerPack;
import static Tools.BibliotecaFuncoes.printLevels;
import static View.Actividades.Actividades.actividades;
import static Controllers.EventosController.eventos;

public class Ciclos {

    /**
     * Método que percorre os dias e os momentos de cada dia da vida do jogador.
     *
     * @param jogador      Protagonista do jogo
     * @param profissoes   Conjunto de profissões
     * @param pessoas      Conjunto de pessoas NPC
     * @param contadorDias Contador de dias
     * @param chopisCentis Shopping
     */
    public static void ciclos(Jogador jogador, ArrayList<Profissao> profissoes, ArrayList<NPC> pessoas, int contadorDias, Shopping chopisCentis) throws FileNotFoundException, InterruptedException {
        // Ciclo while que percorre os dias da vida do jogador
        while (contadorDias >= 1 && contadorDias <= 100) { // Jogo desenvolve-se entre o dia 1 e o dia 100
            System.out.println();
            System.out.println("•••••••••••••••••••••• Bom dia! • Hoje é dia " + contadorDias + "/100 ••••••••••••••••••••");
            System.out.println();
            eventos(jogador, pessoas, contadorDias); // Invoca o método de eventos que ocorrem em dias específicos
            int contadorMomentos = 1; // Faz reset ao contador de momentos do dia (ao início de cada novo dia é sempre de manhã)
            // Ciclo while que percorre os 4 momentos do dia [manhã, meio-dia, tarde, noite]
            while (contadorMomentos >= 1 && contadorMomentos <= 4) { // Enquanto o contador estiver entre os valores 1 e 4
                if (contadorMomentos == 1) { // Manhã
                    System.out.println("••••••••••••••••••••••••••••••••• MANHÃ •••••••••••••••••••••••••••••••••");
                    // printLevels(jogador); // Invocar o método de imprimir o resumo dos níveis de necessidade
                    actividades(jogador, profissoes, pessoas, contadorDias, chopisCentis); // Invocar o método de actividades para perguntar o que o protagonista quer fazer
                    controllerPack(jogador); // Invoca o método que por sua vez invoca métodos de controlo que devem ser verificados a cada ciclo
                }
                if (contadorMomentos == 2) { // Meio-dia
                    System.out.println("••••••••••••••••••••••••••••••• MEIO-DIA ••••••••••••••••••••••••••••••••");
                    // printLevels(jogador); // Invocar o método de imprimir o resumo dos níveis de necessidade
                    actividades(jogador, profissoes, pessoas, contadorDias, chopisCentis); // Invocar o método de actividades para perguntar o que o protagonista quer fazer
                    controllerPack(jogador); // Invoca o método que por sua vez invoca métodos de controlo que devem ser verificados a cada ciclo

                }
                if (contadorMomentos == 3) { // Tarde
                    System.out.println("••••••••••••••••••••••••••••••••• TARDE •••••••••••••••••••••••••••••••••");
                    // printLevels(jogador); // Invocar o método de imprimir o resumo dos níveis de necessidade
                    actividades(jogador, profissoes, pessoas, contadorDias, chopisCentis); // Invocar o método de actividades para perguntar o que o protagonista quer fazer
                    controllerPack(jogador); // Invoca o método que por sua vez invoca métodos de controlo que devem ser verificados a cada ciclo
                }
                if (contadorMomentos == 4) { // Noite
                    System.out.println("••••••••••••••••••••••••••••••••• NOITE •••••••••••••••••••••••••••••••••");
                    // printLevels(jogador); // Invocar o método de imprimir o resumo dos níveis de necessidade
                    actividades(jogador, profissoes, pessoas, contadorDias, chopisCentis); // Invocar o método de actividades para perguntar o que o protagonista quer fazer
                    controllerPack(jogador); // Invoca o método que por sua vez invoca métodos de controlo que devem ser verificados a cada ciclo
                }
                contadorMomentos++; // Após cada um dos 4 momentos do dia, incrementa o contador e passa para o próximo momento do dia
            } // Final do ciclo de momentos
            System.out.print("••••••••••••••••••••••••• Terminou o dia " + contadorDias + "/100 ••••••••••••••••••••••••");
            System.out.println();
            contadorDias++; // Incrementar um dia após correr o ciclo de 4 momentos
        } // Final do ciclo de dias
    }
}