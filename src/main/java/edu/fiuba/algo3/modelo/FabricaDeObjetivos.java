package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.ObjetivoException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FabricaDeObjetivos {

    List<IObjetivo> objetivos = new ArrayList<>();
    IMapa mapa;

    List<IPais> paisesEnAmerica = Arrays.asList(new Pais("Nueva York"), new Pais("Oregon"), new Pais("Mexico"));
    List<IPais> paisesEnEuropa = Arrays.asList(new Pais("Rusia"), new Pais("Francia"));
    List<IPais> paisesEnAsia = Arrays.asList(new Pais("China"), new Pais("India"));

    List<Continente> continentesUno = Arrays.asList(new Continente("America", paisesEnEuropa));
    List<Continente> continentesDos = Arrays.asList(new Continente("Europa", paisesEnAmerica));
    List<Continente> continentesTres = Arrays.asList(new Continente("Asia", paisesEnAsia));

    ITurno turno;

    public FabricaDeObjetivos(ITurno turno, IMapa mapa) {
        this.turno = turno;
        this.mapa = mapa;
    }

    public void agregarObjetivo(IObjetivo objetivo) {
        objetivos.add(objetivo);
    }

    //TODO: crear objetivos de manera más general
    public List<IObjetivo> crearObjetivos() {
        agregarObjetivo(new ObjetivoConquistarPaisesYContinentes(continentesUno, paisesEnAmerica));
        agregarObjetivoDeEjercitos("Azul");
        agregarObjetivo(new ObjetivoConquistarPaisesYContinentes(continentesDos,paisesEnEuropa));
        agregarObjetivoDeEjercitos("Rojo");
        agregarObjetivo(new ObjetivoConquistarPaisesYContinentes(continentesTres,paisesEnAsia));
        agregarObjetivoDeEjercitos("Verde");
        return objetivos;
    }

    private void agregarObjetivoDeEjercitos(String color){
        try {
            agregarObjetivo(new ObjetivoDestruirEjercito(turno, color));
        } catch (ObjetivoException e) {
            agregarObjetivo(new ObjetivoGeneral());
        }
    }
}
