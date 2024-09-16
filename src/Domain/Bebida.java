package Domain;

public class Bebida {

    private String nome;
    private static Bebida instance; // Instância estática do tipo Bebida

    /**
     * Método construtor de Bebida (PRIVADO)
     * @param nome Nome da bebida
     */
    private Bebida(String nome) {
        this.nome = nome;
    }

    /**
     * Método que funciona como construtor (PÚBLICO e ESTÁTICO)
     * @param nome Nome da bebida
     * @return Objecto em cache (sempre o mesmo, o primeiro a ser criado)
     */
    public static Bebida getInstance(String nome) {
        if (instance == null) { // Se instance ainda estiver a nulo...
            instance = new Bebida(nome); // Instance passa a ser a descrição
        }
        return instance; // Devolve a instância. Se não entrar na condição if, devolve a instância que já existia.
    }

    public String getNome() {
        return nome;
    }
}