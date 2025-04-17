package main.java.entidades;

import java.time.LocalDate;

public class Atendimento {
    private LocalDate data;
    private String tipo;
    private String profissionalResponsavel;

    public Atendimento(LocalDate data, String tipo, String profissionalResponsavel) {
        this.data = data;
        this.tipo = tipo;
        this.profissionalResponsavel = profissionalResponsavel;
    }

    public LocalDate getData() {
        return data;
    }

    public String getTipo() {
        return tipo;
    }

    public String getProfissionalResponsavel() {
        return profissionalResponsavel;
    }

    @Override
    public String toString() {
        return "Atendimento{" +
                "data=" + data +
                ", tipo='" + tipo + '\'' +
                ", profissionalResponsavel='" + profissionalResponsavel + '\'' +
                '}';
    }
}