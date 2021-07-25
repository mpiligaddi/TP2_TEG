package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;

import java.util.Collections;
import java.util.List;

public class Mapa implements IMapa {
    private List<IPais> paises;

    public Mapa() {
        MapaFachada mapaFachada = new MapaFachada();
        paises = mapaFachada.obtenerPaises();
    }

    @Override
    public void definirPaises(List<IPais> paises) {
        this.paises = paises;

    }

    @Override
    public List<IPais> obtenerPaises() {
        return paises;
    }

    public void asignarPaises(List<IJugador> jugadores) {
        Collections.shuffle(paises);
        for (int i = 0; i < paises.size(); i++) {
            IPais actual = paises.get(i);
            jugadores.get(i % jugadores.size()).inicializarPais(actual);
        }
    }

}
