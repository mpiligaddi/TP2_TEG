package edu.fiuba.algo3;

import java.io.IOException;

import edu.fiuba.algo3.vista.ContenedorBienvenidos;
import edu.fiuba.algo3.vista.ContenedorJuego;
import edu.fiuba.algo3.vista.eventos.BotonParaActivarOpcionDePantallaCompletaEventHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("ALGOTEG");

        double volumen = 0.2;
        MediaPlayer musica = agregarMusica(volumen);

        ContenedorJuego contenedorJuego = new ContenedorJuego(stage);
        Scene escenaJuego = new Scene(contenedorJuego, 640, 480);

        BotonParaActivarOpcionDePantallaCompletaEventHandler BotonParaActivarOpcionDePantallaCompletaEventHandler = new BotonParaActivarOpcionDePantallaCompletaEventHandler(stage, contenedorJuego.getBarraDeMenu());
        escenaJuego.setOnKeyPressed(BotonParaActivarOpcionDePantallaCompletaEventHandler);

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, escenaJuego);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos,640,480);

        stage.setScene(escenaBienvenidos);
        stage.setFullScreen(true);

        stage.show();
    }

   private MediaPlayer agregarMusica(double volumen) {
        Media mp3MusicFile = new Media(new File("src/main/resources/super-mario-bros-main-theme.mp3").toURI().toString());
        MediaPlayer musica;
        try{
            musica = new MediaPlayer(mp3MusicFile);
        }catch(Exception e) { return null; }
        musica.setAutoPlay(true);
        musica.setOnEndOfMedia(() -> musica.seek(Duration.ZERO));
        musica.setVolume(volumen);
        musica.play();
        return musica;

   }
}