package main.java;

import main.java.entidades.Atendimento;
import main.java.entidades.Pessoa;
import main.java.negocio.CadastroPessoas;
import main.java.negocio.RelatorioAtendimentos;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        CadastroPessoas cadastro = new CadastroPessoas();
        RelatorioAtendimentos relatorio = new RelatorioAtendimentos();

        // Cadastrar pessoas
        Pessoa pessoa1 = new Pessoa("Ana Silva", 25, "Deficiência Motora", "Moderado", "Rua A, 123");
        Pessoa pessoa2 = new Pessoa("Pedro Souza", 18, "Deficiência Intelectual", "Leve", "Avenida B, 456");
        Pessoa pessoa3 = new Pessoa("Carla Oliveira", 32, "Deficiência Visual", "Severo", "Travessa C, 789");

        cadastro.cadastrarPessoa(pessoa1);
        cadastro.cadastrarPessoa(pessoa2);
        cadastro.cadastrarPessoa(pessoa3);

        // Cadastrar atendimentos
        cadastro.cadastrarAtendimento(pessoa1, new Atendimento(LocalDate.of(2025, 5, 1), "Fisioterapia", "Dr. João"));
        cadastro.cadastrarAtendimento(pessoa1, new Atendimento(LocalDate.of(2025, 5, 15), "Terapia Ocupacional", "Dra. Maria"));
        cadastro.cadastrarAtendimento(pessoa2, new Atendimento(LocalDate.of(2025, 5, 5), "Psicologia", "Dra. Paula"));

        // Listar todas as pessoas
        System.out.println("Lista de todas as pessoas:");
        cadastro.listarTodasAsPessoas().forEach(System.out::println);
        System.out.println("--------------------");

        // Listar pessoas por tipo de deficiência
        System.out.println("\nPessoas com Deficiência Motora:");
        cadastro.listarPessoasPorFiltro(new CadastroPessoas.FiltroPorTipoDeficiencia("Deficiência Motora"))
                .forEach(System.out::println);
        System.out.println("--------------------");

        // Listar pessoas por grau de deficiência
        System.out.println("\nPessoas com grau Leve de deficiência:");
        cadastro.listarPessoasPorFiltro(new CadastroPessoas.FiltroPorGrauDeficiencia("Leve"))
                .forEach(System.out::println);
        System.out.println("--------------------");

        // Gerar relatório de atendimentos por pessoa
        relatorio.gerarRelatorioPorPessoa(pessoa1);
        relatorio.gerarRelatorioPorPessoa(pessoa3);

        // Gerar relatório geral de atendimentos
        relatorio.gerarRelatorioGeralDeAtendimentos(cadastro.listarTodasAsPessoas());
    }
}