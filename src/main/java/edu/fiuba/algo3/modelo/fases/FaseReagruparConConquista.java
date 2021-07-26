package edu.fiuba.algo3.modelo.fases;

import java.beans.PropertyChangeEvent;
import java.util.List;

import edu.fiuba.algo3.modelo.Canje;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.ObjetivoManager;

public class FaseReagruparConConquista extends FaseReagrupar {

    public FaseReagruparConConquista(ITurno turno, IMapa paises, Canje canje) {
        super(turno, paises, canje);
        turno
            .jugadorActual()
            .agregarTarjetaAleatoria(
                canje.obtenerTarjeta()
            );
    }

    @Override
    public ObjetivoManager obtenerObjetivo() {
        return null;
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        finDeJuego = (Boolean) event.getNewValue();
    }
}
