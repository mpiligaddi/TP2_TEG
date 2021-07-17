package edu.fiuba.algo3.modelo;

import java.util.*;

public class Turno {

    int [] numeroDeTurnos = new int[6];
    //List<Integer> numeroDeTurnos = new ArrayList<Integer>();
    List<Jugador> jugadoresOrdenados = new ArrayList<Jugador>();
    List<Jugador> jugadoresNoOrdenados = new ArrayList<Jugador>();
    List<Integer> nuevaLista = new ArrayList<Integer>();

    public void determinarTurnos(List<Jugador> jugadores) {
        for(int i = 0 ; i < jugadores.size() ; i++) {
            numeroDeTurnos[i] = jugadores.get(i).numeroDeTurno();
            //numeroDeTurnos.add(jugadores.get(i).numeroDeTurno());
            jugadoresNoOrdenados.add(jugadores.get(i));
        }
        this.ordenarAscendentemente();
        this.ordenarJugadoresPorTurno(jugadores);
    }

    public void ordenarAscendentemente() {
       // Arrays.sort(new List[]{numeroDeTurnos}); //de menor a mayor: ascendente
        Arrays.sort(numeroDeTurnos);
    }

    public void ordenarJugadoresPorTurno(List<Jugador> jugadores) {
        for(int i = 0 ; i < jugadores.size() ; i++) {
            for(int j = 0 ; j < jugadores.size() ; j++) {
                if((jugadoresNoOrdenados.get(j)).numeroDeTurno() == numeroDeTurnos[i]) {
                //if((jugadoresNoOrdenados.get(j)).numeroDeTurno() == numeroDeTurnos.get(i)) {
                    jugadoresOrdenados.add(jugadoresNoOrdenados.get(j));
                }
            }
        }
    }

    public String ColorDejugadorEnOrden(int numeroDePosicionRequerida) {
        return (jugadoresOrdenados.get(numeroDePosicionRequerida)).color;
    }

}
