package Controllers;

import Domain.Pessoas.Jogador;

public class MaritalController {

    /**
     * Método que adiciona dinheiro na conta bancária do jogador, caso seja casado
     *
     * @param jogador Protagonista do jogo
     */
    public static void maritalController(Jogador jogador) {
        if (jogador.getCasado()) { // Se o jogador for casado
            jogador.setDinheiro(jogador.getDinheiro() + 30); // Adicionar €30 ao dinheiro
        }
    }
}