package main.java.negocio;

import main.java.entities.Jogadora;
import main.java.entities.Time;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Campeonato {
    private List<Time> times;
    private List<Partida> partidas;

    public Campeonato() {
        this.times = new ArrayList<>();
        this.partidas = new ArrayList<>();
    }

    public void cadastrarTime(Time time) {
        this.times.add(time);
    }

    public void cadastrarJogadora(Time time, String nome, int idade, String posicao, int numeroCamisa) {
        if (times.contains(time)) {
            time.adicionarJogadora(new Jogadora(nome, idade, posicao, numeroCamisa));
        } else {
            System.out.println("Time não encontrado no campeonato.");
        }
    }

    public void registrarPartida(Time timeA, Time timeB) {
        if (times.contains(timeA) && times.contains(timeB)) {
            this.partidas.add(new Partida(timeA, timeB));
        } else {
            System.out.println("Um ou ambos os times não estão cadastrados no campeonato.");
        }
    }

    public void registrarPlacar(Partida partida, int golsTimeA, int golsTimeB) {
        if (partidas.contains(partida)) {
            partida.registrarPlacar(golsTimeA, golsTimeB);
        } else {
            System.out.println("Partida não encontrada.");
        }
    }

    public List<Time> visualizarTabelaClassificacao() {
        return times.stream()
                .sorted(Comparator.comparingInt(Time::getPontos).reversed())
                .collect(Collectors.toList());
    }

    public List<Time> getTimes() {
        return times;
    }

    public List<Partida> getPartidas() {
        return partidas;
    }
}