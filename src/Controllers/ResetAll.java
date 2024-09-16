package Controllers;

import Domain.Pessoas.Jogador;
import Domain.Pessoas.Profissao;

public class ResetAll {

    /**
     * Método para fazer reset a vários atributos do jogador
     *
     * @param jogador Protagonista do jogo
     */
    public static void resetAll(Jogador jogador) {
        jogador.setDinheiro(0); // Atribui o valor 0 ao dinheiro
        jogador.setSono(100); // Atribui o valor 0 ao nível de sono
        jogador.setFome(100); // Atribui o valor 0 ao nível de fome
        jogador.setSocial(100); // Atribui o valor 0 ao nível de necessidade social
        jogador.setEstatuto(0); // Atribui o valor 0 ao nível de estatuto
        jogador.setEducacao(0); // Atribui o valor 0 ao nível de educação
        jogador.setCasado(false); // Atribui o valor false ao atributo boolean referente ao estado civil
        jogador.setCelebridade(false); // Atribui o valor false ao atributo boolean referente ao estatuto de celebridade
        jogador.setDiploma(false); // Atribui o valor false ao atributo boolean referente ao diploma (ensino superior)
        jogador.getPropriedades().clear(); // Apagar os elementos do ArrayList propriedades do jogador
        jogador.getFamilia().clear(); // Apagar os elementos do ArrayList familia do jogador
        // Instanciar uma nova Profissão (desempregado) com atributos vazios ou a zero
        Profissao desempregado = new Profissao("Desempregado", "Nenhuma", 0, false, 0, 0);
        jogador.setProfissao(desempregado); // Atribuir profissão ao protagonista
        // NOTA: Não faz reset ao nome nem ao objectivo porque se pretende que o protagonista seja o mesmo
    }
}