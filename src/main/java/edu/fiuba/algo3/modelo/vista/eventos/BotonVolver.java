package edu.fiuba.algo3.modelo.vista.eventos;

import edu.fiuba.algo3.modelo.vista.ContenedorJuego;
import edu.fiuba.algo3.modelo.vista.VisualizadorFaseInicio;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonVolver implements EventHandler<ActionEvent> {
    ContenedorJuego contenedorJuego;
    VisualizadorFaseInicio visualizadorFaseInicio;

    public BotonVolver(ContenedorJuego contenedorJuego,VisualizadorFaseInicio visualizadorFaseInicio) {
        this.contenedorJuego = contenedorJuego;
        this.visualizadorFaseInicio = visualizadorFaseInicio;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        VisualizadorFaseInicio faseInicio;
        faseInicio = this.visualizadorFaseInicio;
        faseInicio.visualizarNuevamente();
    }

}
