package Controllers;

import Domain.Pessoas.Jogador;
import Domain.Pessoas.NPC;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static View.Eventos.Boletim.boletim;
import static View.Eventos.Cirurgia.cirurgia;
import static View.Eventos.Crime.crime;
import static View.Eventos.Lixo.lixo;
import static View.Eventos.PremioCarreira.premioCarreira;
import static View.Eventos.Casamento.registoCivil;
import static View.Eventos.Universidade.universidade;

public class EventosController {

    /**
     * Método que faz iniciar eventos especiais na vida do jogador,
     * em dias específicos e fora do seu ciclo diário habitual.
     *
     * @param jogador      Protagonista do jogo
     * @param pessoas      Conjunto de pessoas NPC
     * @param contadorDias Contador de dias
     */
    public static void eventos(Jogador jogador, ArrayList<NPC> pessoas, int contadorDias) throws FileNotFoundException {
        // Evento 1: Universidade
        // Útil se o objectivo for SUCESSO e ajuda a ganhar mais dinheiro caso o objectivo seja MILIONÁRIO
        // Pros: Ganha pontos de Educação; desbloqueia o Diploma, sem o qual não pode receber o Prémio Carreira
        // Contras: Perde dinheiro
        if (contadorDias == 5) { // Ao dia 5, perguntar ao protagonista se quer ir para a Universidade
            universidade(jogador);
        }
        // Evento 2: Lixo
        // Útil se o objectivo for MILIONÁRIO ou CELEBRIDADE
        // Pros: Ganha muito dinheiro ou passa a ser uma celebridade
        // Contras: Perde dinheiro, se passar a ser celebridade
        if (contadorDias == 13) { // Ao dia 13, o protagonista encontra um item no lixo
            lixo(jogador);
        }
        // Evento 3: Casamento
        // Útil se objectivo for FAMÍLIA, CELEBRIDADE ou MILIONÁRIO
        // Pros: Fica com o dinheiro do NPC com quem casar; desbloqueia a opção de ter filhos;
        // pode passar a ser celebridade, se casar com o NPC "celebridade"
        // Contras: Tem de pagar um valor diário pela existência de um novo membro da família;
        // e pode ficar sem a totalidade do dinheiro que tiver, se casar com o NPC "gold digger"
        if (contadorDias == 22) { // Ao dia 22, perguntar ao protagonista se pretende casar
            registoCivil(jogador, pessoas);
        }
        // Evento 4: Cirurgia
        // Útil se objectivo for FAMÍLIA
        // Pros: Fica extremamente fértil e faz muitos filhos de uma só vez
        // Contras: Tem de pagar diariamente para os sustentar a todos
        if (contadorDias == 30) { // Ao dia 30, perguntar a protagonista se quer fazer uma intervenção cirúrgica
            cirurgia(jogador, pessoas);
        }
        // Evento 5: Boletim
        // Útil se objectivo for MILIONÁRIO
        // Pros: Pode ficar muito rico
        // Contras: Corre o risco de ficar exactamente como está
        if (contadorDias == 50) { // Ao dia 50, o protagonista encontra um boletim no chão
            boletim(jogador);
        }
        // Evento 6: Crime
        // Útil se o objectivo for MILIONÁRIO, mas pode correr mal se o objectivo for CELEBRIDADE ou SUCESSO
        // Pros: Pode ficar muito rico, se cometer um crime e não for apanhado
        // Contras: Pode ser apanhado, ir para a cadeia, ser despedido, e celebridade ou diploma deixam de ter efeito
        if (contadorDias == 70) { // Ao dia 70, o protagonista tem oportunidade de cometer um crime
            crime(jogador);
        }
        // Evento 7: Prémio Carreira
        // Útil se o objectivo for SUCESSO
        // Pros: Vê reconhecido o trabalho desenvolvido ao longo da vida
        // Contras: Não existem, mas o protagonista pode não ser o vencedor do prémio
        if (contadorDias == 85) { // Ao dia 85, há uma gala, e o protagonista pode ser um dos premiados
            premioCarreira(jogador);
        }
    }
}