package edu.fiuba.algo3.modelo;

import java.util.List;

import edu.fiuba.algo3.modelo.Interfaces.IEstrategiaFase;
import edu.fiuba.algo3.modelo.Interfaces.IFase;
import edu.fiuba.algo3.modelo.excepciones.FaseIncompletaException;

public class EstrategiaReagruparCompletado implements IEstrategiaFase {
    @Override
    public IEstrategiaFase actualizar() {
        return this;
    }

    @Override
    public Boolean faseCompletada() {
        return true;
    }

    @Override
    public IFase siguienteFase(Turno turno, List<Pais> paises) throws FaseIncompletaException {
        return new FaseColocar(turno, paises);
    }
}
