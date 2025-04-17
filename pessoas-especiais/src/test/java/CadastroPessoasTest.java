package test.java;

import main.java.entidades.Atendimento;
import main.java.entidades.Pessoa;
import main.java.negocio.CadastroPessoas;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CadastroPessoasTest {

    @Test
    void deveCadastrarPessoa() {
        CadastroPessoas cadastro = new CadastroPessoas();
        Pessoa pessoa = new Pessoa("Nome", 20, "Tipo", "Grau", "Endereco");
        cadastro.cadastrarPessoa(pessoa);
        assertEquals(1, cadastro.listarTodasAsPessoas().size());
        assertTrue(cadastro.listarTodasAsPessoas().contains(pessoa));
    }

    @Test
    void deveCadastrarAtendimentoParaPessoaExistente() {
        CadastroPessoas cadastro = new CadastroPessoas();
        Pessoa pessoa = new Pessoa("Nome", 20, "Tipo", "Grau", "Endereco");
        cadastro.cadastrarPessoa(pessoa);
        Atendimento atendimento = new Atendimento(LocalDate.now(), "TipoAtendimento", "Profissional");
        cadastro.cadastrarAtendimento(pessoa, atendimento);
        assertEquals(1, pessoa.getAtendimentos().size());
        assertTrue(pessoa.getAtendimentos().contains(atendimento));
    }

    @Test
    void naoDeveCadastrarAtendimentoParaPessoaInexistente() {
        CadastroPessoas cadastro = new CadastroPessoas();
        Pessoa pessoa = new Pessoa("Nome", 20, "Tipo", "Grau", "Endereco");
        Atendimento atendimento = new Atendimento(LocalDate.now(), "TipoAtendimento", "Profissional");
        cadastro.cadastrarAtendimento(pessoa, atendimento); // Pessoa não foi cadastrada
        assertEquals(0, pessoa.getAtendimentos().size());
    }

    @Test
    void deveFiltrarPessoasPorTipoDeficiencia() {
        CadastroPessoas cadastro = new CadastroPessoas();
        Pessoa pessoa1 = new Pessoa("Ana", 25, "Motora", "Moderado", "End 1");
        Pessoa pessoa2 = new Pessoa("Beto", 30, "Intelectual", "Leve", "End 2");
        Pessoa pessoa3 = new Pessoa("Carla", 35, "Motora", "Severo", "End 3");
        cadastro.cadastrarPessoa(pessoa1);
        cadastro.cadastrarPessoa(pessoa2);
        cadastro.cadastrarPessoa(pessoa3);

        List<Pessoa> filtrados = cadastro.listarPessoasPorFiltro(new CadastroPessoas.FiltroPorTipoDeficiencia("Motora"));
        assertEquals(2, filtrados.size());
        assertTrue(filtrados.contains(pessoa1));
        assertTrue(filtrados.contains(pessoa3));
        assertFalse(filtrados.contains(pessoa2));
    }

    @Test
    void deveFiltrarPessoasPorGrauDeficiencia() {
        CadastroPessoas cadastro = new CadastroPessoas();
        Pessoa pessoa1 = new Pessoa("Ana", 25, "Motora", "Moderado", "End 1");
        Pessoa pessoa2 = new Pessoa("Beto", 30, "Intelectual", "Leve", "End 2");
        Pessoa pessoa3 = new Pessoa("Carla", 35, "Motora", "Severo", "End 3");
        cadastro.cadastrarPessoa(pessoa1);
        cadastro.cadastrarPessoa(pessoa2);
        cadastro.cadastrarPessoa(pessoa3);

        List<Pessoa> filtrados = cadastro.listarPessoasPorFiltro(new CadastroPessoas.FiltroPorGrauDeficiencia("Leve"));
        assertEquals(1, filtrados.size());
        assertTrue(filtrados.contains(pessoa2));
        assertFalse(filtrados.contains(pessoa1));
        assertFalse(filtrados.contains(pessoa3));
    }
}