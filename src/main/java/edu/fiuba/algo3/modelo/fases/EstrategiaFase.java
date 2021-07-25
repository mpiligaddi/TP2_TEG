package edu.fiuba.algo3.modelo.fases;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public abstract class EstrategiaFase implements IEstrategiaFase {
    @Override
    public IEstrategiaFase actualizar() {
        return this;
    }

    @Override
    public Boolean faseCompletada() {
        return true;
    }

    //comportamiento default asume un turno completado
    @Override
    public void siguienteJugador(ITurno turno) {
        turno.siguienteJugador();
    }

    @Override
    public IFase siguienteFase(FabricaDeFases fabrica) throws FaseIncompletaException, EjercitosException {
        throw new FaseIncompletaException("No se puede seguir aun a la siguiente fase.");
    }
}