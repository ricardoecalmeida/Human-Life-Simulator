package View.Shopping;

import Domain.Pessoas.Jogador;
import Domain.Pessoas.NPC;
import Domain.Pessoas.Profissao;
import Domain.Propriedades.Propriedade;
import Repository.ShoppingRepository;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static View.Shopping.FashionOutlet.montraModa;
import static View.Shopping.Imobiliaria.montraImoveis;
import static View.Shopping.StandAuto.montraVeiculos;
import static View.Shopping.Tabacaria.tabacaria;
import static View.Shopping.Usados.vender;

public class Shopping {

    public static ArrayList<Propriedade> listaProdutos;

    /**
     * Método construtor de Shopping
     */
    public Shopping() throws FileNotFoundException {
        // Instanciar um objecto do tipo ShoppingRepository com nome "repository" com o caminho para o ficheiro passado como parâmetro
        ShoppingRepository repository = new ShoppingRepository("Files/ProdutosShopping.csv");
        listaProdutos = repository.getListaProdutos();
    }

    // ----- GETTERS ----- //
    public ArrayList<Propriedade> getlistaProdutos() {
        return listaProdutos;
    }

    /**
     * Método para o jogador escolher a que loja do Shopping se quer dirigir
     * @param jogador Protagonista do jogo
     * @param profissoes Conjunto de profissões
     * @param pessoas Conjunto de pessoas
     * @param contadorDias Contador de dias
     * @param chopisCentis Shopping
     */
    public void hallShopping(Jogador jogador, ArrayList<Profissao> profissoes, ArrayList<NPC> pessoas, int contadorDias, Shopping chopisCentis) throws FileNotFoundException {
        System.out.println("até ao Shopping.");
        System.out.println();
        System.out.println("Bem-vindo ao CHOPIS CENTIS!");
        int opcaoShopping;
        do {
            System.out.println();
            System.out.println("A que loja queres ir, " + jogador.getNome() + "?");
            System.out.println("[1] Imobiliária");
            System.out.println("[2] Stand Auto");
            System.out.println("[3] Roupa & Acessórios");
            System.out.println("[4] Tabacaria");
            System.out.println("[5] Loja de Usados");
            System.out.println("[0] Sair do Shopping");
            System.out.print(jogador.getNome() + ", insere a tua opção: ");
            Scanner inputShopping = new Scanner(System.in);
            opcaoShopping = inputShopping.nextInt();
        } while (opcaoShopping < 0 || opcaoShopping > 5);
        switch (opcaoShopping) {
            case 0:
                System.out.println("O " + jogador.getNome() + " saiu do Shopping.");
                System.out.println();
                break;
            case 1:
                System.out.println();
                System.out.println("Bem-vindo à Imobiliária\n••• CASAS TÓTIL NÁICES •••");
                montraImoveis(jogador, listaProdutos); // Invocar a função de mostrar a montra de Imóveis
                break;
            case 2:
                System.out.println();
                System.out.println("Bem-vindo ao Stand Auto\n••• TOP TUNING •••");
                montraVeiculos(jogador, listaProdutos); // Invocar a função de mostrar a montra de Veículos
                break;
            case 3:
                System.out.println();
                System.out.println("Bem-vindo ao Fashion Outlet\n••• TROPAS PAUSADADÕES •••");
                montraModa(jogador, listaProdutos); // Invocar a função de mostrar a montra de Acessórios de Moda
                break;
            case 4:
                System.out.println();
                System.out.println("Bem-vindo à Tabacaria/Papelaria\n••• PUXAR A CANETA •••");
                tabacaria(jogador, pessoas);
            case 5:
                System.out.println();
                System.out.println("Bem-vindo à Loja de Usados\n••• TOMA ITO & BENHA O GUITO •••");
                vender(jogador);
            default: // Nunca chega ao default porque as opções já estão controladas no ciclo do while acima
                break;
        }
    }
}