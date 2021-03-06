package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.eventos.BotonComenzarJuegoEventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
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
    VBox barraDeBotones;
    StackPane sobreTablero;
    ImageView archivoTablero;
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

        barraDeBotones = new VBox(texto,campo,boton);

        BotonComenzarJuegoEventHandler botonEnviarEventHandler 
            = new BotonComenzarJuegoEventHandler(campo,texto,this);
        boton.setOnAction(botonEnviarEventHandler);

        barraDeBotones.setSpacing(10);
        barraDeBotones.setPadding(new Insets(100));

        this.setRight(barraDeBotones);
        this.setStyle("-fx-background-color: rgba(243,177,64,0.51);");
    }

    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }

    private void setCentro() {
        Image imagen = new Image("file:src/main/resources/vintageopciontres.jpeg");
        BackgroundSize tamanio = new BackgroundSize(
            600, 380, false, false, false, true);
        BackgroundImage imagenDeFondo = new BackgroundImage(
            imagen, 
            BackgroundRepeat.REPEAT, 
            BackgroundRepeat.REPEAT, 
            BackgroundPosition.CENTER,
            tamanio);

        archivoTablero = new ImageView("file:src/main/resources/tableroTEG.png");
        archivoTablero.setFitWidth(600);
        archivoTablero.setPreserveRatio(true);

        sobreTablero = new StackPane(archivoTablero);
        VBox contenedor = new VBox(sobreTablero);
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

    public VBox obtenerBotonera() {
        return barraDeBotones;
    }

    public void definirBotonera(VBox contenedor) {
        contenedor.setSpacing(10);
        contenedor.setPadding(new Insets(100));
        this.barraDeBotones = contenedor;
        this.setRight(contenedor);
    }

    public void agregarABotonera(Node nodo) {
        if(!barraDeBotones.getChildrenUnmodifiable().contains(nodo))
            barraDeBotones.getChildren().add(nodo);
    }

    public void limpiarBotonera() {
        this.barraDeBotones.getChildren().clear();
    }

    public void definirSobreMapa(Node contenedor) {
        limpiarAreaMapa();
        this.sobreTablero.getChildren().add(contenedor);
    }

    public void limpiarAreaMapa() {
        this.sobreTablero.getChildren().clear();
        this.sobreTablero.getChildren().add(archivoTablero);
    }

}
