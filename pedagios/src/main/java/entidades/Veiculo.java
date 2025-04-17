package main.java.entidades;

public class Veiculo {
    private String placa;
    private String tipo; // "carro", "moto", "caminhao"
    private int eixos;

    public Veiculo(String placa, String tipo) {
        this.placa = placa;
        this.tipo = tipo;
        this.eixos = 0; // Padrão para carro e moto
    }

    public Veiculo(String placa, String tipo, int eixos) {
        this.placa = placa;
        this.tipo = tipo;
        this.eixos = eixos; // Para caminhão
    }

    public String getPlaca() {
        return placa;
    }

    public String getTipo() {
        return tipo;
    }

    public int getEixos() {
        return eixos;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "placa='" + placa + '\'' +
                ", tipo='" + tipo + '\'' +
                (tipo.equalsIgnoreCase("caminhao") ? ", eixos=" + eixos : "") +
                '}';
    }
}