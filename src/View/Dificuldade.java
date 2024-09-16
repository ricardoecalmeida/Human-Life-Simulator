package View;

import Domain.Pessoas.Jogador;
import Domain.Propriedades.Propriedade;

import java.util.Scanner;

public class Dificuldade {

    public static void dificuldade(Jogador jogador) {
        int dificuldade;
        do {
            System.out.println();
            System.out.println("Em que nível de dificuldade queres jogar?");
            System.out.println("[1] PAPA FEITA • [Nem tem piada, de tão fácil que é...]");
            System.out.println("[2] FÁCIL • [Para os que são fracos a jogar isto...]");
            System.out.println("[3] MÉDIO • [NÍVEL RECOMENDADO]");
            System.out.println("[4] DIFÍCIL • [Desaconselhado, mas se acreditas, vai!]");
            System.out.println("[5] IMPOSSÍVEL • [Não recomendado. Nem dá para jogar...]");
            Scanner dificuldadeinput = new Scanner(System.in);
            dificuldade = dificuldadeinput.nextInt();
        } while (dificuldade < 1 || dificuldade > 5);
        System.out.println();
        switch (dificuldade) {
            case 1: // Papa feita
                System.out.println("Dificuldade: PAPA FEITA");
                jogador.setDinheiro(1000000);
                System.out.println("- Herdaste €1000000!");
                // Instanciar uma propriedade nova
                Propriedade propriedadeHeranca = new Propriedade("Buckingham Palace, London",9999999,99999999);
                jogador.getPropriedades().add(propriedadeHeranca); // Adicionar propriedade às propriedades do jogador
                System.out.println("- Herdaste o Buckingham Palace!");
                jogador.setCelebridade(true);
                System.out.println("- És uma celebridade!");
                jogador.setDiploma(true);
                System.out.println("- Já fizeste Licenciatura, Mestrado, Doutoramento e Pós-Graduação enquanto estavas nas freiras.");
                jogador.setEducacao(500);
                System.out.println("- Já tiraste os cursos todos que existem no jogo.");
                jogador.setEstatuto(500);
                System.out.println("- És um gajo reputadíssimo!");
                break;
            case 2: // Fácil
                System.out.println("Dificuldade: FÁCIL");
                jogador.setDinheiro(100000);
                System.out.println("- Herdaste €100000!");
                jogador.setEducacao(50);
                System.out.println("- Aprendeste algumas coisas enquanto estavas nas freiras e já tens algum nível de Educação");
                jogador.setEstatuto(50);
                System.out.println("- Já és um gajo com algum estatuto...");
                break;
            case 3: // Médio (NORMAL)
                System.out.println("Dificuldade: MÉDIO");
                System.out.println("- Tens €0 na tua conta bancária, mas ao menos não deves nada a ninguém.");
                System.out.println("- És um burro. Tens 0 de nível de Educação. Tens de aprender umas coisas entretanto.");
                System.out.println("- És um Zé Ninguém. Tens 0 de nível de Estatuto. Trata disso no Shopping.");
                break;
            case 4: // Difícil
                System.out.println("Dificuldade: DIFÍCIL");
                jogador.setDinheiro(-1000);
                System.out.println("- Tens uma dívida de €1000.");
                System.out.println("- Insultaste e mandaste um banano a uma Nossa Senhora de cerâmica um dia que chegaste bêbado, partiu-se toda em cacos e agora tens de pagar uma nova.");
                System.out.println("- És um burro. Tens 0 de nível de Educação. Tens de aprender umas coisas entretanto.");
                System.out.println("- És um Zé Ninguém. Tens 0 de nível de Estatuto. Trata disso no Shopping.");
                break;
            case 5: // Impossível
                System.out.println("Dificuldade: IMPOSSÍVEL");
                jogador.setDinheiro(-10000);
                System.out.println("- Jogaste a dinheiro à macaca com o chefe da Máfia e perdeste. Contraíste uma dívida de €10000.");
                jogador.setEducacao(-100);
                System.out.println("- Em vez de aprenderes coisas, dedicaste o teu tempo a desaprender. És extremanente burro.");
                jogador.setEstatuto(-100);
                System.out.println("- Tens a reputação na lama e ninguém te respeita. És o maior falhado de sempre.");
                jogador.setSono(-100);
                System.out.println("- Tens umas olheiras até aos joelhos.");
                jogador.setFome(-100);
                System.out.println("- A última vez que comeste ainda nem tinha sido inventado o sistema digestivo.");
                jogador.setSocial(-100);
                System.out.println("- Os teus amigos são todos imaginários e, mesmo assim, odeiam-te.");
                break;
            default:
                // Opção controlada pelo do while em cima, que só permite escolher uma das opções válidas
                break;
        }
        System.out.println();
    }
}