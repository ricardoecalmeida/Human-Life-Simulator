package Controllers;

import Domain.Pessoas.Jogador;

import static Controllers.ElesGanham10ElasGastam20.elesganham10elasgastam20;
import static Controllers.LevelsDecreaser.levelsDecreaser;
import static Controllers.MaritalController.maritalController;
import static Controllers.SSController.ssController;

public class ControllerPack {

    /**
     * Método que invoca vários controladores que devem ser verificados a cada ciclo.
     *
     * @param jogador Protagonista do jogo
     */
    public static void controllerPack(Jogador jogador) {
        levelsDecreaser(jogador); // Invocar o método que faz descer os nível de necessidades no final do ciclo diário
        maritalController(jogador); // Invocar o método que faz chover dinheiro na conta do protagonista, caso seja casado
        ssController(jogador); // Invocar o método que faz a Segurança Social intervir caso o protagonista não possa manter os filhos
        elesganham10elasgastam20(jogador); // Invocar o método que retira dinheiro por cada membro da família
    }
}