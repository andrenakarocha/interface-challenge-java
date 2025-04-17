package test.java;

import main.java.entities.Time;
import main.java.negocio.Campeonato;
import main.java.negocio.Partida;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class CampeonatoTest {

    @Test
    void deveCadastrarTime() {
        Campeonato campeonato = new Campeonato();
        Time timeA = new Time("Time A", "Cidade A");
        campeonato.cadastrarTime(timeA);
        assertEquals(1, campeonato.getTimes().size());
        assertTrue(campeonato.getTimes().contains(timeA));
    }

    @Test
    void deveRegistrarPartida() {
        Campeonato campeonato = new Campeonato();
        Time timeA = new Time("Time A", "Cidade A");
        Time timeB = new Time("Time B", "Cidade B");
        campeonato.cadastrarTime(timeA);
        campeonato.cadastrarTime(timeB);
        campeonato.registrarPartida(timeA, timeB);
        assertEquals(1, campeonato.getPartidas().size());
        assertEquals(timeA, campeonato.getPartidas().get(0).getTimeA());
        assertEquals(timeB, campeonato.getPartidas().get(0).getTimeB());
    }

    @Test
    void deveCalcularPontuacaoCorretamente() {
        Campeonato campeonato = new Campeonato();
        Time timeA = new Time("Time A", "Cidade A");
        Time timeB = new Time("Time B", "Cidade B");
        campeonato.cadastrarTime(timeA);
        campeonato.cadastrarTime(timeB);
        Partida partidaVitoriaA = new Partida(timeA, timeB);
        partidaVitoriaA.registrarPlacar(2, 1);
        Partida partidaEmpate = new Partida(timeA, timeB);
        partidaEmpate.registrarPlacar(1, 1);
        Partida partidaVitoriaB = new Partida(timeA, timeB);
        partidaVitoriaB.registrarPlacar(0, 3);

        campeonato.registrarPartida(partidaVitoriaA.getTimeA(), partidaVitoriaA.getTimeB());
        campeonato.registrarPlacar(partidaVitoriaA, partidaVitoriaA.getGolsTimeA(), partidaVitoriaA.getGolsTimeB());

        campeonato.registrarPartida(partidaEmpate.getTimeA(), partidaEmpate.getTimeB());
        campeonato.registrarPlacar(partidaEmpate, partidaEmpate.getGolsTimeA(), partidaEmpate.getGolsTimeB());

        campeonato.registrarPartida(partidaVitoriaB.getTimeA(), partidaVitoriaB.getTimeB());
        campeonato.registrarPlacar(partidaVitoriaB, partidaVitoriaB.getGolsTimeA(), partidaVitoriaB.getGolsTimeB());

        assertEquals(4, timeA.getPontos()); // 3 (vitória) + 1 (empate) + 0 (derrota)
        assertEquals(4, timeB.getPontos()); // 0 (derrota) + 1 (empate) + 3 (vitória)
    }

    @Test
    void deveOrdenarTabelaPorPontuacaoDecrescente() {
        Campeonato campeonato = new Campeonato();
        Time timeA = new Time("Time A", "Cidade A");
        Time timeB = new Time("Time B", "Cidade B");
        Time timeC = new Time("Time C", "Cidade C");
        campeonato.cadastrarTime(timeA);
        campeonato.cadastrarTime(timeB);
        campeonato.cadastrarTime(timeC);

        Partida partida1 = new Partida(timeA, timeB);
        partida1.registrarPlacar(2, 1); // Time A: 3 pontos, Time B: 0 pontos
        Partida partida2 = new Partida(timeB, timeC);
        partida2.registrarPlacar(0, 0); // Time B: 1 ponto, Time C: 1 ponto
        Partida partida3 = new Partida(timeA, timeC);
        partida3.registrarPlacar(3, 0); // Time A: 3 + 3 = 6 pontos, Time C: 1 + 0 = 1 ponto

        campeonato.registrarPartida(partida1.getTimeA(), partida1.getTimeB());
        campeonato.registrarPlacar(partida1, partida1.getGolsTimeA(), partida1.getGolsTimeB());
        campeonato.registrarPartida(partida2.getTimeA(), partida2.getTimeB());
        campeonato.registrarPlacar(partida2, partida2.getGolsTimeA(), partida2.getGolsTimeB());
        campeonato.registrarPartida(partida3.getTimeA(), partida3.getTimeB());
        campeonato.registrarPlacar(partida3, partida3.getGolsTimeA(), partida3.getGolsTimeB());

        List<Time> classificacao = campeonato.visualizarTabelaClassificacao();
        assertEquals(timeA, classificacao.get(0));
        assertEquals(timeB, classificacao.get(1));
        assertEquals(timeC, classificacao.get(2));
    }
}