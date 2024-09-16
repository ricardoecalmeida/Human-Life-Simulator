package View.Shopping;

import Domain.Pessoas.Jogador;
import Domain.Propriedades.Propriedade;

import java.util.Scanner;

public class Usados {

    /**
     * Método para o jogador vender Propriedades
     *
     * @param jogador Protagonista do jogo
     */
    public static void vender(Jogador jogador) {
        System.out.println();
        System.out.println(jogador.getNome() + ", estas são as tuas propriedades:");
        int contadorPropriedades = 0; // Instanciar uma variável para servir como contador
        // Ciclo for each para iterar as propriedades do jogador
        for (Propriedade propriedadeActual : jogador.getPropriedades()) {
            // Apresentar valor do contador, que vai corresponder à posição da propriedade a vender
            System.out.print(contadorPropriedades + " • ");
            // Apresentar alguns detalhes das propriedades (nome, valor e estatuto)
            System.out.println(propriedadeActual.getNome() + " • Valor: €" + propriedadeActual.getCusto() + " • Estatuto: " + propriedadeActual.getEstatuto());
            contadorPropriedades++; // Incrementar o contador
        }
        int propriedadeEscolhida; //Instanciar uma variável para receber a escolha do utilizador
        do {
            System.out.println();
            System.out.println("Pagamos 75% do valor original de custo.");
            System.out.println("Qual queres vender?");
            Scanner propriedadeParaVender = new Scanner(System.in); // Instanciar Scanner
            System.out.print("Insere o número correspondente: ");
            propriedadeEscolhida = propriedadeParaVender.nextInt(); // Receber o input do utilizador através do scanner
        } while (propriedadeEscolhida < 0 || propriedadeEscolhida > jogador.getPropriedades().size()); // Enquanto o valor introduzido estiver fora dos limites 0 e o tamanho do arry de propriedades do jogador
        System.out.println("Vendeste [" + jogador.getPropriedades().get(propriedadeEscolhida).getNome() + "]!");
        System.out.println("Custo original: €" + jogador.getPropriedades().get(propriedadeEscolhida).getCusto());
        System.out.println("Pagaram-te €" + jogador.getPropriedades().get(propriedadeEscolhida).getCusto() * 0.75 + ".");
        jogador.setDinheiro(jogador.getDinheiro() + (jogador.getPropriedades().get(propriedadeEscolhida).getCusto() * 0.75)); // Adicionar 75% do valor da propriedade ao dinheiro actual do jogador
        jogador.setEstatuto(jogador.getEstatuto() - jogador.getPropriedades().get(propriedadeEscolhida).getEstatuto()); // Retirar ao jogador o nível de estatuto correspondente à propriedade vendida
        jogador.getPropriedades().remove(propriedadeEscolhida); // Remover a propriedade do conjunto de propriedades do jogador
    }
}