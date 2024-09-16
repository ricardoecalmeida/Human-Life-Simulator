package View.Actividades;

import Domain.Pessoas.Jogador;
import Domain.Pessoas.NPC;

import java.util.ArrayList;
import java.util.Random;

public class Dormir {

    /**
     * Método em que o jogador vai fazer a actividade dormir
     *
     * @param jogador Protagonista do jogo
     * @param pessoas Conjunto de pessoas NPC
     */
    public static void dormir(Jogador jogador, ArrayList<NPC> pessoas) {
        System.out.print("dormir ");
        Random random = new Random(); // Instanciar um objecto Random
        int dormirAleatorio = random.nextInt(0, 10); // Número aleatório de 0 a 9
        switch (dormirAleatorio) {
            case 0: // vai dormir com uma pessoa aleatória
                Random randomNPC = new Random(); // Instanciar um objecto Random
                int npcAleatorio = random.nextInt(pessoas.size()); // Número gerado tem como limite o tamanho do ArrayList pessoas
                System.out.print("com " + pessoas.get(npcAleatorio).getNome() + ".");
                break;
            case 1: // vai dormir a pensar na profissão que tem
                System.out.print("concretizado por ser " + jogador.getProfissao().getNome() + ".");
                break;
            case 2:
                System.out.print("de conchinha com um cadáver decepado que trouxe da morgue.");
                break;
            case 3:
                System.out.print("com a camisa de noite da avó.");
                break;
            case 4:
                System.out.print("com um pijama do Tobias.");
                break;
            case 5:
                System.out.print("junto do contentor do lixo, a ver se o levavam outra vez.");
                break;
            case 6:
                System.out.print("todo vomitado com uma borracheira.");
                break;
            case 7:
                System.out.print("e activou 20 despertadores, de 5 em 5 minutos.");
                break;
            case 8:
                System.out.print("com uma família de porcos espinhos.");
                break;
            case 9:
                System.out.print("sozinho porque não engatou ninguém hoje.");
                break;
            default:
                // Nunca chega a mostrar um default porque o número aleatório gerado será sempre de 0 a 9
                break;
        }
        System.out.println();
        System.out.print("O " + jogador.getNome() + " tinha " + jogador.getSono() + "% de sono, ");
        jogador.setSono(100); // Repor a necessidade de sono de volta a 100 (máximo)
        System.out.println("fez uma naninha boa e agora já tem " + jogador.getSono() + "%.");
        System.out.println();
    }
}