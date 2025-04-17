package main.java.entities;

import java.util.ArrayList;
import java.util.List;

public class Time {
    private String nome;
    private String cidade;
    private List<Jogadora> jogadoras;
    private int pontos;

    public Time(String nome, String cidade) {
        this.nome = nome;
        this.cidade = cidade;
        this.jogadoras = new ArrayList<>();
        this.pontos = 0;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public List<Jogadora> getJogadoras() {
        return jogadoras;
    }

    public int getPontos() {
        return pontos;
    }

    public void adicionarJogadora(Jogadora jogadora) {
        this.jogadoras.add(jogadora);
    }

    public void atualizarPontuacao(int pontos) {
        this.pontos += pontos;
    }

    @Override
    public String toString() {
        return "Time{" +
                "nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", pontos=" + pontos +
                ", número de jogadoras=" + jogadoras.size() +
                '}';
    }
}