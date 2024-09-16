package View.Shopping;

import Domain.Pessoas.Jogador;
import Domain.Propriedades.Propriedade;
import Domain.Propriedades.Veiculo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class StandAuto {

    /**
     * Método para o jogador comprar Veículos
     *
     * @param jogador       Protagonista do jogo
     * @param listaProdutos Conjunto de produtos do Shopping
     */
    public static void montraVeiculos(Jogador jogador, ArrayList<Propriedade> listaProdutos) {
        // Vou abster-me de comentar neste método porque é igual ao montraImoveis, que já está comentado
        ArrayList<Integer> arrayIndexAleatorio = new ArrayList<>();
        while (arrayIndexAleatorio.size() < 10) {
            Random randomNumber = new Random();
            int indexAleatorio = randomNumber.nextInt(0, listaProdutos.size());
            if (!arrayIndexAleatorio.contains(indexAleatorio) && listaProdutos.get(indexAleatorio) instanceof Veiculo) {
                arrayIndexAleatorio.add(indexAleatorio);
            }
        }
        ArrayList<Propriedade> arrayMontraVeiculos = new ArrayList<>();
        for (int i = 0; i < arrayIndexAleatorio.size(); i++) {
            arrayMontraVeiculos.add(listaProdutos.get(arrayIndexAleatorio.get(i)));
        }
        System.out.println();
        System.out.println("••• Lista de veículos disponíveis •••");
        int contador = 0;
        for (Propriedade propriedadeActual : arrayMontraVeiculos) {
            System.out.println("ID " + contador + " • Tipo: " + propriedadeActual.getNome() + " • Marca: " + ((Veiculo) propriedadeActual).getMarca() + " • Modelo: " + ((Veiculo) propriedadeActual).getModelo() + " • Estatuto: " + propriedadeActual.getEstatuto() + " • Preço: €" + propriedadeActual.getCusto());
            contador++;
        }
        System.out.println("[10] SAIR SEM COMPRAR");
        int escolhaVeiculo;
        do {
            System.out.println();
            System.out.println(jogador.getNome() + ", qual queres comprar?");
            System.out.print("Insere o ID: ");
            Scanner escolhaID = new Scanner(System.in);
            escolhaVeiculo = escolhaID.nextInt();
        } while (escolhaVeiculo < 0 || escolhaVeiculo > 10);
        if (escolhaVeiculo <= 9) {
            Propriedade propriedadeNova = arrayMontraVeiculos.get(escolhaVeiculo);
            if (propriedadeNova.getCusto() < jogador.getDinheiro()) {
                jogador.getPropriedades().add(propriedadeNova);
                jogador.setDinheiro(jogador.getDinheiro() - propriedadeNova.getCusto());
                jogador.setEstatuto(jogador.getEstatuto() + propriedadeNova.getEstatuto());
                System.out.println(jogador.getNome() + ", compraste [" + ((Veiculo) propriedadeNova).getMarca() + " " + ((Veiculo) propriedadeNova).getModelo() + "]!");
                System.out.println("Tens menos €" + propriedadeNova.getCusto() + " na conta bancária e mais " + propriedadeNova.getEstatuto() + " de nível de Estatuto.");
                listaProdutos.remove(arrayIndexAleatorio.get(escolhaVeiculo)); // Remover a propriedade comprada da listaProdutos
            } else {
                System.out.println("Não tens dinheiro suficiente para comprar " + propriedadeNova.getNome() + "...");
                System.out.println("Sugestão: Vai trabalhar!");
            }
        } else {
            System.out.println("Saíste do Stand sem comprar nada e o funcionário ficou com ar de quem te quer atropelar com o veículo mais pesado de todo o stand.");
        }
        System.out.println();
    }
}