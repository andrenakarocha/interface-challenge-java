package test.java;

import main.java.entities.Time;
import main.java.negocio.Partida;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PartidaTest {

    @Test
    void deveAtualizarPontuacaoComVitoriaTimeA() {
        Time timeA = new Time("Time A", "Cidade A");
        Time timeB = new Time("Time B", "Cidade B");
        Partida partida = new Partida(timeA, timeB);
        partida.registrarPlacar(2, 1);
        assertEquals(3, timeA.getPontos());
        assertEquals(0, timeB.getPontos());
    }

    @Test
    void deveAtualizarPontuacaoComVitoriaTimeB() {
        Time timeA = new Time("Time A", "Cidade A");
        Time timeB = new Time("Time B", "Cidade B");
        Partida partida = new Partida(timeA, timeB);
        partida.registrarPlacar(0, 3);
        assertEquals(0, timeA.getPontos());
        assertEquals(3, timeB.getPontos());
    }

    @Test
    void deveAtualizarPontuacaoComEmpate() {
        Time timeA = new Time("Time A", "Cidade A");
        Time timeB = new Time("Time B", "Cidade B");
        Partida partida = new Partida(timeA, timeB);
        partida.registrarPlacar(1, 1);
        assertEquals(1, timeA.getPontos());
        assertEquals(1, timeB.getPontos());
    }
}