package edu.fiuba.algo3.modelo.excepciones;

public class CantidadDeJugadoresError extends Exception {
    private static final long serialVersionUID = -8618114065857941861L;
    public CantidadDeJugadoresError(String msg) {
        super(msg);
    }
}