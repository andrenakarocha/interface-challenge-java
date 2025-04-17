package main.java;

import main.java.entities.Time;
import main.java.entities.Jogadora;
import main.java.negocio.Campeonato;
import main.java.negocio.Partida;

public class Main {
    public static void main(String[] args) {
        Campeonato campeonato = new Campeonato();

        // Cadastrar times
        Time brasil = new Time("Brasil", "Rio de Janeiro");
        Time eua = new Time("Estados Unidos", "Los Angeles");
        campeonato.cadastrarTime(brasil);
        campeonato.cadastrarTime(eua);

        // Cadastrar jogadoras
        campeonato.cadastrarJogadora(brasil, "Marta", 35, "Atacante", 10);
        campeonato.cadastrarJogadora(brasil, "Cristiane", 36, "Atacante", 11);
        campeonato.cadastrarJogadora(eua, "Megan Rapinoe", 38, "Meio-campista", 15);
        campeonato.cadastrarJogadora(eua, "Alex Morgan", 34, "Atacante", 13);

        // Registrar partida
        Partida partida1 = new Partida(brasil, eua);
        campeonato.registrarPartida(brasil, eua);

        // Registrar placar
        campeonato.registrarPlacar(partida1, 2, 1);

        // Visualizar tabela de classificação
        System.out.println("Tabela de Classificação:");
        campeonato.visualizarTabelaClassificacao().forEach(System.out::println);

        System.out.println("\nPartidas Registradas:");
        campeonato.getPartidas().forEach(System.out::println);
    }
}