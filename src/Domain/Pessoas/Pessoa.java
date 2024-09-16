package Domain.Pessoas;

public abstract class Pessoa { // Classe abstracta e superclasse de Jogador e de NPC

    private String nome;
    private double dinheiro;

    /**
     * Método construtor de Pessoa
     *
     * @param nome     Nome da Pessoa (Jogador ou NPC)
     * @param dinheiro Dinheiro que a pessoa possui
     */
    public Pessoa(String nome, double dinheiro) {
        this.nome = nome;
        this.dinheiro = dinheiro;
    }

    // ----- GETTERS ----- //
    public String getNome() {
        return nome;
    }
    public double getDinheiro() {
        return dinheiro;
    }

    // ----- SETTERS ----- //
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }
}