package edu.fiuba.algo3.modelo.fases;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public abstract class EstrategiaFaseSinCompletar extends EstrategiaFase {

    @Override
    public void siguienteJugador(ITurno turno) throws TurnoException, FaseIncompletaException {
        throw new FaseIncompletaException("No puede avanzr el turno hasta terminar.");
    }

    @Override
    public IFase siguienteFase(ITurno turno, IFabricaDeFases fabrica) throws FaseIncompletaException, EjercitosException, TurnoException {
        throw new FaseIncompletaException("La fase está incompleta.");
    }
    
    @Override
    public Boolean faseCompletada() {
        return false;
    }
}
