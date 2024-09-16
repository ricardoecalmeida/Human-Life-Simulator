package Controllers;

import Domain.Pessoas.Jogador;
import Domain.Pessoas.NPC;

import static Domain.Pessoas.Jogador.exibirDetalhesFamilia;

public class SSController {

    /**
     * Método que verifica se o protagonista tem filhos e, em caso afirmativo, verifica
     * se tem condições para os manter ou é preciso a Segurança Social os retirar.
     *
     * @param jogador Protagonista do jogo
     */
    public static void ssController(Jogador jogador) {
        // Verificar se o protagonista tem filhos e, em caso afirmativo, se tem dinheiro suficiente para os manter
        if (jogador.getFamilia().size() > 1 && jogador.getDinheiro() < -3250) { // Se o protagonista tiver mais do que 1 elemento na família e se tiver uma dívida superior a €3.250
            System.out.println();
            System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
            System.out.println();
            System.out.print(jogador.getNome() + ", estás sossegado da tua vida a contemplar com satisfação os \"passe-partout\" com as fotografias da tua ");
            exibirDetalhesFamilia(jogador.getFamilia());
            System.out.println();
            System.out.println("Esqueceste-te que tens uma dívida de €" + jogador.getDinheiro() + ", e a Segurança Social apareceu de rompante e levou-te os filhos!");
            NPC conjuge = new NPC(jogador.getFamilia().get(0).getNome(), 0, jogador.getFamilia().get(0).getEstatutoMinimo()); // Guardar os dados do cônguge, dinheiro é 0 porque já lhe foi retirado quando casou
            jogador.getFamilia().clear(); // Remover todos os elementos da família
            jogador.getFamilia().add(conjuge);  // Adicionar o cônjuge
            System.out.println();
            System.out.print("A tua nova ");
            exibirDetalhesFamilia(jogador.getFamilia());
            System.out.println();
            System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
            System.out.println();
        }
    }
}