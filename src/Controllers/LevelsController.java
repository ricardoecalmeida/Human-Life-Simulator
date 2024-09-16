package Controllers;

import Domain.Pessoas.Jogador;

public class LevelsController {

    /**
     * Método que controla os níveis de necessidade do jogador [dormir, comer, socializar]
     * e força-o a fazer determinada actividade, se tiver os níveis baixos.
     * @param jogador Protagonista do jogo
     * @param fazer Escolha associada à actividade
     * @return Escolha que o jogador já tinha feito, ou uma das opções [dormir, comer, socializar], em caso de necessidade
     */
    public static int levelsController(Jogador jogador, int fazer) {
        if (fazer != 2 && jogador.getSono() < 25) { // Se o protagonista tiver escolhido opção diferente de 2 e tiver sono abaixo de 25
            System.out.println();
            System.out.println("Não podes, " + jogador.getNome() + ". Estás a cair para o lado com sono!");
            fazer = 2; // Tem de dormir
        }
        else if (fazer != 3 && jogador.getFome() < 25) { // Se o protagonista tiver escolhido opção diferente de 3 e tiver fome abaixo de 25
            System.out.println();
            System.out.println("Não podes, " + jogador.getNome() + ". Tens a barriga a dar horas!");
            fazer = 3; // Tem de comer
        }
        else if (fazer != 4 && jogador.getSocial() < 25) { // Se o protagonista tiver escolhido opção diferente de 4 e tiver necessidade social abaixo de 25
            System.out.println();
            System.out.println("Não podes, " + jogador.getNome() + ". Estás a morrer de saudades dos teus amigos!");
            fazer = 4; // Tem de socializar
        }
        System.out.println();
        return fazer; // Devolver o valor em fazer
        // NOTA: A prioridade de satisfação de necessidades será sempre por esta ordem: 1.º dormir, 2.º comer, 3.º socializar
    }
}