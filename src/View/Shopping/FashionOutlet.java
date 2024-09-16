package View.Shopping;

import Domain.Pessoas.Jogador;
import Domain.Propriedades.AcessorioModa;
import Domain.Propriedades.Propriedade;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class FashionOutlet {

    /**
     * Método para o jogador comprar Acessórios de Moda
     *
     * @param jogador       Protagonista do jogo
     * @param listaProdutos Conjunto de produtos do Shopping
     */
    public static void montraModa(Jogador jogador, ArrayList<Propriedade> listaProdutos) {
        // Vou abster-me de comentar neste método porque é igual ao montraImoveis, que já está comentado
        ArrayList<Integer> arrayIndexAleatorio = new ArrayList<>();
        while (arrayIndexAleatorio.size() < 10) {
            Random randomNumber = new Random();
            int indexAleatorio = randomNumber.nextInt(0, listaProdutos.size());
            if (!arrayIndexAleatorio.contains(indexAleatorio) && listaProdutos.get(indexAleatorio) instanceof AcessorioModa) {
                arrayIndexAleatorio.add(indexAleatorio);
            }
        }
        ArrayList<Propriedade> arrayMontraModa = new ArrayList<>();
        for (int i = 0; i < arrayIndexAleatorio.size(); i++) {
            arrayMontraModa.add(listaProdutos.get(arrayIndexAleatorio.get(i)));
        }
        System.out.println();
        System.out.println("••• Lista de acessórios de moda disponíveis •••");
        int contador = 0;
        for (Propriedade propriedadeActual : arrayMontraModa) {
            System.out.println("ID " + contador + " • " + propriedadeActual.getNome() + " • Formal: " + ((AcessorioModa) propriedadeActual).getFormal() + " • Estatuto: " + propriedadeActual.getEstatuto() + " • Preço: €" + propriedadeActual.getCusto());
            contador++;
        }
        System.out.println("[10] SAIR SEM COMPRAR");
        int escolhaModa;
        do {
            System.out.println();
            System.out.println(jogador.getNome() + ", qual queres comprar?");
            System.out.print("Insere o ID: ");
            Scanner escolhaID = new Scanner(System.in);
            escolhaModa = escolhaID.nextInt();
        } while (escolhaModa < 0 || escolhaModa > 10);
        if (escolhaModa <= 9) {
            Propriedade propriedadeNova = arrayMontraModa.get(escolhaModa);
            if (propriedadeNova.getCusto() < jogador.getDinheiro()) {
                jogador.getPropriedades().add(propriedadeNova);
                jogador.setDinheiro(jogador.getDinheiro() - propriedadeNova.getCusto());
                jogador.setEstatuto(jogador.getEstatuto() + propriedadeNova.getEstatuto());
                System.out.println();
                System.out.println(jogador.getNome() + ", compraste [" + propriedadeNova.getNome() + "]!");
                System.out.println("Tens menos €" + propriedadeNova.getCusto() + " na conta bancária e mais " + propriedadeNova.getEstatuto() + " de nível de Estatuto.");
                listaProdutos.remove(arrayIndexAleatorio.get(escolhaModa)); // Remover a propriedade comprada da listaProdutos
            } else {
                System.out.println("Não tens dinheiro suficiente para comprar " + propriedadeNova.getNome() + "...");
                System.out.println("Sugestão: Vai trabalhar!");
            }
        } else {
            System.out.println("Saíste da loja sem comprar nada e o dono ficou a olhar para ti com ar de quem te quer esganar com a peça de roupa que tem mais à mão.");
        }
        System.out.println();
    }
}