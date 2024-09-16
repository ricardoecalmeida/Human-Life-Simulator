package Domain.Propriedades;

public class AcessorioModa extends Propriedade { // AcessorioModa é subclasse de Propriedade
    private String marca;
    private boolean formal;

    /**
     * Método construtor de AcessorioModa
     * @param nome Nome do acessório de moda
     * @param custo Custo do acessório de moda
     * @param estatuto Estatuto que o acessório de moda cofere a quem o compra
     * @param marca Marca do acessório de moda
     * @param formal Indica se o acessório de moda é formal (true) ou informal (false)
     */
    public AcessorioModa(String nome, double custo, int estatuto, String marca, boolean formal) {
        super(nome, custo, estatuto);
        this.marca = marca;
        this.formal = formal;
    }

    // ----- GETTERS ----- //
    public String getMarca() {
        return marca;
    }
    public boolean getFormal() {
        return formal;
    }

    /**
     * Método para exibir os detalhes de Acessório de Moda
     */
    public void detalhesModa() {
        System.out.println("Nome: " + super.getNome() + " • Marca: " + this.marca + " • Estatuto: " + super.getEstatuto() + " • Formal: " + this.formal + " • Preço: €" + super.getCusto());
    }
}