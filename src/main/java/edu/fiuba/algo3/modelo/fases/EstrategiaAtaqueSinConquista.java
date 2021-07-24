package edu.fiuba.algo3.modelo.fases;

import java.util.List;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public class EstrategiaAtaqueSinConquista implements IEstrategiaFase {
    @Override
    public IEstrategiaFase actualizar() {
        return new EstrategiaAtaqueConConquista();
    }

    @Override
    public Boolean faseCompletada() {
        return true;
    }

    @Override
    public IFase siguienteFase(ITurno turno, IMapa mapa, Canje canje) throws FaseIncompletaException {
        return new FaseReagruparSinConquista(turno, mapa, canje);
    }
}
