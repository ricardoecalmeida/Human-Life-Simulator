package View.Eventos;

import Domain.Pessoas.Jogador;
import Domain.Pessoas.NPC;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static Tools.Audio.playMusic;
import static Tools.BibliotecaFuncoes.printFile;

public class Cirurgia {

    /**
     * Método em que ao jogador é proposta uma cirurgia e tem de tomar uma decisão
     *
     * @param jogador Proyagonista do jogo
     * @param pessoas Conjunto de pessoas NPC
     */
    public static void cirurgia(Jogador jogador, ArrayList<NPC> pessoas) throws FileNotFoundException {
        System.out.println();
        System.out.println("•••••••••••••••••••••••••••••••• CIRURGIA •••••••••••••••••••••••••••••••");
        System.out.println();
        System.out.println(jogador.getNome() + ", o teu amigo médico fala-te de uma cirurgia inovadora e anda à procura de cobaias.");
        System.out.println("A cirurgia custa para cima de um dinheirão, mas para quem se voluntariar fica de borla! Contudo, envolve um risco muito grande numa zona sensível do teu corpo.");
        System.out.println("Não te pode dizer em que consiste porque é segredo, mas conta-te depois de realizada a cirurgia e depois de assinares uma declaração de confidencialidade.");
        System.out.println(jogador.getNome() + ", queres contribuir para este avanço da Medicina?");
        int opcaoCirurgia;
        do {
            System.out.println();
            System.out.println("[1] SIM");
            System.out.println("[2] NÃO");
            System.out.print("Introduz uma das opções: ");
            Scanner inputCirurgia = new Scanner(System.in);
            opcaoCirurgia = inputCirurgia.nextInt();
        } while (opcaoCirurgia < 1 || opcaoCirurgia > 2);
        switch (opcaoCirurgia) {
            case 1: // Decide fazer a cirurgia
                playMusic("Files/audio/cirurgia_s.wav"); // Correr ficheiro de áudio
                printFile("Files/ascii/cirurgia.txt"); // Imprimir ficheiro na consola
                String conjuge = "a tua namorada"; // Caso o jogador não seja casado
                if (jogador.getCasado()) { // Se o jogador for casado
                    conjuge = jogador.getFamilia().get(0).getNome();
                }
                System.out.println();
                System.out.println("Parabéns! A cirurgia correu lindamente e és o primeiro humano equipado com testículos modelo Inseminador Implacável®, inovação patrocinada pelo famoso actor Arnold Swarzenegger!");
                System.out.println("\"Agora és o homem mais fértil à face do planeta, " + jogador.getNome() + "! Toma todas as cautelas aquando do sexy time com " + conjuge + ", caso não queiras filhos!\" — diz-te o teu amigo médico.");
                System.out.println("Vais à farmácia buscar um autêntico arsenal anticoncepcional. Apesar de usares preservativos, pílulas, aneis vaginais, diu e vários sacos do supermercado,");
                System.out.println("e ainda que o \"sexy time\" nem sequer tenha sido com " + conjuge + ", que até já tinha retirado o útero há uns anos, aparece-te com todos os bebés do jogo na barriga!");
                System.out.println();
                for (NPC bebeActual : pessoas) { // Iterar o ArrayList de pessoas NPC
                    if (bebeActual.getEstatutoMinimo() == 0 && bebeActual.getDinheiro() == 0) { // Se o NPC tiver estatuto e dinheiro 0, significa que pode ser adoptado
                        System.out.println("Parabéns, " + jogador.getNome() + "! És pai de " + bebeActual.getNome() + "!");
                        jogador.getFamilia().add(bebeActual); // Adicionar NPC à família do jogador
                    }
                }
                System.out.println();
                if (!jogador.getCasado() || jogador.capacidadeMaximaFamilia() < 6) {
                    System.out.println("Sei o que estás a pensar, " + jogador.getNome() + "...");
                    System.out.println();
                    if (!jogador.getCasado()) {
                        System.out.println("— \"Mas eu nem sequer sou casado... Como é que posso ter filhos?!\"");
                        System.out.println("Desde quando é que a Biologia quer saber de legislação, uma abstracção que os homens criaram?");
                        System.out.println("A Segurança Social quer saber se és casado ou não, se quiseres adoptar crianças...");
                        System.out.println("Os testículos modelo Inseminador Implacável® não... E não perdoam!");
                        System.out.println();
                    }
                    if (jogador.capacidadeMaximaFamilia() < 6) {
                        System.out.println("— \"Não tenho casa que chegue para esta chavalada toda! O que é que vou fazer à minha vida agora?!\"");
                        System.out.println("Desde quando é que a Biologia quer saber do tamanho da tua casa? ");
                        System.out.println("A Segurança Social quer saber se tens casa de tipologia suficiente para para albergar crianças, se as quiseres adoptar.");
                        System.out.println("Já os testículos modelo Inseminador Implacável®, não... Desenrasca-te!");
                        System.out.println();
                    }
                }
                System.out.println();
                System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
                System.out.println();
                break;
            case 2: // Decide não fazer a cirurgia
                playMusic("Files/audio/cirurgia_n.wav"); // Correr ficheiro de áudio
                System.out.println("\"Ok, " + jogador.getNome() + ", eu não te posso obrigar a fazer esta operação. Tu é que sabes...\" — diz-te o teu amigo médico.");
                System.out.println("Aterrorizado, pedes para ir à casa de banho, e bazas para nunca mais voltar.");
                System.out.println();
                System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
                System.out.println();
                break;
            default:
                // Opção controlada pelo do while em cima, que só permite escolher uma das opções válidas
                break;
        }
    }
}