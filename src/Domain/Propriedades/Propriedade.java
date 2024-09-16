package Domain.Propriedades;

import Domain.Pessoas.Jogador;

import java.util.ArrayList;

public class Propriedade { // Propriedade é superclasse de: AcessorioModa, Imovel, Veiculo

    private String nome;
    private double custo;
    private int estatuto;

    /**
     * Método construtor de Propriedade
     *
     * @param nome     Nome da propriedade
     * @param custo    Custo da propriedade
     * @param estatuto Estatuto que a propriedade confere a quem a compra
     */
    public Propriedade(String nome, double custo, int estatuto) {
        this.nome = nome;
        this.custo = custo;
        this.estatuto = estatuto;
    }

    // ----- GETTERS ----- //
    public String getNome() {
        return nome;
    }

    public double getCusto() {
        return custo;
    }

    public int getEstatuto() {
        return estatuto;
    }

    /**
     * Método que imprime os detalhes das propriedades do ArrayList de propriedades do protagonista
     */
    public static void exibirDetalhesPropriedades(ArrayList<Propriedade> propriedades) {
        System.out.println("Propriedades: ");
        for (Propriedade propriedadeActual : propriedades) {
            System.out.print("— " + propriedadeActual.getNome() + " • Valor: €" + propriedadeActual.getCusto() + " • Estatuto: " + propriedadeActual.getEstatuto());
            if (propriedadeActual instanceof Imovel) {
                System.out.println(" • Capacidade máxima: " + ((Imovel) propriedadeActual).getCapacidadePessoas() + " pessoa(s)");
            }
            if (propriedadeActual instanceof Veiculo) {
                System.out.println(" • Marca: " + ((Veiculo) propriedadeActual).getMarca() + " • Modelo: " + ((Veiculo) propriedadeActual).getModelo());
            }
            if (propriedadeActual instanceof AcessorioModa) {
                System.out.println(" • Marca: " + ((AcessorioModa) propriedadeActual).getMarca() + " • Formal: " + ((AcessorioModa) propriedadeActual).getFormal());
            }
        }
    }
}