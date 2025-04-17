package main.java.negocio;

import main.java.entidades.Atendimento;
import main.java.entidades.Pessoa;
import main.java.interfaces.Filtravel;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CadastroPessoas {
    private List<Pessoa> pessoas;

    public CadastroPessoas() {
        this.pessoas = new ArrayList<>();
    }

    public void cadastrarPessoa(Pessoa pessoa) {
        this.pessoas.add(pessoa);
    }

    public void cadastrarAtendimento(Pessoa pessoa, Atendimento atendimento) {
        // Por simplicidade, vamos associar o atendimento diretamente à pessoa aqui.
        // Em um sistema mais complexo, você poderia ter uma relação separada.
        // Adicionamos o atendimento como um atributo na classe Pessoa (precisamos modificar Pessoa.java).
        // Vamos fazer isso agora.
        if (this.pessoas.contains(pessoa)) {
            pessoa.cadastrarAtendimento(atendimento);
        } else {
            System.out.println("Pessoa não encontrada.");
        }
    }

    public List<Pessoa> listarTodasAsPessoas() {
        return this.pessoas;
    }

    public List<Pessoa> listarPessoasPorFiltro(Filtravel filtro) {
        return filtro.filtrar(this.pessoas);
    }

    // Implementações de filtros específicos (podem ser classes separadas implementando Filtravel)
    public static class FiltroPorTipoDeficiencia implements Filtravel {
        private String tipo;

        public FiltroPorTipoDeficiencia(String tipo) {
            this.tipo = tipo;
        }

        @Override
        public List<Pessoa> filtrar(List<Pessoa> pessoas) {
            return pessoas.stream()
                    .filter(p -> p.getTipoDeficiencia().equalsIgnoreCase(this.tipo))
                    .collect(Collectors.toList());
        }
    }

    public static class FiltroPorGrauDeficiencia implements Filtravel {
        private String grau;

        public FiltroPorGrauDeficiencia(String grau) {
            this.grau = grau;
        }

        @Override
        public List<Pessoa> filtrar(List<Pessoa> pessoas) {
            return pessoas.stream()
                    .filter(p -> p.getGrauDeficiencia().equalsIgnoreCase(this.grau))
                    .collect(Collectors.toList());
        }
    }
}