package test.java;

import main.java.entidades.Pedagio;
import main.java.entidades.Veiculo;
import main.java.negocio.RegistroPassagem;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegistroPassagemTest {

    @Test
    void deveCalcularValorPedagioParaCarro() {
        RegistroPassagem registro = new RegistroPassagem();
        Veiculo carro = new Veiculo("ABC-1234", "carro");
        Pedagio pedagio = new Pedagio("Local", 10.00);
        assertEquals(10.00, registro.calcularValorPedagio(carro, pedagio));
    }

    @Test
    void deveCalcularValorPedagioParaMoto() {
        RegistroPassagem registro = new RegistroPassagem();
        Veiculo moto = new Veiculo("DEF-5678", "moto");
        Pedagio pedagio = new Pedagio("Local", 10.00);
        assertEquals(5.00, registro.calcularValorPedagio(moto, pedagio), 0.001);
    }

    @Test
    void deveCalcularValorPedagioParaCaminhao() {
        RegistroPassagem registro = new RegistroPassagem();
        Veiculo caminhao = new Veiculo("GHI-9012", "caminhao", 4);
        Pedagio pedagio = new Pedagio("Local", 10.00);
        assertEquals(40.00, registro.calcularValorPedagio(caminhao, pedagio));
    }

    @Test
    void deveRegistrarPassagemEAtualizarArrecadacao() {
        RegistroPassagem registro = new RegistroPassagem();
        Pedagio pedagio = new Pedagio("Local", 10.00);
        Veiculo carro = new Veiculo("ABC-1234", "carro");
        registro.registrarPassagem(carro, pedagio);
        assertEquals(10.00, pedagio.getValorArrecadado());
        assertEquals(1, registro.getPassagensPorPedagio().get(pedagio).size());
        assertTrue(registro.getPassagensPorPedagio().get(pedagio).contains(carro));
    }

    @Test
    void deveRegistrarMultiplasPassagensEmMesmoPedagio() {
        RegistroPassagem registro = new RegistroPassagem();
        Pedagio pedagio = new Pedagio("Local", 5.00);
        Veiculo carro1 = new Veiculo("ABC-1234", "carro");
        Veiculo moto1 = new Veiculo("DEF-5678", "moto");
        registro.registrarPassagem(carro1, pedagio);
        registro.registrarPassagem(moto1, pedagio);
        assertEquals(7.50, pedagio.getValorArrecadado(), 0.001);
        assertEquals(2, registro.getPassagensPorPedagio().get(pedagio).size());
        assertTrue(registro.getPassagensPorPedagio().get(pedagio).contains(carro1));
        assertTrue(registro.getPassagensPorPedagio().get(pedagio).contains(moto1));
    }
}