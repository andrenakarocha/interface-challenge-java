package main.java.entidades;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private String nome;
    private int idade;
    private String tipoDeficiencia;
    private String grauDeficiencia;
    private String endereco;
    private List<Atendimento> atendimentos;

    public Pessoa(String nome, int idade, String tipoDeficiencia, String grauDeficiencia, String endereco) {
        this.nome = nome;
        this.idade = idade;
        this.tipoDeficiencia = tipoDeficiencia;
        this.grauDeficiencia = grauDeficiencia;
        this.endereco = endereco;
        this.atendimentos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getTipoDeficiencia() {
        return tipoDeficiencia;
    }

    public String getGrauDeficiencia() {
        return grauDeficiencia;
    }

    public String getEndereco() {
        return endereco;
    }

    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void cadastrarAtendimento(Atendimento atendimento) {
        this.atendimentos.add(atendimento);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", tipoDeficiencia='" + tipoDeficiencia + '\'' +
                ", grauDeficiencia='" + grauDeficiencia + '\'' +
                ", endereco='" + endereco + '\'' +
                ", número de atendimentos=" + atendimentos.size() +
                '}';
    }
}