package View.Actividades;

import Domain.Pessoas.Jogador;

import java.util.Random;

public class Aprender {

    /**
     * Método em que o jogador vai fazer a actividade aprender
     * @param jogador Protagonista do jogo
     */
    public static void formacao(Jogador jogador) {
        System.out.print("aprimorar as suas competências profissionais com ");
        Random randomEscolha = new Random(); // Instanciar um objecto Random
        int estudoAleatorio = randomEscolha.nextInt(0,10); // Número aleatório de 0 a 9
        switch (estudoAleatorio) {
            case 0:
                System.out.println("uma especialização em remoção de pontos negros.");
                break;
            case 1:
                System.out.println("um workshop de iniciação ao descascamento de batatas.");
                break;
            case 2:
                System.out.println("um workshop de cerâmica fálica nas Caldas da Rainha.");
                break;
            case 3:
                System.out.println("um curso intensivo de Programação Orientada a Cebola (só de olhar para o código dá vontade de chorar).");
                break;
            case 4:
                System.out.println("uma formação de fotografia de \"dick pics\".");
                break;
            case 5:
                System.out.println("um curso de pintura de tectos com recurso a isqueiro.");
                break;
            case 6:
                System.out.println("um workshop de caligrafia direccionado para a técnica de jacto de urina na parede.");
                break;
            case 7:
                System.out.println("um pós-doutoramento em furto de auto-rádios.");
                break;
            case 8:
                System.out.println("um curso de composição musical com recurso excluisivo à técnica alternativa da flatulência.");
                break;
            case 9:
                System.out.println("um curso superior de enolologia de líquidos de piaçaba.");
                break;
            default:
                // Nunca chega a mostrar um default porque o número aleatório gerado será sempre de 0 a 9
                break;
        }
        System.out.println();
        System.out.print("Tinha " + jogador.getEducacao() + " de nível de Educação ");
        jogador.setEducacao(jogador.getEducacao() + 2); // Adicionar 2 ao nível de Educação do protagonista
        System.out.println("e voltou de lá com " + jogador.getEducacao() + ".");
        System.out.println();
    }

}