package Domain.Pessoas;

import Domain.Enums.Objectivo;
import Domain.Propriedades.AcessorioModa;
import Domain.Propriedades.Imovel;
import Domain.Propriedades.Propriedade;

import java.util.ArrayList;

import static Domain.Propriedades.Propriedade.exibirDetalhesPropriedades;

public class Jogador extends Pessoa { // Jogador é subclasse de Pessoa

    private Objectivo objectivo;
    private Profissao profissao;
    private int sono;
    private int fome;
    private int social;
    private int estatuto;
    private int educacao;
    private boolean casado; // Adicionei este atributo para verificar ao longo do jogo se o protagonista é ou não casado
    private boolean celebridade; // Adicionei este atributo para verificar ao longo do jogo se o protagonista é ou não uma celebridade
    private boolean diploma; // Adicionei este atributo para verificar ao longo do jogo se o protagonista fez ou não o Ensino Superior
    private ArrayList<Propriedade> propriedades; // Lista de todas as propriedades do protagonista
    private ArrayList<NPC> familia; // Lista de todos os elementos da família do protagonista

    /**
     * Método construtor de Jogador
     *
     * @param nome        Nome do protagonista/jogador
     * @param dinheiro    Dinheiro que o jogador possui
     * @param objectivo   Objectivo de vida do jogador (e do jogo)
     * @param profissao   Profissão do jogador
     * @param sono        Nível de sono
     * @param fome        Nível de fome
     * @param social      Nível social
     * @param estatuto    Nível de estatuto
     * @param educacao    Nível de educação
     * @param casado      Estado civil
     * @param celebridade Celebridade
     * @param diploma     Ensino Superior
     */
    public Jogador(String nome, double dinheiro, Objectivo objectivo, Profissao profissao, int sono, int fome, int social, int estatuto, int educacao, boolean casado, boolean celebridade, boolean diploma) {
        super(nome, dinheiro);
        this.objectivo = objectivo;
        this.sono = sono;
        this.fome = fome;
        this.social = social;
        this.estatuto = estatuto;
        this.educacao = educacao;
        this.casado = casado;
        this.celebridade = celebridade;
        this.diploma = diploma;
        this.profissao = new Profissao("Desempregado", "Nenhuma", 0, false, 0, 0); // Inicializado como Desempregado
        this.propriedades = new ArrayList<>();
        this.familia = new ArrayList<>();
    }

    // ----- GETTERS ----- //
    public String getNome() { // Já existe este getter na superclasse. É preciso aqui?
        return super.getNome();
    }
    public double getDinheiro() { // Já existe este getter na superclasse. É preciso aqui?
        return super.getDinheiro();
    }
    public Objectivo getObjectivo() {
        return objectivo;
    }
    public Profissao getProfissao() {
        return profissao;
    }
    public int getSono() {
        return sono;
    }
    public int getFome() {
        return fome;
    }
    public int getSocial() {
        return social;
    }
    public int getEstatuto() {
        return estatuto;
    }
    public int getEducacao() {
        return educacao;
    }
    public boolean getCasado() {
        return casado;
    }
    public boolean getCelebridade() {
        return celebridade;
    }
    public boolean getDiploma() {
        return diploma;
    }
    public ArrayList<Propriedade> getPropriedades() {
        return propriedades;
    }
    public ArrayList<NPC> getFamilia() {
        return familia;
    }

    // ----- SETTERS ----- //
    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }
    public void setSono(int sono) {
        this.sono = sono;
    }
    public void setFome(int fome) {
        this.fome = fome;
    }
    public void setSocial(int social) {
        this.social = social;
    }
    public void setEstatuto(int estatuto) {
        this.estatuto = estatuto;
    }
    public void setEducacao(int educacao) {
        this.educacao = educacao;
    }
    public void setCasado(boolean casado) {
        this.casado = casado;
    }
    public void setCelebridade(boolean celebridade) {
        this.celebridade = celebridade;
    }
    public void setDiploma(boolean diploma) {
        this.diploma = diploma;
    }
    // SETTERS PARA OBJECTIVO, PROPRIEDADES E FAMÍLIA NÃO SÃO NECESSÁRIOS

    /**
     * Método para exibir os detalhes do protagonista/jogador.
     */
    public void exibirDetalhesJogador() {
        System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••");
        System.out.println("Nome: " + super.getNome());
        System.out.println("Objectivo: " + this.objectivo);
        System.out.println("Profissão: " + this.profissao.getNome());
        System.out.println("Salário: €" +this.profissao.getSalarioDia() + "/dia");
        System.out.println("Funções: " + this.profissao.getFuncoes());
        System.out.println("Estatuto: " + this.estatuto);
        System.out.println("Educação: " + this.educacao);
        System.out.println("Ensino Superior: " + ensinoSuperior(this.diploma));
        System.out.println("Celebridade: " + simNao(this.celebridade));
        System.out.println("Estado Civil: " + estadoCivil(this.casado));
        System.out.println("Sono: " + this.sono + "% • Fome: " + this.fome + "% • Social: " + this.social + "%");
        System.out.println("Saldo: €" + super.getDinheiro());
        System.out.println();
        exibirDetalhesPropriedades(this.propriedades);
        System.out.println();
        System.out.println("Valor Patrimonial Total: €" + calcularValorPatrimonial());
        System.out.println();
        exibirDetalhesFamilia(this.familia);
        System.out.println(familia.size() + " familiar(es)");
        System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••");
        System.out.println();
    }

    /**
     * Método que calcula o valor de todas as propriedades do jogador.
     *
     * @return Valor Patromonial
     */
    public double calcularValorPatrimonial() {
        double valorPatrimonial = 0;
        // Ciclo for each que itera o array de propriedades
        for (Propriedade propriedadeActual : propriedades) {
            // Soma o custo da propriedadeActual ao valorPatrimonial
            valorPatrimonial += propriedadeActual.getCusto();
        }
        return valorPatrimonial; // Devolve a soma total
    }

    /**
     * Método que calcula o valor patrimonial total (propriedades + dinheiro) do jogador.
     *
     * @return Valor Patromonial Total
     */
    public double calcularPatrimonioTotal() {
        // Retorna o valor patrimonial das propriedades, calculadas por outro método, e soma o dinheiro do jogador
        return calcularValorPatrimonial() + getDinheiro();
    }

    /**
     * Método que calcula o estatuto total do jogador, com base no estatuto conferido pelas propriedades que comprou
     *
     * @return Estatuto total do jogador
     */
    public int calcularEstatuto() {
        // NOTA: Tinha este bloco no getter getEstatuto, mas ao que parece, conforme está
        // já calcula correctamente, porque de cada vez que o jogador compra uma propriedade,
        // o valor de estatuto é sempre actualizado. De qualquer forma, deixo aqui este método
        // para a eventualidade de ser necessário.
        int estatutoJogador = 0;
        for (Propriedade propriedadeActual : propriedades) {
            estatutoJogador += propriedadeActual.getEstatuto();
        }
        return estatutoJogador;

    }

    /**
     * Método que imprime os nomes dos NPC da família do jogador
     */
    public static void exibirDetalhesFamilia(ArrayList<NPC> familia) {
        System.out.println("Família: ");
        for (NPC pessoaActual : familia) { // Ciclo for each que itera o ArrayList "familia"
            System.out.println("— " + pessoaActual.getNome()); // Mostra o nome do NPC
        }
    }

    /**
     * Método que procura nos imóveis do jogador aquele que tem a maior capacidade
     *
     * @return Capacidade máxima do imóvel com maior capacidade
     */
    public int capacidadeMaximaFamilia() {
        int capacidadeMaxima = 0;
        // Ciclo for each que percorre o ArrayList de propriedades
        for (Propriedade propriedadeActual : this.propriedades) {
            if (propriedadeActual instanceof Imovel) { // Se a propriedade for uma instância de Imovel
                Imovel imovelActual = (Imovel) propriedadeActual; // Definir o objecto como objecto do tipo Imovel
                if (imovelActual.getCapacidadePessoas() > capacidadeMaxima) { // Se a capacidade do imóvel actual for maior do que a capacidade máxima
                    capacidadeMaxima = imovelActual.getCapacidadePessoas(); // A capacidade máxima passa a assumir o valor da capacidade do imóvel actual
                }
            }
        }
        return capacidadeMaxima; // Devolve a capacidade máxima do imóvel com maior capacidade
    }

    /**
     * Método para adicionar um nubente à família do jogador
     *
     * @param nubente Pessoa NPC casada com o jogador
     */
    public void adicionarFamilia(NPC nubente) {
        this.familia.add(nubente);
    }

    /**
     * Método que traduz os valores de boolean true e false para as palavras Casado e Solteiro
     *
     * @param casado Atributo booleano do jogador
     * @return Tradução para português (Casado - se true // Solteiro - se false)
     */
    public String estadoCivil(boolean casado) {
        if (casado) { // Se casado true
            return "Casado";
        } else { // Se casado false
            return "Solteiro";
        }
    }

    /**
     * Método que traduz os valores de boolean true e false para as palavras Sim e Não
     *
     * @param celebridade Atributo booleano a traduzir
     * @return Tradução para português (Sim - se true // Não - se false)
     */
    public String simNao(boolean celebridade) {
        if (celebridade) { // Se celebridade true
            return "Sim";
        } else { // Se celebridade false
            return "Não";
        }
    }

    /**
     * Método que traduz os valores de boolean true e false para as palavras Sim e Não
     *
     * @param diploma Atributo booleano a traduzir
     * @return Tradução para português (Sim - se true // Não - se false)
     */
    public String ensinoSuperior(boolean diploma) {
        if (diploma) { // Se diploma true
            return "Sim";
        } else { // Se diploma false
            return "Não";
        }
    }
}