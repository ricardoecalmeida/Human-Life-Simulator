package Controllers;

import Domain.Pessoas.Jogador;
import Domain.Propriedades.AcessorioModa;
import Domain.Propriedades.Propriedade;

public class FormalController {

    /**
     * Método que verifica se o jogador tem algum acessório de moda formal
     * @param jogador Protagonista do jogo
     * @return Formal true ou false
     */
    public static boolean acessorioFormal(Jogador jogador) {
        boolean formal = false; // Criar uma variável boolean inicializada a false
        for (Propriedade propriedadeActual : jogador.getPropriedades()) { // Ciclo for each que itera o ArrayList de propriedades do jogador
            // Se a propriedadeActual for uma instância de AcessorioModa e se estiver definido como formal
            if (propriedadeActual instanceof AcessorioModa && ((AcessorioModa) propriedadeActual).getFormal()) {
                formal = true; // Altera o valor de formal para true porque encontrou um acessório de moda formal
                break; // Já encontrou um acessório de moda formal, portanto não precisa de procurar mais e o ciclo pode terminar
            }
        }
        return formal;
    }
}