package main.java.interfaces;

import main.java.entidades.Pedagio;
import main.java.entidades.Veiculo;

public interface CalculavelPedagio {
    double calcularValorPedagio(Veiculo veiculo, Pedagio pedagio);
}