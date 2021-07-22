package edu.fiuba.algo3.modelo.Interfaces;
import edu.fiuba.algo3.modelo.excepciones.FaseIncompletaException;

public interface IEstrategiaFase {
	public IEstrategiaFase actualizar();

	public Boolean faseCompletada();

	public IFase siguienteFase(IFase actual) throws FaseIncompletaException;
}