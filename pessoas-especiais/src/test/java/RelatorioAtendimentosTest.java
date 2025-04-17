package test.java;

import main.java.entidades.Atendimento;
import main.java.entidades.Pessoa;
import main.java.negocio.RelatorioAtendimentos;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class RelatorioAtendimentosTest {

    @Test
    void deveGerarRelatorioPorPessoaComAtendimentos() {
        RelatorioAtendimentos relatorio = new RelatorioAtendimentos();
        Pessoa pessoa = new Pessoa("Nome", 20, "Tipo", "Grau", "Endereco");
        pessoa.cadastrarAtendimento(new Atendimento(LocalDate.of(2025, 5, 1), "Fisio", "Prof 1"));
        pessoa.cadastrarAtendimento(new Atendimento(LocalDate.of(2025, 5, 15), "T.O.", "Prof 2"));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        relatorio.gerarRelatorioPorPessoa(pessoa);

        String expectedOutput = "Relatório de Atendimentos para: Nome\n" +
                "- Data: 2025-05-01, Tipo: Fisio, Profissional: Prof 1\n" +
                "- Data: 2025-05-15, Tipo: T.O., Profissional: Prof 2\n" +
                "--------------------\n";

        assertEquals(expectedOutput, outContent.toString());

        // Restaurar o System.out original
        System.setOut(System.out);
    }

    @Test
    void deveGerarRelatorioPorPessoaSemAtendimentos() {
        RelatorioAtendimentos relatorio = new RelatorioAtendimentos();
        Pessoa pessoa = new Pessoa("Nome", 20, "Tipo", "Grau", "Endereco");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        relatorio.gerarRelatorioPorPessoa(pessoa);

        String expectedOutput = "Relatório de Atendimentos para: Nome\n" +
                "Nenhum atendimento registrado.\n" +
                "--------------------\n";

        assertEquals(expectedOutput, outContent.toString());

        // Restaurar o System.out original
        System.setOut(System.out);
    }

    @Test
    void deveGerarRelatorioGeralDeAtendimentos() {
        RelatorioAtendimentos relatorio = new RelatorioAtendimentos();
        List<Pessoa> pessoas = new ArrayList<>();
        Pessoa pessoa1 = new Pessoa("Pessoa 1", 20, "Tipo 1", "Grau 1", "End 1");
        pessoa1.cadastrarAtendimento(new Atendimento(LocalDate.of(2025, 6, 1), "Tipo A", "Prof A"));
        Pessoa pessoa2 = new Pessoa("Pessoa 2", 30, "Tipo 2", "Grau 2", "End 2");

        pessoas.add(pessoa1);
        pessoas.add(pessoa2);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        relatorio.gerarRelatorioGeralDeAtendimentos(pessoas);

        String expectedOutput = "Relatório Geral de Atendimentos:\n" +
                "\nAtendimentos de: Pessoa 1\n" +
                "- Data: 2025-06-01, Tipo: Tipo A, Profissional: Prof A\n" +
                "\nAtendimentos de: Pessoa 2\n" +
                "Nenhum atendimento registrado.\n" +
                "--------------------\n";

        assertEquals(expectedOutput, outContent.toString());

        // Restaurar o System.out original
        System.setOut(System.out);
    }
}