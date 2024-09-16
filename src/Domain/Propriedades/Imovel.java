package Domain.Propriedades;

public class Imovel extends Propriedade { // Imovel é subclasse de Propriedade
    private int capacidadePessoas;

    /**
     * Método construtor de Imovel
     * @param nome Nome do imóvel
     * @param custo Custo do imóvel
     * @param estatuto Estatuto que o imóvel confere a quem o compra
     * @param capacidadePessoas Capacidade máxima de pessoas que o imóvel pode albergar
     */
    public Imovel(String nome, double custo, int estatuto, int capacidadePessoas) {
        super(nome, custo, estatuto);
        this.capacidadePessoas = capacidadePessoas;
    }

    // ----- GETTERS ----- //
    public int getCapacidadePessoas() {
        return capacidadePessoas;
    }

    /**
     * Método para exibir os detalhes de Imovel
     */
    public void detalhesImovel() {
        System.out.println("Nome: " + super.getNome() + " • Estatuto: " + super.getEstatuto() + " • Capacidade: " + this.capacidadePessoas + " pessoas • Preço: €" + super.getCusto());
    }
}