package edu.fiuba.algo3.modelo.vista;

import edu.fiuba.algo3.modelo.vista.eventos.BotonComenzarJuegoEventHandler;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.vista.eventos.BotonMoverEventHandler;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class ContenedorJuego extends BorderPane {

    BarraDeMenu menuBar;
    Stage stage;

    public ContenedorJuego(Stage stage) {
        this.stage = stage;
        this.setMenu(stage);
        this.setCentro();
        this.setConsola();
        this.setBotonera();
    }

    private void setBotonera() {
        Label texto = new Label();
        texto.setText("Ingrese cantidad de jugadores");

        TextField campo = new TextField();
        campo.setPromptText("Ingrese la cantidad de jugadores");

        Button boton = new Button();
        boton.setText("Empezar juego");

        VBox contenedor = new VBox(texto,campo,boton);

        BotonComenzarJuegoEventHandler botonEnviarEventHandler = new BotonComenzarJuegoEventHandler(campo,texto,this);
        boton.setOnAction(botonEnviarEventHandler);

        contenedor.setSpacing(10);
        contenedor.setPadding(new Insets(100));

        this.setRight(contenedor);
        this.setStyle("-fx-background-color: rgba(243,177,64,0.51);");
    }

    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }

    private void setCentro() {
        Image imagen = new Image("file:src/main/resources/vintageopciontres.jpeg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,BackgroundSize.DEFAULT);

        ImageView tablero = new ImageView("file:src/main/resources/tableroTEG.png");
        VBox contenedor = new VBox(tablero);
        contenedor.setBackground(new Background(imagenDeFondo));

        contenedor.setSpacing(10);
        contenedor.setPadding(new Insets(100));

        this.setCenter(contenedor);
    }

    private void setConsola() {
        Label etiqueta = new Label();
        etiqueta.setText("ALGOTEG - TODOS LOS DERECHOS RESERVADOS");
        etiqueta.setFont(Font.font("Courier new", FontWeight.SEMI_BOLD, 14));
        etiqueta.setTextFill(Color.BLACK);

        VBox contenedorConsola = new VBox(etiqueta);
        contenedorConsola.setSpacing(10);
        contenedorConsola.setPadding(new Insets(15));
        this.setBottom(contenedorConsola);
    }

    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }
}