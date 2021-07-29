package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.NoSePuedeProducirCanjeException;
import java.util.LinkedList;
import java.util.List;

public class Tarjetas {

    public static int cantidadNecesaria = 3;

    private LinkedList<Simbolo> simbolos;

    public Tarjetas(List<Tarjeta> tarjetas) {
        simbolos = new LinkedList<Simbolo>();
        for (Tarjeta tarjeta : tarjetas) {
            simbolos.add(tarjeta.obtenerSimbolo());
        }
    }

    public boolean sonValidas() {
        return (simbolos.size() == 3) & (sonIguales() | sonDistintos());
    }

    private Boolean sonIguales() {
        Simbolo primerSimbolo = simbolos.getFirst();
        return simbolos
                .stream()
                .allMatch
                        (simbolo -> simbolo.esIgualA(primerSimbolo));
    }

    public Boolean sonDistintos() {
        return true;
    }

}
