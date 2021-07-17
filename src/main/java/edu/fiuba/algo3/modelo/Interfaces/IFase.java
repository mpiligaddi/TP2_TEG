package edu.fiuba.algo3.modelo.Interfaces;
import edu.fiuba.algo3.modelo.excepciones.FaseIncompletaException;

public interface IFase {

	Boolean faseCompletada();

	IFase siguienteFase() throws FaseIncompletaException;

	Boolean finDeJuego();

	void realizar();

	Integer cantidadDeJugadores();

}
