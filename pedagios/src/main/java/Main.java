package main.java;

import main.java.entidades.Pedagio;
import main.java.entidades.Veiculo;
import main.java.negocio.RelatorioPedagios;
import main.java.negocio.RegistroPassagem;

public class Main {
    public static void main(String[] args) {
        RegistroPassagem registro = new RegistroPassagem();
        RelatorioPedagios relatorio = new RelatorioPedagios();

        // Criar praças de pedágio
        Pedagio pedagioAnhanguera = new Pedagio("Anhanguera - Km 50", 10.00);
        Pedagio pedagioBandeirantes = new Pedagio("Bandeirantes - Km 30", 12.50);

        // Criar veículos
        Veiculo carro1 = new Veiculo("ABC-1234", "carro");
        Veiculo moto1 = new Veiculo("DEF-5678", "moto");
        Veiculo caminhao1 = new Veiculo("GHI-9012", "caminhao", 4);
        Veiculo carro2 = new Veiculo("JKL-3456", "carro");

        // Registrar passagens
        registro.registrarPassagem(carro1, pedagioAnhanguera);
        registro.registrarPassagem(moto1, pedagioAnhanguera);
        registro.registrarPassagem(caminhao1, pedagioAnhanguera);
        registro.registrarPassagem(carro2, pedagioBandeirantes);

        // Gerar relatório
        relatorio.gerarRelatorioArrecadacaoPorPraca(registro.getPassagensPorPedagio());
    }
}