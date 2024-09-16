package Controllers;

import Domain.Pessoas.Jogador;

public class ElesGanham10ElasGastam20 {

    /**
     * Método que retira dinheiro por cada membro da família do jogador.
     * @param jogador Protagonista do jogo
     */
    public static void elesganham10elasgastam20 (Jogador jogador) {
        jogador.setDinheiro(jogador.getDinheiro() - (jogador.getFamilia().size() * 10)); // Retirar €10 por cada membro da família
    }
}