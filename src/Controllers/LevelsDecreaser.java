package Controllers;

import Domain.Pessoas.Jogador;

public class LevelsDecreaser {

    /**
     * Método que faz descer os níveis de necessidades [sono, fome, social] do jogador.
     *
     * @param jogador Protagonista do jogo
     */
    public static void levelsDecreaser(Jogador jogador) {
        jogador.setSono(jogador.getSono() - 25); // Diminui o nível de sono (fica com mais sono)
        jogador.setFome(jogador.getFome() - 20); // Diminui o nível de fome (fica com mais fome)
        jogador.setSocial(jogador.getSocial() - 15); // Diminui o nível de necessidade social (fica com mais necessidade social)
    }
}