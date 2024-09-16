package View.Actividades;

import Domain.Pessoas.Jogador;
import Domain.Pessoas.NPC;

import java.util.ArrayList;
import java.util.Random;

public class Comer {

    /**
     * Método em que o jogador vai fazer a actividade comer
     *
     * @param jogador Protagonista do jogo
     * @param pessoas Conjunto de Pessoas NPC
     */
    public static void restaurante(Jogador jogador, ArrayList<NPC> pessoas) {
        System.out.print("comer ");
        Random randomEscolha = new Random(); // Instanciar um objecto Random
        int comidaAleatoria = randomEscolha.nextInt(0, 10); // Número aleatório de 0 a 9
        switch (comidaAleatoria) {
            case 0: // vai comer fora com uma pessoa aleatória
                Random randomNPC = new Random(); // Instanciar um objecto Random
                int npcAleatorio = randomNPC.nextInt(pessoas.size()); // Número gerado tem como limite o tamanho do ArrayList pessoas
                System.out.print("fora com " + pessoas.get(npcAleatorio).getNome() + ". Pediu o prato do dia");
                break;
            case 1:
                System.out.print("uma sande de rojão à Casa Expresso");
                break;
            case 2:
                System.out.print("blicas fritas com molho de naião (especialidade açoriana)");
                break;
            case 3:
                System.out.print("uma punheta de bacalhau");
                break;
            case 4:
                System.out.print("uma quiche de centopeias");
                break;
            case 5:
                System.out.print("a tua prima");
                break;
            case 6:
                System.out.print("sushi de picanha");
                break;
            case 7:
                System.out.print("uma canja de erva");
                break;
            case 8:
                System.out.print("um pratinho de gomas com molho de francesinha");
                break;
            case 9:
                System.out.print("um prato de leite com Chocapitos do Lidl");
                break;
            default:
                // Nunca chega a mostrar um default porque o número aleatório gerado será sempre de 0 a 9
                break;
        }
        System.out.println(", que custou €10.");
        System.out.print("Tinha " + jogador.getFome() + "% de fome e €" + jogador.getDinheiro() + " na conta bancária. ");
        jogador.setFome(100); // Repor a necessidade de fome de volta a 100 (máximo)
        jogador.setDinheiro(jogador.getDinheiro() - 10); // Diminuir €10 ao dinheiro do jogador
        System.out.println("Já mamou tudo o que tinha no prato e agora tem " + jogador.getFome() + "% de fome e €" + jogador.getDinheiro() + ".");
        System.out.println();
    }
}