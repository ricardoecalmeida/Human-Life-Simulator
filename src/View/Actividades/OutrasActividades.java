package View.Actividades;

import Domain.Pessoas.Jogador;
import Domain.Pessoas.NPC;

import java.util.ArrayList;
import java.util.Random;

public class OutrasActividades {

    /**
     * Método em que o jogador vai fazer outras actividades aleatórias
     *
     * @param jogador Protagonista do jogo
     * @param pessoas Conjunto de pessoas NPC
     */
    public static void outrasActividades(Jogador jogador, ArrayList<NPC> pessoas) {
        Random random = new Random(); // Instanciar um objecto Random
        int fazerAleatorio = random.nextInt(0, 10); // Número aleatório de 0 a 9
        Random randomNPC = new Random(); // Instanciar um objecto Random
        int npcAleatorio = randomNPC.nextInt(pessoas.size()); // Número gerado tem como limite o tamanho do ArrayList pessoas
        switch (fazerAleatorio) {
            case 0: // vai dormir com uma pessoa aleatória
                System.out.println("à casa de banho e encontrou lá " + pessoas.get(npcAleatorio).getNome() + " com uma caganeira descomunal, a gritar e a pintar tudo à pistola.");
                System.out.println("O cenário parecia um filme de terror, mas com uma correcção de cor terrível em que os vermelhos estavam castanhos.");
                break;
            case 1: // vai dormir a pensar na profissão que tem
                System.out.println("fazer uma \"prank call\" para " + pessoas.get(npcAleatorio).getNome() + ".");
                break;
            case 2:
                System.out.println("ao médico e encontrou lá " + pessoas.get(npcAleatorio).getNome() + " à espera para fazer uma cirurgia inovadora cujo folheto tinha uma fotografia do Arnold Scwarzenegger.");
                break;
            case 3:
                System.out.println("até ao bordel e encontrou lá " + pessoas.get(npcAleatorio).getNome() + " a trabalhar.");
                jogador.setDinheiro(jogador.getDinheiro() - 100);
                System.out.println("Gastou €100 em serviços de lazer e no fim pediu factura com contribuinte.");
                break;
            case 4:
                System.out.println("fumar umas ganzas com " + pessoas.get(npcAleatorio).getNome() + ".");
                jogador.setDinheiro(jogador.getDinheiro() - 20);
                System.out.println("Gastou €20 em folhas de louro prensadas e no fim pediu factura com contribuinte.");
                break;
            case 5:
                System.out.println("gamar umas carteiras no autocarro com " + pessoas.get(npcAleatorio).getNome() + ".");
                jogador.setDinheiro(jogador.getDinheiro() + 150);
                System.out.println("Consguiu fazer €150.");
                break;
            case 6:
                System.out.println("a um tasco diferente com " + pessoas.get(npcAleatorio).getNome() + ".");
                jogador.setDinheiro(jogador.getDinheiro() - 5);
                System.out.println("Gastou €5 no que lhe apeteceu beber, que não foi uísque Singleton, como sempre.");
                break;
            case 7:
                System.out.println("tocar às campainhas e fugir com " + pessoas.get(npcAleatorio).getNome() + ".");
                break;
            case 8:
                System.out.println("procurar o Tobias à floresta dele com " + pessoas.get(npcAleatorio).getNome() + ".");
                jogador.setDinheiro(jogador.getDinheiro() - 1000);
                System.out.println("Gastou €1000 em voos, estadia e alimentação, e não descobriu a floresta nem quem é o Tobias...");
                break;
            case 9:
                System.out.println("jogar Human Life Simulator para casa de " + pessoas.get(npcAleatorio).getNome() + ".");
                jogador.setEducacao(jogador.getEducacao() + 50);
                System.out.println("Aprendeu muitas coisas e ganhou 50 pontos de Educação.");
                break;
            default:
                // Nunca chega a mostrar um default porque o número aleatório gerado será sempre de 0 a 9
                break;
        }
        System.out.println();
    }
}