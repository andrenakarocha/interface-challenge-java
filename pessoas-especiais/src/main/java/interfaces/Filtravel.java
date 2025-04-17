package main.java.interfaces;

import main.java.entidades.Pessoa;
import java.util.List;

public interface Filtravel {
    List<Pessoa> filtrar(List<Pessoa> pessoas);
}