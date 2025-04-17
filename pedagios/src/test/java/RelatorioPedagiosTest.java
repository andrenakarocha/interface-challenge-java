package test.java;

import main.java.entidades.Pedagio;
import main.java.entidades.Veiculo;
import main.java.negocio.RelatorioPedagios;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class RelatorioPedagiosTest {

    @Test
    void deveGerarRelatorioDeArrecadacaoPorPraca() {
        RelatorioPedagios relatorio = new RelatorioPedagios();
        Map<Pedagio, List<Veiculo>> passagens = new HashMap<>();
        Pedagio pedagio1 = new Pedagio("Anhanguera", 10.00);
        Pedagio pedagio2 = new Pedagio("Bandeirantes", 12.50);
        Veiculo carro1 = new Veiculo("ABC-1234", "carro");
        Veiculo moto1 = new Veiculo("DEF-5678", "moto");

        pedagio1.adicionarValorArrecadado(10.00);
        List<Veiculo> lista1 = new ArrayList<>();
        lista1.add(carro1);
        passagens.put(pedagio1, lista1);

        pedagio2.adicionarValorArrecadado(6.25);
        List<Veiculo> lista2 = new ArrayList<>();
        lista2.add(moto1);
        passagens.put(pedagio2, lista2);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        relatorio.gerarRelatorioArrecadacaoPorPraca(passagens);

        String expectedOutput = "--- Relatório de Arrecadação por Praça de Pedágio ---\n" +
                "Praça: Anhanguera\n" +
                "  Tarifa Base: R$10.00\n" +
                "  Valor Arrecadado: R$10.00\n" +
                "  Número de Veículos: 1\n" +
                "  Veículos:\n" +
                "    - Veiculo{placa='ABC-1234', tipo='carro'}\n" +
                "--------------------------------------------------\n" +
                "Praça: Bandeirantes\n" +
                "  Tarifa Base: R$12.50\n" +
                "  Valor Arrecadado: R$6.25\n" +
                "  Número de Veículos: 1\n" +
                "  Veículos:\n" +
                "    - Veiculo{placa='DEF-5678', tipo='moto'}\n" +
                "--------------------------------------------------\n" +
                "-------------------- Fim do Relatório --------------------\n";

        assertEquals(expectedOutput, outContent.toString());

        System.setOut(System.out);
    }
}