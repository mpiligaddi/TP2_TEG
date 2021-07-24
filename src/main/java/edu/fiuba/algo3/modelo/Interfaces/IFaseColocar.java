package edu.fiuba.algo3.modelo.Interfaces;

import edu.fiuba.algo3.modelo.excepciones.*;

//extraer interfaz para tests
public interface IFaseColocar {
    public void asignarNuevosEjercitosAJugadores() throws EjercitosException, FaseErroneaException;
    public void colocarEjercitosEnPais(int cantEjercitos, IPais pais) throws EjercitosException, FichasInsuficientesError, PaisNoExistenteError, FaseErroneaException;
}