package View.Eventos;

import Domain.Pessoas.Jogador;

import java.io.FileNotFoundException;

import static Tools.Audio.playMusic;
import static Tools.BibliotecaFuncoes.printFile;

public class PremioCarreira {

    /**
     * Método onde é realizada uma gala de reconhecimento de mérito de profissionais da área do jogador
     *
     * @param jogador Protagonista do jogo
     */
    public static void premioCarreira(Jogador jogador) throws FileNotFoundException {
        System.out.println();
        System.out.println("•••••••••••••••••••••••••••• PRÉMIO CARREIRA ••••••••••••••••••••••••••••");
        System.out.println();
        System.out.println("A tua vida aproxima-se da recta final e algumas pessoas da tua área profissional");
        System.out.println("aproveitam ocasião de uma gala anual e pensam em reconhecer o teu mérito enquanto");
        System.out.println("reputadíssimo profissional com a atribuição do prestigiado PRÉMIO CARREIRA.");
        System.out.println("Não há dúvida que o " + jogador.getNome() + " é um " + jogador.getProfissao().getNome() + " de excelência!");
        System.out.println("Mas será que ganha?");
        System.out.println();
        System.out.println("Estão a anunciar os nomeados e \"" + jogador.getNome() + "\" é um deles!");
        String conjuge = "";
        if (jogador.getCasado()) { // Se o jogador for casado
            conjuge = jogador.getFamilia().get(0).getNome();
        }
        System.out.println(conjuge + " olha para ti com uma expressão de orgulho.");
        System.out.println();
        if (jogador.getDiploma() && jogador.getEducacao() >= 70) { // Se o jogador concluiu o Ensino Superior e se tem nível de Educação igual ou superior a 70
            playMusic("Files/audio/premio_s.wav"); // Correr ficheiro de áudio
            printFile("Files/ascii/premio.txt"); // Imprimir ficheiro na consola
            System.out.println();
            System.out.println("Parabéns! Ganhaste uma elegante estatueta que representa os profissionais de " + jogador.getProfissao().getNome() + "!");
        } else {
            playMusic("Files/audio/premio_n.wav"); // Correr ficheiro de áudio
            if (!jogador.getDiploma()) { // Se o protagonista não concluiu o Ensino Superior
                System.out.println("Deram o prémio a outro gajo... Um com diploma, que tu não tens.");
                System.out.println("Devias ter ido para a Universidade quando tiveste oportunidade! Estudasses!");
            } else {
                if (jogador.getEducacao() < 70) { // Se o protagonista tem o nível de Educação inferior a 70
                    System.out.println("Deram o prémio a outro gajo... Um com um nível de educação superior ao teu.");
                    System.out.println("Devias ter aprendido mais ao longo da vida! Estudasses!");
                }
            }
        }
        System.out.println();
        System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
        System.out.println();
    }
}