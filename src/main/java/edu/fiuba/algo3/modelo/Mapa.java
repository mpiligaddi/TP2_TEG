package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Mapa implements IMapa {
    private List<IPais> paises;
    private List<Continente> continentes;

    public Mapa() {
        MapaFachada mapaFachada = new MapaFachada();
        paises = mapaFachada.obtenerPaises();
        continentes = mapaFachada.obtenerContinentes();
    }

    @Override
    public void definirPaises(List<IPais> paises) {
        this.paises = paises;

    }

    @Override
    public List<IPais> obtenerPaises() {
        return paises;
    }

    /*
    Asigna aleatoriamente paises de la lista recibida a los jugadores.
    No verifica que las listas estén vacías.
    Preserva el orden de la lista de jugadores, no de la de paises.
    */
    public void asignarPaises(List<IJugador> jugadores, IOrdenador ordenador) {
        ordenador.ordenar(paises);
        for (int i = 0; i < paises.size(); i++) {
            IPais actual = paises.get(i);
            jugadores.get(i % jugadores.size()).inicializarPais(actual);
        }
    }

    public List<Continente> continentesConquistados(Jugador jugador) {
        List<Continente> continentesConquistados = new ArrayList<Continente>();
        for (Continente continente : continentes) {
            if ( continente.fueConquistadoPor(jugador) ) { continentesConquistados.add(continente); }
        }
        return continentesConquistados;
    }

    @Override
    public List<String> obtenerNombresDeContinentes() {
        return continentes.stream()
            .map(c -> c.obtenerNombre())
            .collect(Collectors.toList());
    }

    @Override
    public Continente buscarContinente(String nombre) throws NoSuchElementException {
        return continentes.stream()
            .filter(c -> c.obtenerNombre().equals(nombre))
            .findAny().get();
    }

    public IPais obtenerPais(String pais) {
        return paises.stream()
                .filter(c -> c.obtenerNombre().equals(pais))
                .findAny().get();
    }
}
