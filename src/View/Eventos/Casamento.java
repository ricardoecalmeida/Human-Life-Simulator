package View.Eventos;

import Domain.Pessoas.Jogador;
import Domain.Pessoas.NPC;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static Tools.Audio.playMusic;
import static Tools.BibliotecaFuncoes.printFile;

public class Casamento {

    /**
     * Método para o jogador casar com uma pessoa NPC
     *
     * @param jogador Protagonista do jogo
     * @param pessoas Conjunto de pessoas NPC
     */
    public static void registoCivil(Jogador jogador, ArrayList<NPC> pessoas) throws FileNotFoundException {
        System.out.println();
        System.out.println("••••••••••••••••••••••••••••••• CASAMENTO •••••••••••••••••••••••••••••••");
        System.out.println();
        if (jogador.getCasado()) { // Se o protagonista já for casado, não pode casar outra vez.
            // Nota: Da forma como o jogo está desenhado agora, nunca irá aparecer esta opção, mas fica já aqui
            // desenvolvido, para o caso de mais tarde serem introduzidas alterações (casar sem ser por evento ao dia 22)
            System.out.println("Neste jogo a poligamia não é permitida, " + jogador.getNome() + ". Já estás casado, portanto, não te podes casar outra vez!");
            System.out.println();
        } else { // Se não for casado, pode propor casamento a um dos NPC
            System.out.println("Hoje é dia 31 de Julho e ouviste dizer, de um senhor de bigode e acordeão, que este é o melhor dia para casar!");
            System.out.println();
            System.out.println("O " + jogador.getNome() + " foi até ao Registo Civil consultar um catálogo de pessoas disponíveis para Casamento.");
            System.out.println();
            System.out.println("••• Lista de nubentes disponíveis •••");
            System.out.println();
            int contadorPessoas = 0; // Variável que vai servir de contador e vai dar o ID de cada NPC
            for (NPC pessoaActual : pessoas) { // Ciclo for each para percorrer ArrayList de pessoas
                // Se este NPC tiver estatuto diferente de 0 (não apresenta bebés)
                if (pessoaActual.getEstatutoMinimo() != 0) {
                    System.out.print("- CC n.º 127630" + contadorPessoas + " • "); // Imprimir o número de C.C. do NPC
                    pessoaActual.exibirDetalhesNPC(); // Exibir os restantes detalhes do NPC
                }
                contadorPessoas++; // Incrementar o contador
            }
            System.out.println();
            System.out.println(jogador.getNome() + ", com quem queres casar?");
            System.out.println("Deves indicar os últimos 2 algarismos do n.º de Cartão de Cidadão da pessoa com quem queres casar.");
            int nubente;
            do {
                System.out.print("Insere os últimos 2 algarismos do C.C.: ");
                Scanner inputEscolhaNubente = new Scanner(System.in); // Instanciar scanner para receber input do utilizador
                nubente = inputEscolhaNubente.nextInt(); // Gravar input numa variável
                System.out.println();
            } while (nubente < 6 || nubente > 19); // Limita a escolha aos NPC adultos e disponíveis para casar
            NPC nubenteProposto = pessoas.get(nubente); // Instaciar um novo objecto NPC e define-o como o que corresponde ao ID escolhido

            switch (nubente) {
                case 6: // Caso a nubente seja a "gold digger" do jogo
                    if (jogador.getDinheiro() > 0) { // Se o jogador tiver dinheiro, ela casa, e nem precisa de ter uma casa, o que ela quer é o dinheiro!
                        playMusic("Files/audio/casamento_s.wav"); // Correr ficheiro de áudio
                        printFile("Files/ascii/casamento.txt"); // Imprimir ficheiro na consola
                        System.out.println();
                        System.out.println("PARABÉNS " + jogador.getNome() + "!");
                        System.out.println("Casaste com a \"Gold Digger\" deste jogo, " + nubenteProposto.getNome() + ", que te limpou o guito todo da conta que foi um mimo!");
                        System.out.println("Ela não se importa com o teu estatuto nem com a casa que tens ou deixas de ter. Está interessada única e exclusivamente no teu dinheiro.");
                        System.out.print("Antes de casar tinhas €" + jogador.getDinheiro() + ", na conta bancária, e ");
                        jogador.setDinheiro(0); // A gold digger saca o dinheiro do jogador e deixa a conta a zero.
                        System.out.println("tens agora €" + jogador.getDinheiro() + ".");
                    } else {
                        playMusic("Files/audio/casamento_n.wav"); // Correr ficheiro de áudio
                        System.out.println("A " + nubenteProposto.getNome() + " não aceitou casar contigo porque não tens dinheiro.");
                    }
                    jogador.adicionarFamilia(nubenteProposto); // Adicionar NPC do nubenteProposto ao ArrayList da familia
                    jogador.setCasado(true); // Variável casado passa a assumir o valor "true"
                    System.out.println();
                    break;
                case 8: // Este NPC é uma celebridade, e quem casar com ele, passa a ser também uma celebridade
                    // Se o jogador tiver estatuto igual ou superior ao do nubente, e se o jogador possuir um imóvel com capacidade máxima de pelo menos 1 pessoa
                    if (jogador.getEstatuto() >= nubenteProposto.getEstatutoMinimo() && jogador.capacidadeMaximaFamilia() >= 1) {
                        playMusic("Files/audio/casamento_s.wav"); // Correr ficheiro de áudio
                        printFile("Files/ascii/casamento.txt"); // Imprimir ficheiro na consola
                        System.out.println();
                        System.out.println("PARABÉNS " + jogador.getNome() + "!");
                        System.out.println("Casaste com a Celebridade deste jogo, o " + nubenteProposto.getNome() + "!");
                        System.out.println("Limpaste-lhe os €" + nubenteProposto.getDinheiro() + " que tinha na conta bancária!");
                        jogador.setDinheiro(jogador.getDinheiro() + nubenteProposto.getDinheiro()); // Jogador fica com o dinheiro do NPC com quem casou
                        System.out.println("Passaste a aparecer nas revistas cor-de-rosa ao lado do " + nubenteProposto.getNome() + " e agora também és uma celebridade!");
                        jogador.setCasado(true); // Variável casado passa a assumir o valor "true"
                        jogador.setCelebridade(true); // Atribui a condição true à variável celebridade do jogador
                        jogador.adicionarFamilia(nubenteProposto); // Adicionar NPC do nubenteProposto ao ArrayList da familia
                    } else {
                        playMusic("Files/audio/casamento_n.wav"); // Correr ficheiro de áudio
                        System.out.println("O " + nubenteProposto.getNome() + " não aceitou casar contigo.");
                        System.out.println();
                        if (jogador.getEstatuto() <= nubenteProposto.getEstatutoMinimo()) { // Jogador não tem estatuto mínimo exigido pelo NPC proposto
                            System.out.println("Não tens estatuto para casar com " + nubenteProposto.getNome() + "!");
                            System.out.println("Sugestão: Vai comprar coisas ao Shopping.");
                            System.out.println();
                        }
                        if (jogador.capacidadeMaximaFamilia() <= 1) { // Jogador não tem imóvel para pelo menos 2 pessoas (ele próprio e a pessoa com quem quer casar)
                            System.out.println("Não tens casa para albergar " + nubenteProposto.getNome() + "!");
                            System.out.println("Sugestão: Vai à Imobiliária e compra uma casa com capacidade suficiente!");
                            System.out.println();
                        }
                    }
                    System.out.println();
                    break;
                case 9: // Este NPC é milionário, e quem casar com ele, fica também milionário porque fica com o dinheiro dele
                    // Se o jogador tiver estatuto igual ou superior ao do nubente, e se o jogador possuir um imóvel com capacidade máxima de pelo menos 1 pessoa
                    if (jogador.getEstatuto() >= nubenteProposto.getEstatutoMinimo() && jogador.capacidadeMaximaFamilia() >= 1) {
                        playMusic("Files/audio/casamento_s.wav"); // Correr ficheiro de áudio
                        printFile("Files/ascii/casamento.txt"); // Imprimir ficheiro na consola
                        System.out.println();
                        System.out.println("PARABÉNS " + jogador.getNome() + "!");
                        System.out.println("Casaste com o Milionário deste jogo, o " + nubenteProposto.getNome() + "!");
                        System.out.println("Limpaste-lhe os €" + nubenteProposto.getDinheiro() + " que tinha na conta bancária!");
                        jogador.setDinheiro(jogador.getDinheiro() + nubenteProposto.getDinheiro()); // Jogador fica com o dinheiro do NPC com quem casou
                        System.out.println("Tens agora €" + jogador.getDinheiro() + ".");
                        // ASCII CASAMENTO
                        jogador.setCasado(true); // Variável casado passa a assumir o valor "true"
                        jogador.adicionarFamilia(nubenteProposto); // Adicionar NPC do nubenteProposto ao ArrayList da familia
                    } else {
                        playMusic("Files/audio/casamento_n.wav"); // Correr ficheiro de áudio
                        System.out.println("O " + nubenteProposto.getNome() + " não aceitou casar contigo.");
                        System.out.println();
                        if (jogador.getEstatuto() <= nubenteProposto.getEstatutoMinimo()) { // Jogador não tem estatuto mínimo exigido pelo NPC proposto
                            System.out.println("Não tens estatuto para casar com " + nubenteProposto.getNome() + "!");
                            System.out.println("Sugestão: Vai comprar coisas ao Shopping.");
                            System.out.println();
                        }
                        if (jogador.capacidadeMaximaFamilia() <= 1) { // Jogador não tem imóvel para pelo menos 2 pessoas (ele próprio e a pessoa com quem quer casar)
                            System.out.println("Não tens casa para albergar " + nubenteProposto.getNome() + "!");
                            System.out.println("Sugestão: Vai à Imobiliária e compra uma casa com capacidade suficiente!");
                            System.out.println();
                        }
                    }
                    System.out.println();
                    break;
                case 15: // Este NPC tem razões para não casar
                    playMusic("Files/audio/casamento_n.wav"); // Correr ficheiro de áudio
                    System.out.println("O " + nubenteProposto.getNome() + " não aceitou casar contigo porque já é casado, e para além disso já tem a mulher grávida de 6 meses (sim, a sério!!!)");
                    System.out.println();
                    break;
                default: // Caso o/a nubente proposto/a seja outro que não o do índice 6, 8, 9 ou 15
                    // Se o jogador tiver estatuto igual ou superior ao do nubente, e se o jogador possuir um imóvel com capacidade máxima de pelo menos 1 pessoa
                    if (jogador.getEstatuto() >= nubenteProposto.getEstatutoMinimo() && jogador.capacidadeMaximaFamilia() >= 1) {
                        jogador.adicionarFamilia(nubenteProposto); // Adicionar NPC ao ArrayList familia
                        jogador.setDinheiro(jogador.getDinheiro() + nubenteProposto.getDinheiro()); // Jogador fica com o dinheiro do NPC com quem casou
                        playMusic("Files/audio/casamento_s.wav"); // Correr ficheiro de áudio
                        printFile("Files/ascii/casamento.txt"); // Imprimir ficheiro na consola
                        System.out.println();
                        System.out.println("PARABÉNS " + jogador.getNome() + "!");
                        System.out.println("Casaste com " + nubenteProposto.getNome() + " e limpaste-lhe os €" + nubenteProposto.getDinheiro() + " que tinha na conta bancária!");
                        System.out.println("Tens agora €" + jogador.getDinheiro() + ".");
                        jogador.setCasado(true); // Variável casado passa a assumir o valor "true"
                        System.out.println();
                    } else { // Caso não cumpra os requisitos e a proposta seja recusada
                        playMusic("Files/audio/casamento_n.wav"); // Correr ficheiro de áudio
                        System.out.println(nubenteProposto.getNome() + " recusou a tua proposta de casamento.");
                        System.out.println();
                        if (jogador.getEstatuto() <= nubenteProposto.getEstatutoMinimo()) { // Jogador não tem estatuto mínimo exigido pelo NPC proposto
                            System.out.println("Não tens estatuto para casar com " + nubenteProposto.getNome() + "!");
                            System.out.println("Sugestão: Vai comprar coisas ao Shopping.");
                            System.out.println();
                        }
                        if (jogador.capacidadeMaximaFamilia() <= 1) { // Jogador não tem imóvel para pelo menos 2 pessoas (ele próprio e a pessoa com quem quer casar)
                            System.out.println("Não tens casa para albergar " + nubenteProposto.getNome() + "!");
                            System.out.println("Sugestão: Vai à Imobiliária e compra uma casa com capacidade suficiente!");
                            System.out.println();
                        }
                        // Nunca entra nesta condicional porque está controlado acima, mas fica aqui na mesma
                        if (nubenteProposto.getEstatutoMinimo() == 0) { // O NPC proposto é uma criança (estatuto 0)
                            System.out.println("Não podes casar com " + nubenteProposto.getNome() + " porque é um recém-nascido!");
                            System.out.println("Sugestão: Casa com um/a adulto/a.");
                            System.out.println();
                        }
                    }
                    break;
            }
        }
        System.out.println();
        System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
        System.out.println();
    }
}