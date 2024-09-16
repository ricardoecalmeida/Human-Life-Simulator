package View.Actividades;

import Domain.Pessoas.Jogador;
import Domain.Pessoas.Profissao;

import java.util.ArrayList;
import java.util.Scanner;

import static Controllers.FormalController.acessorioFormal;

public class Emprego {

    /**
     * Método em que o jogador vai fazer a actividade procurar emprego.
     * Imprime a lista de todas as vagas disponíveis no Centro de Emprego
     * e atribui uma Profissão ao protagonista, caso este seja elegível.
     *
     * @param jogador    Protagonista do jogo
     * @param profissoes ArrayList de todas as profissões disponíveis
     */
    public static void centroEmprego(Jogador jogador, ArrayList<Profissao> profissoes) {
        System.out.println("até ao Centro de Emprego.");
        System.out.println();
        System.out.println(jogador.getNome() + ", tens " + jogador.getEducacao() + " pontos de nível de Educação e " + jogador.getEstatuto() + " de nível de Estatuto.");
        System.out.println("Pensa também se tens a pinta necessária (acessórios de moda formais) para desempenhar as funções do emprego, caso isso te seja exijido!");
        System.out.println("Atenção! Só serás aceite caso cumpras todos os requisitos para emprego a que te propões!");
        System.out.println();
        System.out.println("••• Lista de vagas disponíveis •••");
        System.out.println();
        int contadorProfissoes = 0; // Instanciar um contador inicializado a zero
        for (Profissao profissaoActual : profissoes) { // Ciclo for each que lista todas as profissões
            System.out.println("- Oferta de Emprego ID " + contadorProfissoes); // Mostrar o ID
            profissaoActual.exibirDetalhesProfissao(); // Exibir os detalhes completos da oferta de emprego
            contadorProfissoes++; // Incrementar o contador
        }
        System.out.println();
        System.out.println(jogador.getNome() + ", a que emprego te queres candidatar?");
        System.out.print("Insere o ID: ");
        Scanner inputEscolhaEmprego = new Scanner(System.in); // Instancia um scanner para receber input do utilizador
        int candidaturaEmprego = inputEscolhaEmprego.nextInt(); // Gravar o input
        Profissao emprego = profissoes.get(candidaturaEmprego); // Instanciar um novo objecto de Profissao que recebe o ID introduzido como parâmetro
        System.out.println();
        // Verificar se o protagonista reúne todas as condições para que seja elegível para a profissão a que se candidatou
        // NOTA: Tentei introduzir na linha abaixo as 3 condições, mas não soube como comparar emprego formal com acessório não formal, sem causar conflitos na lógica
        if (jogador.getEstatuto() >= emprego.getEstatuto() && jogador.getEducacao() >= emprego.getNivelMinimoEducacao()) { // Verificar Estatuto e Educação
            if (emprego.isFormal() && !acessorioFormal(jogador)) { // Não tem um acessório de moda formal, que o emprego exige
                System.out.println("A tua candidatura foi recusada porque não tens a pinta necessária para desempenhar esta função.");
                System.out.println("Sugestão: Vai ao Shopping comprar um acessório de moda que te faça parecer gente...");
                System.out.println();
            } else { // Se tem Estatuto, Educação e acessório de moda formal (caso seja exijido), é recrutado
                System.out.println("Parabéns! A tua candidatura foi entregue e o recrutador adorou-te!");
                System.out.println(jogador.getNome() + ", agora és um orgulhoso " + emprego.getNome() + " e vais ganhar €" + emprego.getSalarioDia() + " sempre que fores trabalhar!");
                jogador.setProfissao(emprego); // Atribir a profissão ao jogador
                System.out.println();
            }
        } else { // Caso algum dos requisitos Estatuto e/ou Educação não seja(m) cumprido(s)
            if (jogador.getEstatuto() < emprego.getEstatuto()) { // Não tem nível de Estatuto suficiente para o emprego
                System.out.println("A tua candidatura foi recusada porque tens Estatuto nível " + jogador.getEstatuto() + " e a vaga a que te propuseste exige um mínimo de " + emprego.getEstatuto() + ".");
                System.out.println("Sugestão: Vai ao Shopping comprar coisas para pareceres importante!");
                System.out.println();
            }
            if (jogador.getEducacao() < emprego.getNivelMinimoEducacao()) { // Não tem nível de Educação suficiente para o emprego
                System.out.println("A tua candidatura foi recusada porque tens Educação nível " + jogador.getEducacao() + " e a vaga a que te propuseste exige um mínimo de " + emprego.getNivelMinimoEducacao() + ".");
                System.out.println("Sugestão: Vai estudar, seu burro!");
                System.out.println();
            }
        }
        System.out.println();
    }
}