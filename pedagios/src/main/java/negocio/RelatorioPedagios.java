package main.java.negocio;

import main.java.entidades.Pedagio;
import main.java.entidades.Veiculo;
import java.util.List;
import java.util.Map;

public class RelatorioPedagios {

    public void gerarRelatorioArrecadacaoPorPraca(Map<Pedagio, List<Veiculo>> passagensPorPedagio) {
        System.out.println("--- Relatório de Arrecadação por Praça de Pedágio ---");
        for (Map.Entry<Pedagio, List<Veiculo>> entry : passagensPorPedagio.entrySet()) {
            Pedagio pedagio = entry.getKey();
            List<Veiculo> veiculos = entry.getValue();
            System.out.println("Praça: " + pedagio.getLocalizacao());
            System.out.println("  Tarifa Base: R$" + String.format("%.2f", pedagio.getTarifaBase()));
            System.out.println("  Valor Arrecadado: R$" + String.format("%.2f", pedagio.getValorArrecadado()));
            System.out.println("  Número de Veículos: " + veiculos.size());
            System.out.println("  Veículos:");
            for (Veiculo veiculo : veiculos) {
                System.out.println("    - " + veiculo);
            }
            System.out.println("--------------------------------------------------");
        }
        System.out.println("-------------------- Fim do Relatório --------------------");
    }
}