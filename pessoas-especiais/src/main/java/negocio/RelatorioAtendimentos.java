package main.java.negocio;

import main.java.entidades.Atendimento;
import main.java.entidades.Pessoa;
import java.util.List;

public class RelatorioAtendimentos {

    public void gerarRelatorioPorPessoa(Pessoa pessoa) {
        System.out.println("Relatório de Atendimentos para: " + pessoa.getNome());
        if (pessoa.getAtendimentos().isEmpty()) {
            System.out.println("Nenhum atendimento registrado.");
        } else {
            pessoa.getAtendimentos().forEach(atendimento ->
                    System.out.println("- Data: " + atendimento.getData() +
                            ", Tipo: " + atendimento.getTipo() +
                            ", Profissional: " + atendimento.getProfissionalResponsavel())
            );
        }
        System.out.println("--------------------");
    }

    public void gerarRelatorioGeralDeAtendimentos(List<Pessoa> pessoas) {
        System.out.println("Relatório Geral de Atendimentos:");
        for (Pessoa pessoa : pessoas) {
            System.out.println("\nAtendimentos de: " + pessoa.getNome());
            if (!pessoa.getAtendimentos().isEmpty()) {
                pessoa.getAtendimentos().forEach(atendimento ->
                        System.out.println("- Data: " + atendimento.getData() +
                                ", Tipo: " + atendimento.getTipo() +
                                ", Profissional: " + atendimento.getProfissionalResponsavel())
                );
            } else {
                System.out.println("Nenhum atendimento registrado.");
            }
        }
        System.out.println("--------------------");
    }
}