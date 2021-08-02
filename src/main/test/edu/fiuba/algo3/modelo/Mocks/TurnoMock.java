package edu.fiuba.algo3.modelo.Mocks;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Interfaces.*;

public class TurnoMock implements ITurno {
    List<Jugador> jugadores = Arrays.asList(
        new Jugador("Rojo"), 
        new Jugador("Verde"), 
        new Jugador("Amarillo"));


    @Override
    public Jugador jugadorActual() {
        return jugadores.get(0);
    }

    @Override
    public void siguienteJugador() {
    }

    @Override
    public int cantidadDeJugadores() {
        return 1;
    }

    @Override
    public boolean esUltimoJugador() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<String> obtenerColores() {
        return jugadores.stream()
                .map(j -> j.obtenerColor())
                .collect(Collectors.toList());
    }
    
    public IJugador jugadorDeColor(String color) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int buscarIndiceDeJugador(IJugador jugador){
        return 0;
    }

}