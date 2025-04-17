package main.java.entidades;

public class Pedagio {
    private String localizacao;
    private double tarifaBase;
    private double valorArrecadado;

    public Pedagio(String localizacao, double tarifaBase) {
        this.localizacao = localizacao;
        this.tarifaBase = tarifaBase;
        this.valorArrecadado = 0.0;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }

    public double getValorArrecadado() {
        return valorArrecadado;
    }

    public void adicionarValorArrecadado(double valor) {
        this.valorArrecadado += valor;
    }

    @Override
    public String toString() {
        return "Pedagio{" +
                "localizacao='" + localizacao + '\'' +
                ", tarifaBase=" + String.format("%.2f", tarifaBase) +
                ", valorArrecadado=" + String.format("%.2f", valorArrecadado) +
                '}';
    }
}