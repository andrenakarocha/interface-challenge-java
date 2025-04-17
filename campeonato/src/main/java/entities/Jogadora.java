package main.java.entities;

public class Jogadora {
    private String nome;
    private int idade;
    private String posicao;
    private int numeroCamisa;

    public Jogadora(String nome, int idade, String posicao, int numeroCamisa) {
        this.nome = nome;
        this.idade = idade;
        this.posicao = posicao;
        this.numeroCamisa = numeroCamisa;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getPosicao() {
        return posicao;
    }

    public int getNumeroCamisa() {
        return numeroCamisa;
    }

    @Override
    public String toString() {
        return "Jogadora{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", posicao='" + posicao + '\'' +
                ", numeroCamisa=" + numeroCamisa +
                '}';
    }
}