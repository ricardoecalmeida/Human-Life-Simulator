package Domain.Pessoas;

public class Profissao {
    private String nome;
    private String funcoes; // Adicionei este atributo para poder mostrar na consola as funções associadas à profissão
    private double salarioDia;
    private boolean formal;
    private int estatuto;
    private int nivelMinimoEducacao;

    /**
     * Método construtor de Profissao
     *
     * @param nome                Nome da profissão
     * @param funcoes             Funções da profissão
     * @param salarioDia          Salário diário
     * @param formal              Requisito de indumentária
     * @param estatuto            Estatuto que a profissão confere
     * @param nivelMinimoEducacao Nível mínimo de educação exigido
     */
    public Profissao(String nome, String funcoes, double salarioDia, boolean formal, int estatuto, int nivelMinimoEducacao) {
        this.nome = nome;
        this.funcoes = funcoes;
        this.salarioDia = salarioDia;
        this.formal = formal;
        this.estatuto = estatuto;
        this.nivelMinimoEducacao = nivelMinimoEducacao;
    }

    // ----- GETTERS ----- //
    public String getNome() {
        return nome;
    }
    public String getFuncoes() {
        return funcoes;
    }
    public double getSalarioDia() {
        return salarioDia;
    }
    public boolean isFormal() {
        return formal;
    }
    public int getEstatuto() {
        return estatuto;
    }
    public int getNivelMinimoEducacao() {
        return nivelMinimoEducacao;
    }

    /**
     * Método que exibe os detalhes de uma Profissão
     */
    public void exibirDetalhesProfissao() {
        System.out.println("Profissão: " + this.nome);
        System.out.println("Funções: " + this.funcoes);
        System.out.println("Vencimento: €" + this.salarioDia + "/dia • Apresentação formal: " + simNao(this.formal) + " • Estatuto Mínimo Exigido: " + this.estatuto + " • Educação Mínima Exigida: " + this.nivelMinimoEducacao);
        System.out.println();
    }

    /**
     * Método que traduz os valores de boolean true e false para as palavras Sim e Não
     *
     * @param formal Atributo booleano a traduzir
     * @return Tradução para português (Sim - se true // Não - se false)
     */
    public String simNao(boolean formal) {
        if (formal) { // Se formal true
            return "Sim";
        } else { // Se formal false
            return "Não";
        }
    }
}