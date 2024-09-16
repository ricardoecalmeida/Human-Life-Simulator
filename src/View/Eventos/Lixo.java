package View.Eventos;

import Domain.Pessoas.Jogador;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static Tools.Audio.playMusic;
import static Tools.BibliotecaFuncoes.printFile;

public class Lixo {

    /**
     * Método onde o jogador encontra um objecto e tem de tomar uma sequência de várias decisões
     *
     * @param jogador Protagonista do jogo
     */
    public static void lixo(Jogador jogador) throws FileNotFoundException {
        System.out.println();
        System.out.println("••••••••••••••••••••••••••••••••• LIXO ••••••••••••••••••••••••••••••••••");
        System.out.println();
        System.out.println("Vais pôr o lixo no mesmo sítio onde te deixaram antes de ires para as freiras e encontras uma caixote com tralhas.");
        System.out.println("Deve ter sido alguém aqui na zona que se mudou e deixou isto para trás...");
        System.out.println(jogador.getNome() + ", vais remexer no caixote a ver se tem lá alguma coisa de jeito?");
        int opcaoLixo;
        do {
            System.out.println();
            System.out.println("[1] SIM");
            System.out.println("[2] NÃO");
            System.out.print("Insere uma das opções: ");
            Scanner inputLixo = new Scanner(System.in);
            opcaoLixo = inputLixo.nextInt();
        } while (opcaoLixo < 1 || opcaoLixo > 2);

        switch (opcaoLixo) {
            case 1: // Remexer o caixote
                System.out.println();
                printFile("Files/ascii/vhs.txt"); // Imprimir ficheiro na consola
                System.out.println();
                System.out.println("Encontras uma cassete VHS que levas para casa, mas não tens um leitor para ver o que contém.");
                System.out.println("Queres ir ao OLX ver se arranjas algum leitor?");
                int opcaoOLX;
                do {
                    System.out.println();
                    System.out.println("[1] Sim, porque estás muito curioso e vais dar-te a esse trabalho");
                    System.out.println("[2] Tens mais que fazer e não vais gastar dinheiro num equipamento obsoleto");
                    System.out.print("Insere uma das opções: ");
                    Scanner inputLixo = new Scanner(System.in);
                    opcaoOLX = inputLixo.nextInt();
                } while (opcaoOLX < 1 || opcaoOLX > 2);
                switch (opcaoOLX) {
                    case 1: // Ir ao OLX
                        System.out.println();
                        System.out.println("Encontraste um leitor VHS em bom estado, a funcionar, mas custa €2500...");
                        System.out.println("Trocas umas impressões com o vendedor e tens de decidir.");
                        System.out.println("Vais comprar o leitor de VHS, " + jogador.getNome() + "?");
                        int opcaoComprarLeitor;
                        do {
                            System.out.println();
                            System.out.println("[1] Sim, e pagas logo os €2500 que o vendedor está a pedir");
                            System.out.println("[2] Vais ver se ele baixa o preço porque este valor é ridículo...");
                            System.out.print("Insere uma das opções: ");
                            Scanner inputLixo = new Scanner(System.in);
                            opcaoComprarLeitor = inputLixo.nextInt();
                        } while (opcaoComprarLeitor < 1 || opcaoComprarLeitor > 2);
                        switch (opcaoComprarLeitor) {
                            case 1: // Comprar o leitor VHS
                                System.out.println();
                                jogador.setDinheiro(jogador.getDinheiro() - 2500); // Retirar €2500 ao dinheiro do jogador
                                System.out.println("Perdes o amor aos €2500, levas o leitor para casa e descobres que a cassete é uma \"sex tape\" da Madre Superiora que te expulsou quando fizeste 18 anos!");
                                System.out.println("O que vais fazer com isto, " + jogador.getNome() + "?");
                                int opcaoSexTape;
                                do {
                                    System.out.println();
                                    System.out.println("[1] Vender a cassete à Madre Superiora");
                                    System.out.println("[2] Vender a cassete a um canal televisivo");
                                    System.out.println("[3] Ficar com a cassete para vê-la regularmente");
                                    System.out.print("Insere uma das opções: ");
                                    Scanner inputLixo = new Scanner(System.in);
                                    opcaoSexTape = inputLixo.nextInt();
                                } while (opcaoSexTape < 1 || opcaoSexTape > 3);
                                switch (opcaoSexTape) {
                                    case 1: // Vender à Madre Superiora
                                        System.out.println();
                                        playMusic("Files/audio/dinheiro.wav"); // Correr ficheiro de áudio
                                        printFile("Files/ascii/dinheiro.txt"); // Imprimir ficheiro na consola
                                        System.out.println();
                                        System.out.println("A Madre Superiora cedeu à tua chantagem, pagou-te €10000 pela cassete,\ne ainda te deu algumas sex tapes das amigas (onde ela não aparece, claro).");
                                        jogador.setDinheiro(jogador.getDinheiro() + 10000); // Adicionar €10000 ao dinheiro do jogador
                                        System.out.println("Tens agora €" + jogador.getDinheiro() + " na conta bancária.");
                                        break;
                                    case 2: // Vender a um canal televisivo
                                        System.out.println();
                                        playMusic("Files/audio/dinheiro.wav"); // Correr ficheiro de áudio
                                        printFile("Files/ascii/dinheiro.txt"); // Imprimir ficheiro na consola
                                        System.out.println();
                                        System.out.println("Pagam-te €5000 pela cassete, há um escândalo a nível nacional e a tua história é tornada pública, o que faz de ti uma celebridade.\nÉs convidado com frequência para participar em \"reality shows\" e presenças em sítios.");
                                        jogador.setDinheiro(jogador.getDinheiro() + 5000); // Adicionar €5000 ao dinheiro do jogador
                                        System.out.println("Tens agora €" + jogador.getDinheiro() + " na conta bancária.");
                                        jogador.setCelebridade(true);
                                        System.out.println();
                                        System.out.println("A Madre Superiora fica danada, mete-te um processo em cima por difamação e recusa todas as acusações,\ngarantindo que é tudo falso e feito com recurso a Inteligência Artificial.");
                                        System.out.println("Ganha o caso e és condenado a pagar-lhe €10000 pelos danos morais que lhe causaste.");
                                        jogador.setDinheiro(jogador.getDinheiro() - 10000); // Retirar €10000 ao dinheiro do jogador
                                        System.out.println("Tens agora €" + jogador.getDinheiro() + " na conta bancária.");
                                        break;
                                    case 3: // Ficar com a cassete
                                        System.out.println();
                                        playMusic("Files/audio/sextape.wav"); // Correr ficheiro de áudio
                                        printFile("Files/ascii/sextape.txt"); // Imprimir ficheiro na consola
                                        System.out.println();
                                        System.out.println("Guardaste a cassete na tua colecção, e passou a ser o teu filme favorito.");
                                        System.out.println("Vês regularmente enquanto comes pipocas.");
                                        break;
                                    default:
                                        // Opção controlada pelo do while em cima, que só permite escolher uma das opções válidas
                                        break;
                                }
                                System.out.println();
                                break;
                            case 2: // Não comprar o leitor VHS
                                playMusic("Files/audio/boo.wav"); // Correr ficheiro de áudio
                                System.out.println();
                                System.out.println("Armas-te em otário a tentar baixar demasiado o preço, e acabas exposto no \"LOLX\".");
                                System.out.println("Não tens nenhum leitor VHS, portanto ficas sem saber o que estava na cassete.");
                                break;
                            default:
                                // Opção controlada pelo do while em cima, que só permite escolher uma das opções válidas
                                break;
                        }
                        break;
                    case 2: // Não ir ao OLX
                        playMusic("Files/audio/boo.wav"); // Correr ficheiro de áudio
                        System.out.println();
                        System.out.println("Guardaste a cassete numa gaveta e ficaste sem saber o conteúdo. Para sempre...");
                        System.out.println("O programador fica amuado porque levou trabalho a desenvolver esta narrativa e tu és uma seca.");
                        break;
                    default:
                        // Opção controlada pelo do while em cima, que só permite escolher uma das opções válidas
                        break;
                }
                System.out.println();
                break;

            case 2: // Não remexer o caixote
                playMusic("Files/audio/boo.wav"); // Correr ficheiro de áudio
                System.out.println();
                System.out.println("Voltaste para casa. Não és gajo para andar a remexer o lixo dos outros...");
                System.out.println("O programador fica amuado porque levou trabalho a desenvolver esta narrativa e tu és uma seca.");
                break;
            default:
                // Opção controlada pelo do while em cima, que só permite escolher uma das opções válidas
                break;
        }
        System.out.println();
        System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
        System.out.println();
    }
}