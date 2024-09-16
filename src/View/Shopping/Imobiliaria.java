package View.Shopping;

import Domain.Pessoas.Jogador;
import Domain.Propriedades.Imovel;
import Domain.Propriedades.Propriedade;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static View.Shopping.Shopping.listaProdutos;

public class Imobiliaria {

    /**
     * Método para o jogador comprar Imóveis
     * @param jogador Protagonista do jogo
     * @param listaProdutos Conjunto de produtos do Shopping
     */
    public static void montraImoveis(Jogador jogador, ArrayList<Propriedade> listaProdutos) {
        ArrayList<Integer> arrayIndexAleatorio = new ArrayList<>(); // Insanciar um ArrayList vazio
        // Ciclo while que vai preencher o arrayIndexAleatorio até que este tenha 10 elementos
        while (arrayIndexAleatorio.size() < 10) {
            Random randomNumber = new Random(); // Instanciar objecto de Random
            // Criar variável "indexAleatorio", onde vai ficar guardado número entre 0 e o tamanho do ArrayList "listaProdutos"
            int indexAleatorio = randomNumber.nextInt(0, listaProdutos.size());
            // Se ainda não existir esse número no ArrayList e corresponder a um elemento que é instância de Imovel
            if (!arrayIndexAleatorio.contains(indexAleatorio) && listaProdutos.get(indexAleatorio) instanceof Imovel) {
                arrayIndexAleatorio.add(indexAleatorio); // Gravar esse número nesta posição
            }
        } // Ciclo acima termina com um ArrayList de tamanho 10, com números aleatórios e sem repetidos
        // Instanciar um ArryList vazio que vai ser a montra de Imóveis com 10 elementos aleatórios
        ArrayList<Propriedade> arrayMontraImoveis = new ArrayList<>();
        // Ciclo for que corre as vezes do tamanho do arrayIndexAleatorio (neste caso, será 10 vezes)
        for (int i = 0; i < arrayIndexAleatorio.size(); i++) {
            // Adicionar à montra (arrayMontraImoveis) o elemento do array de produtos completo (listaProdutos)
            // o elemento na posição que existe no arrayIndexAleatorio
            arrayMontraImoveis.add(listaProdutos.get(arrayIndexAleatorio.get(i)));
        }
        // Depois deste ciclo temos um ArrayList auxiliar preenchido com 10 elementos aleatórios
        System.out.println();
        System.out.println("••• Lista de imóveis disponíveis •••");
        int contador = 0;
        // Ciclo for each para imprimir os detalhes de todos os elementos em arrayMontraImoveis
        for (Propriedade propriedadeActual : arrayMontraImoveis) {
            System.out.println("ID " + contador + " • " + propriedadeActual.getNome() + " • Capacidade: " + ((Imovel) propriedadeActual).getCapacidadePessoas() + " pessoas • Estatuto: " + propriedadeActual.getEstatuto() + " • Preço: €" + propriedadeActual.getCusto());
            contador++;
        }
        System.out.println("[10] SAIR SEM COMPRAR");
        int escolhaImovel;
        do {
            System.out.println();
            System.out.println(jogador.getNome() + ", qual queres comprar?");
            System.out.print("Insere o ID: ");
            Scanner escolhaID = new Scanner(System.in);
            escolhaImovel = escolhaID.nextInt();
        } while (escolhaImovel < 0 || escolhaImovel > 10);
        if (escolhaImovel <= 9) {
            // Instanciar um objecto Propriedade que será igual ao que está no arrayMontraImoveis na posição correspondente ao número que o utilizador introduziu
            Propriedade propriedadeNova = arrayMontraImoveis.get(escolhaImovel);
            if (propriedadeNova.getCusto() < jogador.getDinheiro()) { // Se a propriedade for de custo inferior ao dinheiro que o jogador possui
                jogador.getPropriedades().add(propriedadeNova); // Adicionar propriedade às propriedades do jogador
                jogador.setDinheiro(jogador.getDinheiro() - propriedadeNova.getCusto()); // Retirar o preço da propriedade ao dinheiro do jogador
                jogador.setEstatuto(jogador.getEstatuto() + propriedadeNova.getEstatuto()); // Adicionar o estatuto da propriedade ao nível de estatuto do jogador
                System.out.println();
                System.out.println(jogador.getNome() + ", compraste [" + propriedadeNova.getNome() + "]!");
                System.out.println("Tens menos €" + propriedadeNova.getCusto() + " na conta bancária e mais " + propriedadeNova.getEstatuto() + " de nível de Estatuto.");
                listaProdutos.remove(arrayIndexAleatorio.get(escolhaImovel)); // Remover a propriedade comprada da listaProdutos
            } else {
                System.out.println("Não tens dinheiro suficiente para comprar " + propriedadeNova.getNome() + "...");
                System.out.println("Sugestão: Vai trabalhar!");
            }
        } else {
            System.out.println("Foste embora sem comprar nada e o agente imobiliário ficou a olhar para ti com ar de quem te quer castigar fechando-te à força no imóvel mais rasca do catálogo.");
        }
        System.out.println();
    }
}