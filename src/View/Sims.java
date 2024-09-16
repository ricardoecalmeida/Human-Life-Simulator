package View;

import Domain.Pessoas.Jogador;
import Domain.Pessoas.NPC;
import Domain.Pessoas.Profissao;
import View.Shopping.Shopping;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static Tools.BibliotecaFuncoes.intro;
import static View.Ciclos.ciclos;
import static View.CriarJogador.criarJogador;
import static View.Dificuldade.dificuldade;
import static View.Final.finalJogo;
import static View.Historia.historia;
import static View.Repetir.repetir;

public class Sims {

    /**
     * Método de jogo onde decorrem as acções e momentos da vida do Jogador
     */
    public static void jogo() throws FileNotFoundException, InterruptedException {

        // ----- PESSOAS NPC ----- //
        NPC marta = new NPC("Marta Almeida", 0, 0); // Bebé
        NPC francisco = new NPC("Francisco Sousa", 0, 0); // Bebé
        NPC rita = new NPC("Rita Severa", 0, 0); // Bebé
        NPC joanaf = new NPC("Joana Fernandes", 0, 0); // Bebé
        NPC goncalo = new NPC("Gonçalo Pereira", 0, 0); // Bebé
        NPC ricardof = new NPC("Ricardo Fernandes", 0, 0); // Bebé
        NPC joanac = new NPC("Joana Cunha", 0.01, 1); // Gold digger. Jogador perde o dinheiro.
        NPC patricia = new NPC("Patrícia Matos", 800, 8);
        NPC atylla = new NPC("Átylla Kossatz", 1600, 16); // Celebridade. Joagdor passa a ser celebridade também.
        NPC ricardop = new NPC("Ricardo Pastor", 1000000, 24); // Milionário. Estatuto relativamente baixo, mas tem muito dinheiro.
        NPC nuno = new NPC("Nuno Madaleno", 3200, 32);
        NPC natana = new NPC("Natana Oliveira", 4000, 40);
        NPC natali = new NPC("Natali Lucas", 4800, 48);
        NPC joaof = new NPC("João Figueiredo", 5600, 56);
        NPC sofia = new NPC("Sofia Carvalho", 6400, 64);
        NPC diogo = new NPC("Diogo Pimentel", 7200, 72);
        NPC lais = new NPC("Laís Reis", 8000, 80);
        NPC joaov = new NPC("João Vale", 8800, 88);
        NPC ricardoa = new NPC("Ricardo Almeida", 0, 100); // Estatuto alto porque é uma batata casada. Contudo, se casar, só com um acordo pré-nupcial, portanto não partilha o dinheiro que tem.
        NPC vitor = new NPC("Vítor Santos", 1000000, 100); // Quem casar com este passa a ser milionário, mas para conseguir essa proeza, tem de ter um estatuto muito alto.
        // Instanciar um ArrayList e adicionar a este todas as instâncias de Pessoa NPC
        ArrayList<NPC> pessoas = new ArrayList<>();
        pessoas.add(marta);
        pessoas.add(francisco);
        pessoas.add(rita);
        pessoas.add(joanaf);
        pessoas.add(goncalo);
        pessoas.add(ricardof);
        pessoas.add(joanac);
        pessoas.add(patricia);
        pessoas.add(atylla);
        pessoas.add(ricardop);
        pessoas.add(nuno);
        pessoas.add(natana);
        pessoas.add(natali);
        pessoas.add(joaof);
        pessoas.add(sofia);
        pessoas.add(ricardoa);
        pessoas.add(diogo);
        pessoas.add(lais);
        pessoas.add(joaov);
        pessoas.add(vitor);

        // ----- PROFISSÕES ----- //
        Profissao profissao1 = new Profissao("Trolha de Software", "Bater código, bater no computador, e chorar de nervos quando este não funcionar.", 70, false, 25, 50);
        Profissao profissao2 = new Profissao("Vendedor de meias usadas no OLX", "Usar e vender meias usadas em plataformas de compra e venda de produtos.", 90, false, 10, 10);
        Profissao profissao3 = new Profissao("Dealer de folhas de louro prensadas", "As mesmas de um dealer tradicional, mas a droga que vende é falsa.", 50, false, 5, 5);
        Profissao profissao4 = new Profissao("Técnico de Limpeza de Toi Toi", "Limpar fezes, urina, e/ou outros produtos biológicos de casas de banho portáteis.", 30, false, 1, 5);
        Profissao profissao5 = new Profissao("Dominatrix de Leões", "Exercer o papel dominante em práticas sexuais de BDSM com felinos de grande porte.", 100, true, 50, 50);
        Profissao profissao6 = new Profissao("Acompanhante de Lixo", "Levar o lixo à rua, passea-lo e fazer-lhe companhia.", 200, true, 70, 30);
        Profissao profissao7 = new Profissao("Influencer Analógico", "Iguais à de um influencer digital, só usa tecnologias não-digitais, tais como cartas.", 40, true, 80, 30);
        Profissao profissao8 = new Profissao("Sósia do Ronaldo", "Faz-se passar por um jogador de futebol, tira selfies e dá autógrafos aos fãs.", 150, true, 100, 20);
        Profissao profissao9 = new Profissao("Mascote Tobias", "Estar no CESAE dentro de um boneco em forma de Tobias e acompanhar a turma de SoftDev.", 50, false, 20, 20);
        Profissao profissao10 = new Profissao("Magnatão Mandachuva", "Ser podre de rico e comprar coisas a preços exorbitantes.", 100000, true, 500, 1);
        // Instanciar um ArrayList e adicionar a este todas as profissões instanciadas
        ArrayList<Profissao> profissoes = new ArrayList<>();
        profissoes.add(profissao1);
        profissoes.add(profissao2);
        profissoes.add(profissao3);
        profissoes.add(profissao4);
        profissoes.add(profissao5);
        profissoes.add(profissao6);
        profissoes.add(profissao7);
        profissoes.add(profissao8);
        profissoes.add(profissao9);
        profissoes.add(profissao10);

        // ----- SHOPPING ----- //
        Shopping chopisCentis = new Shopping(); // Instanciar um Shopping

        // ----- DESENVOLVIMENTO DO JOGO ----- //
        intro(); // Invocar o método para apresentar o intro do jogo
        Jogador jogador = criarJogador(); // Invocar o método para criar um jogador, e instancia o protagonista do jogo com base no retorno desse método
        historia(jogador); // Invocar o método para apresentar a narrativa inicial da história
        dificuldade(jogador); // Invocar o método para definir o nível de dificuldade do jogo
        int contadorDias = 1; // Criar variável que conta os dias e inicializar a 1
        ciclos(jogador, profissoes, pessoas, contadorDias, chopisCentis); // Invocar o método que percorre os dias da vida do protagonista
        finalJogo(jogador, profissoes, pessoas, contadorDias, chopisCentis); // Invocar o método de final do jogo que avalia se o jogador cumpriu o objectivo
        repetir(jogador, profissoes, pessoas, contadorDias, chopisCentis); // Invocar método que pergunta ao utilizador se pretende jogar ou não de novo
    }
}