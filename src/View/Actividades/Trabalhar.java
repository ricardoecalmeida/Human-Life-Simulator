package View.Actividades;

import Domain.Pessoas.Jogador;

import java.util.Objects;

public class Trabalhar {

    /**
     * Método em que o jogador vai fazer a actividade trabalhar
     * @param jogador Protagonista do jogo
     */
    public static void trabalhar(Jogador jogador) {
        System.out.println("trabalhar.");
        System.out.println();
        if (Objects.equals(jogador.getProfissao().getNome(), "Desempregado")) { // Se o jogador for Desempregado
            System.out.println("O " + jogador.getNome() + " ainda não arranjou emprego!");
            System.out.println("\"O que estás aqui a fazer, pá?! Tu não podes entrar aqui assim! Isto é só para funcionários! Andor!\"");
            System.out.println("O " + jogador.getNome() + " é enxotado e volta para casa.");
        } else { // Se o jogador tiver um emprego, vai trabalhar
            System.out.print("O " + jogador.getNome() + " foi desempenhar funções como " + jogador.getProfissao().getNome());
            // Adicionar o salário diário ao dinheiro do jogador, consoante a profissão
            jogador.setDinheiro(jogador.getDinheiro() + jogador.getProfissao().getSalarioDia());
            System.out.println(" e voltou com mais €" + jogador.getProfissao().getSalarioDia() + " na conta bancária.");
        }
        System.out.println();
    }
}