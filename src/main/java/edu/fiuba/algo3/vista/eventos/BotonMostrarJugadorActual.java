package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.excepciones.EjercitosException;
import edu.fiuba.algo3.modelo.excepciones.FaseIncompletaException;
import edu.fiuba.algo3.modelo.excepciones.TurnoException;
import edu.fiuba.algo3.vista.ContenedorJuego;
import edu.fiuba.algo3.vista.interfases.IVista;
import edu.fiuba.algo3.vista.interfases.IVistaFases;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;

public class BotonMostrarJugadorActual implements EventHandler<ActionEvent> {

    Juego juegoActual;
    VBox contenedor;
    ContenedorJuego contenedorJuego;
    IVistaFases visualizadorActual;

    public BotonMostrarJugadorActual(Juego juego, ContenedorJuego contenedorJuego, IVistaFases visualizadorActual) {
        this.juegoActual = juego;
        this.contenedor = contenedorJuego.obtenerBotonera();
        this.contenedorJuego = contenedorJuego;
        this.visualizadorActual = visualizadorActual;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        //fase atacar: se puede ir al sig jugador cuando se quiera
        //reagrupar idem atacar
        //me sirve para la fase de inicio y la de colocar, cuando el jugador tiene 0 ejercitos
        if(visualizadorActual.esFaseInicioOColocar()) {
            if (juegoActual.jugadorActualNoTieneEjercitos()) {
                if(juegoActual.faseActual().turno().esUltimoJugador()) {
                    visualizadorActual.visualizarNuevaFase();
                    try {
                        juegoActual.siguienteFase();
                    } catch (FaseIncompletaException e) {
                        e.printStackTrace();
                    } catch (EjercitosException e) {
                        e.printStackTrace();
                    } catch (TurnoException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    try {
                        this.juegoActual.siguienteTurno();
                    } catch (TurnoException | FaseIncompletaException e) {
                        System.exit(-1);
                    }
                    this.visualizadorActual.visualizar();
                }
            }
        }
        else {
            try {
                this.juegoActual.siguienteTurno();
            } catch (TurnoException | FaseIncompletaException e) {
                System.exit(-1);
            }
            this.visualizadorActual.visualizar();
        }
    }
}
