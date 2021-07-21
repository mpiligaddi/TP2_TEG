package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IEstrategiaFase;
import edu.fiuba.algo3.modelo.Interfaces.IFase;
import edu.fiuba.algo3.modelo.excepciones.FaseIncompletaException;

public class EstrategiaAtaqueSinCompletar implements IEstrategiaFase {
    @Override
    public IEstrategiaFase actualizar() {
        return new EstrategiaAtaqueCompletado();
    }

    @Override
    public Boolean faseCompletada() {
        return false;
    }

    @Override
    public IFase siguienteFase(IFase actual) throws FaseIncompletaException {
        throw new FaseIncompletaException(null);
    }
}
