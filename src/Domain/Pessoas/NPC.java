package Domain.Pessoas;

public class NPC extends Pessoa { // NPC é subclasse de Pessoa

    private int estatutoMinimo; // Estatuto mínimo para a pessoa NPC casar com o Jogador

    /**
     * Método construtor de pessoa NPC (non-playable character)
     *
     * @param nome           Nome do NPC
     * @param dinheiro       Dinheiro que o NPC possui
     * @param estatutoMinimo Estatuto mínimo exigido
     */
    public NPC(String nome, double dinheiro, int estatutoMinimo) {
        super(nome, dinheiro);
        this.estatutoMinimo = estatutoMinimo;
    }

    // ----- GETTERS ----- //
    public int getEstatutoMinimo() {
        return estatutoMinimo;
    }

    /**
     * Método que exibe os detalhes da Pessoa NPC
     */
    public void exibirDetalhesNPC() {
        System.out.println(super.getNome() + " • Dinheiro: CONFIDENCIAL • Estatuto mínimo: " + this.estatutoMinimo);
    }
}