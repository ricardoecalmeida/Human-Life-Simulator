package View;

import Domain.Enums.Objectivo;
import Domain.Pessoas.Jogador;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static Tools.BibliotecaFuncoes.cheatCodeActivated;
import static Tools.BibliotecaFuncoes.printFile;

public class CriarJogador {

    /**
     * Método para criar um protagonista para o jogo.
     *
     * @return Jogador Protagonista do jogo
     */
    public static Jogador criarJogador() throws InterruptedException, FileNotFoundException {
        String cheat = "klapaucius"; // Instanciar variável cheat code que permite ganhar o jogo logo no início
        String tobias = "tobias"; // Instanciar variável que mostra o Tobias
        System.out.print("Qual é o teu nome? ");
        Scanner input = new Scanner(System.in); // Instanciar scanner para ler o input do utilizador
        String meuNome = input.nextLine(); // Gravar o input na variável meuNome
        if (meuNome.equalsIgnoreCase(cheat)) { // Se o nome introduzido for o cheat code...
            cheatCodeActivated(); // Activa o cheat, invocando a função cheatCodeActivated
        }
        if (meuNome.equalsIgnoreCase(tobias)) { // Se o nome introduzido for o cheat code...
            printFile("Files/ascii/tobias.txt"); // Mostra o Tobias e continua o jogo
            System.out.println();
        }
        System.out.print("Que idade tens? ");
        int minhaIdade = input.nextInt(); // Grava o input correspondente à idade numa variável de inteiros
        if (minhaIdade < 18) { // Se for menor de idade (menos de 18)
            System.out.println();
            System.out.println(meuNome + ", este jogo não é para a tua idade! Vou assumir que");
            System.out.println("pediste autorização aos teus pais e vou-te deixar jogar na mesma...");
        }
        System.out.println();
        System.out.println("O criador não se responsabiliza por susceptibilidades feridas.");
        System.out.println("Considere-se avisado e jogue por sua conta e risco!");
        System.out.println();
        System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
        System.out.println();
        System.out.println(meuNome + ", foste à rua pôr o lixo e encontraste um bebé do sexo masculino");
        System.out.println("embrulhado junto ao contentor, e agora tens de cuidar dele.");
        System.out.println("Leva-o para tua casa e vai pensando no nome que lhe vais dar...");
        System.out.println();
        System.out.print("Foste até ao Registo Civil e o que te ocorreu pelo caminho foi o nome: ");
        Scanner inputNomeProtagonista = new Scanner(System.in); // Instanciar um scanner para ler o input do utilizador
        String nome = inputNomeProtagonista.nextLine(); // Gravar o input como nome do protagonista do jogo
        System.out.println();
        System.out.println("Parabéns, " + meuNome + "! Registaste com sucesso o teu bebé com o nome " + nome + "!");
        int opcao;
        do {
            System.out.println();
            System.out.println("Que objectivo de vida pretendes que o " + nome + " cumpra?");
            System.out.println("[1] Milionário");
            System.out.println("[2] Celebridade");
            System.out.println("[3] Família");
            System.out.println("[4] Sucesso");
            System.out.print("Escolhe uma das opções: ");
            Scanner inputOpcao = new Scanner(System.in);
            opcao = inputOpcao.nextInt();
            System.out.println();
        } while (opcao < 1 || opcao > 4); // Garante que a opção seja uma das indicadas (de 1 a 4), caso contrário mostra novamente as opções.
        Objectivo objectivo = null; // Inicializar objectivo a nulo, porque só vai assumir o valor definitivo consoante o case abaixo
        switch (opcao) {
            case 1:
                objectivo = Objectivo.MILIONARIO;
                System.out.print("Queres que o " + nome + " seja MILIONÁRIO ");
                break;
            case 2:
                objectivo = Objectivo.CELEBRIDADE;
                System.out.print("Queres que o " + nome + " seja uma CELEBRIDADE ");
                break;
            case 3:
                objectivo = Objectivo.FAMILIA;
                System.out.print("Queres que o " + nome + " tenha uma FAMÍLIA numerosa ");
                break;
            case 4:
                objectivo = Objectivo.SUCESSO;
                System.out.print("Queres que o " + nome + " tenha muito SUCESSO profissional ");
                break;
            default:
                // Opção controlada pelo do while em cima, que só permite escolher uma das opções válidas
                break;
        }
        System.out.println("e esse será o OBJECTIVO do jogo!");
        System.out.println();
        System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
        // Retornar um Jogador com os atributos já preenchidos e pronto a iniciar o jogo
        return new Jogador(nome, 0, objectivo, null, 100, 100, 100, 0, 0, false, false, false);
    }
}