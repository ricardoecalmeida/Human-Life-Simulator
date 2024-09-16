package View;

import Domain.Pessoas.Jogador;

public class Historia {

    /**
     * Método que apresenta uma narrativa inicial antes do início dos ciclos diários do jogo.
     *
     * @param jogador Protagonista do jogo
     */
    public static void historia(Jogador jogador) {
        System.out.println();
        System.out.println("Ao fim de alguns dias, o " + jogador.getNome() + " já estava a dar demasiado trabalho,");
        System.out.println("então foste à igreja de noite e deixaste-o na roda...");
        System.out.println();
        System.out.println("18 anos depois...");
        System.out.println();
        System.out.println("Criado pelas freiras, o " + jogador.getNome() + " foi sempre muito difícil de aturar");
        System.out.println("e só se metia em problemas. Foi expulso no dia em que completou 18 anos.");
        System.out.println();
        System.out.println("\"" + jogador.getNome() + ", põe-te daqui para fora! Já és um homenzinho e a partir de agora");
        System.out.println("és responsável pela tua própria vida e tomas as suas próprias decisões!\"");
        System.out.println("— disse-lhe a Madre Superiora.");
        System.out.println();
        System.out.println(jogador.getNome() + ", agora estás por tua conta, e só tens mais 100 dias para viver.");
        System.out.println("Aproveita-os bem e deixa orgulhoso quem te encontrou na lixeira há 18 anos!");
        System.out.println();
        System.out.println("Ao longo da tua vida, recorda-te que o teu objectivo é");
        switch (jogador.getObjectivo()) { // Apresentar mensagem personalizada consoante o objectivo
            case MILIONARIO -> System.out.println("ter muitas cenas, e a conta bancária a abarrotar!");
            case FAMILIA -> System.out.println("propagar o teu ADN e ter muita canalha lá em casa!");
            case CELEBRIDADE -> System.out.println("ser tipo bué da famoso e toda a gente te conhecer em todo o lado!");
            case SUCESSO -> System.out.println("ser um profissional que \"sim senhor\"!");
        }
        System.out.println();
        System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
    }
}