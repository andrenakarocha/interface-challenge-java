package main.java.negocio;

import main.java.entidades.Pedagio;
import main.java.entidades.Veiculo;
import main.java.interfaces.CalculavelPedagio;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistroPassagem implements CalculavelPedagio {
    private Map<Pedagio, List<Veiculo>> passagensPorPedagio;

    public RegistroPassagem() {
        this.passagensPorPedagio = new HashMap<>();
    }

    public void registrarPassagem(Veiculo veiculo, Pedagio pedagio) {
        if (!passagensPorPedagio.containsKey(pedagio)) {
            passagensPorPedagio.put(pedagio, new ArrayList<>());
        }
        passagensPorPedagio.get(pedagio).add(veiculo);
        double valorCobrado = calcularValorPedagio(veiculo, pedagio);
        pedagio.adicionarValorArrecadado(valorCobrado);
        System.out.println("Passagem registrada: " + veiculo + " em " + pedagio.getLocalizacao() + " - Valor: R$" + String.format("%.2f", valorCobrado));
    }

    public Map<Pedagio, List<Veiculo>> getPassagensPorPedagio() {
        return passagensPorPedagio;
    }

    @Override
    public double calcularValorPedagio(Veiculo veiculo, Pedagio pedagio) {
        double tarifaBase = pedagio.getTarifaBase();
        String tipoVeiculo = veiculo.getTipo().toLowerCase();

        switch (tipoVeiculo) {
            case "carro":
                return tarifaBase;
            case "moto":
                return tarifaBase * 0.5;
            case "caminhao":
                return tarifaBase * veiculo.getEixos();
            default:
                return 0.0; // Tipo de veículo não reconhecido
        }
    }
}