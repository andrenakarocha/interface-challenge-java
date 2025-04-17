package main.java.negocio;

import main.java.entities.Time;

public class Partida {
    private Time timeA;
    private Time timeB;
    private int golsTimeA;
    private int golsTimeB;

    public Partida(Time timeA, Time timeB) {
        this.timeA = timeA;
        this.timeB = timeB;
        this.golsTimeA = 0;
        this.golsTimeB = 0;
    }

    public Time getTimeA() {
        return timeA;
    }

    public Time getTimeB() {
        return timeB;
    }

    public int getGolsTimeA() {
        return golsTimeA;
    }

    public int getGolsTimeB() {
        return golsTimeB;
    }

    public void registrarPlacar(int golsTimeA, int golsTimeB) {
        this.golsTimeA = golsTimeA;
        this.golsTimeB = golsTimeB;
        atualizarPontuacaoTimes();
    }

    private void atualizarPontuacaoTimes() {
        if (golsTimeA > golsTimeB) {
            timeA.atualizarPontuacao(3);
        } else if (golsTimeB > golsTimeA) {
            timeB.atualizarPontuacao(3);
        } else {
            timeA.atualizarPontuacao(1);
            timeB.atualizarPontuacao(1);
        }
    }

    @Override
    public String toString() {
        return timeA.getNome() + " " + golsTimeA + " x " + golsTimeB + " " + timeB.getNome();
    }
}
