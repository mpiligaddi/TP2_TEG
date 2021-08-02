package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Interfaces.IJugador;
import edu.fiuba.algo3.modelo.Interfaces.IPais;
import edu.fiuba.algo3.vista.interfases.IVista;
import javafx.scene.control.Button;

public class VistaMoverEjercitos implements IVista {
    private Juego juego;
    private ContenedorJuego contenedorJuego;

    public VistaMoverEjercitos(Juego juego, ContenedorJuego contenedorJuego) {
        this.juego = juego;
        this.contenedorJuego = contenedorJuego;
    }

	public void visualizar() {
        
	}

    @Override
    public void visualizar(ContenedorJuego contenedor) {
        IJugador jugadorActual = juego.jugadorActual();
		for(IPais pais : jugadorActual.obtenerPaises()){
            Button paisJugador = new Button(pais.obtenerNombre());
            
            EventoMostrarAdyacentes eventoAdyacentes 
                = new EventoMostrarAdyacentes(juego, contenedorJuego, pais);

            paisJugador.setOnAction(eventoAdyacentes);
            contenedor.getChildren().add(paisJugador);
        }

    }
    
}
