package Domain.Propriedades;

public class Veiculo extends Propriedade { // Veiculo é subclasse de Propriedade
    private String marca;
    private String modelo;

    /**
     * Método construtor de Veiculo
     *
     * @param nome     Nome do veículo
     * @param custo    Custo do veículo
     * @param estatuto Estatuto que confere a quem o compra
     * @param marca    Marca do veículo
     * @param modelo   Modelo do veículo
     */
    public Veiculo(String nome, double custo, int estatuto, String marca, String modelo) {
        super(nome, custo, estatuto);
        this.marca = marca;
        this.modelo = modelo;
    }

    // ----- GETTERS ----- //
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    /**
     * Método para exibir os detalhes de Veiculo
     */
    public void detalhesVeiculo() {
        System.out.println("Nome: " + super.getNome() + " • Marca: " + this.marca + " • Modelo: " + this.modelo + " • Estatuto: " + super.getEstatuto() + " • Preço: €" + super.getCusto());
    }
}