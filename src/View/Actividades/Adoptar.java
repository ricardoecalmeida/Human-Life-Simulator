package View.Actividades;

import Domain.Pessoas.Jogador;
import Domain.Pessoas.NPC;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

import static Tools.Audio.playMusic;
import static Tools.BibliotecaFuncoes.printFile;

public class Adoptar {

    /**
     * Método para o jogador adoptar uma criança NPC
     *
     * @param jogador Protagonista do jogo
     * @param pessoas ArrayList de pessoas NPC
     */
    public static void adoptar(Jogador jogador, ArrayList<NPC> pessoas) throws FileNotFoundException {
        System.out.println("adoptar crianças.");
        if (jogador.getCasado()) { // Se o jogador for casado
            // Se o tamanho da família (já com um eventual elemento adicinal) for menor do que a capacidade do imóvel com maior capacidade
            if (jogador.getFamilia().size() < 7) { // Só permite avançar caso tenha menos do que 7 elementos na família
                if (jogador.getFamilia().size() + 1 <= jogador.capacidadeMaximaFamilia()) { // Permitir adoptar caso o imóvel com mais capacidade possa albergar o tamanho actual da família e mais 1 elemento
                    int tamanhoActualFamilia = jogador.getFamilia().size(); // Criar variável para guardar valor de tamanho actual da família do jogador
                    int tamanhoNovoFamilia = tamanhoActualFamilia + 1; // Criar variável com esse valor mais 1
                    int indexAleatorio;
                    while (jogador.getFamilia().size() < tamanhoNovoFamilia) { // Enquanto o tamanho actual não for o tamanho actualizado
                        Random randomNumber = new Random(); // Instanciar um objecto de Random
                        indexAleatorio = randomNumber.nextInt(pessoas.size());
                        for (NPC pessoaActual : pessoas) { // Ciclo for each para iterar o ArrayList de pessoas
                            if (pessoaActual.getNome().equals(pessoas.get(indexAleatorio).getNome())) { // Quando o NPC aleatório coincide com o actual
                                if (pessoas.get(indexAleatorio).getEstatutoMinimo() == 0 && pessoas.get(indexAleatorio).getDinheiro() == 0) { // Se for um NPC elegível para adoptar
                                    NPC bebeNovo = new NPC(pessoas.get(indexAleatorio).getNome(), 0, 0); // Instanciar um NPC novo na posição aleatória
                                    jogador.adicionarFamilia(bebeNovo); // Adicionar NPC ao ArrayList familia
                                    playMusic("Files/audio/adoptar.wav"); // Correr ficheiro de áudio
                                    printFile("Files/ascii/bebe.txt"); // Imprimir ficheiro na consola
                                    System.out.println();
                                    System.out.println("Parabéns! Adoptaste " + bebeNovo.getNome() + "!");
                                } else { // Se percorreu o ArryList de pessoas e não conseguiu adicionar mais nenhum NPC, significa que já não há mais nenhum elegível e o jogador já adoptou os 6 disponíveis no jogo
                                    // System.out.println("Já não existem mais crianças para adoptar.");
                                    break; // É preciso quebrar o ciclo while caso contrário cria um ciclo infinito
                                }
                            }
                        }
                        pessoas.remove(indexAleatorio); // Remover o NPC adoptado do ArrayList pessoas (fora do ciclo for each)
                    }
                } else { // Se o jogador não tem um imóvel com capacidade suficiente
                    System.out.println("A Segurança Social foi a tua casa e achou que não tens espaço em casa para albergar mais gente.");
                    System.out.println("Não podes adoptar crianças com estas condições...");
                    System.out.println("Sugestão: Vai à imobiliária e compra uma casa maior!");
                }
            } else {
                System.out.println("Já adoptaste todas as crianças que existem neste jogo.");
            }
        } else { // Se o jogador não for casado
            System.out.println(jogador.getNome() + ", tens de casar primeiro, antes de ter filhos. Achas que a Segurança Social vai entregar assim uma criança a um solteiro?");
            System.out.println();
        }
        System.out.println();
    }
}