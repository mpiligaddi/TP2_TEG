package edu.fiuba.algo3.modelo;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public class Juego implements  PropertyChangeListener {
    //TODO reemplazar por estrategia
    private Boolean juegoTerminado = false;
    
    IFase faseActual;
    IFabricaDeFases fabrica = new FabricaDeFases();

    IMapa mapa;
    ITurno turno;
    Mazo mazo;
    ObjetivoManager objetivos;

    public Juego(final int cantidadDeJugadores) throws AlgoTegException {
        faseActual = fabrica.crearFaseInicio(cantidadDeJugadores);

        mapa = faseActual.obtenerFaseInicio().obtenerMapa();
        turno = faseActual.obtenerFaseInicio().obtenerTurno();
        mazo = faseActual.obtenerFaseInicio().obtenerCanje();
        objetivos = faseActual.obtenerFaseInicio().obtenerObjetivos();
        objetivos.agregarSuscriptorAVictoria(this);
    }

    public Juego(IFabricaDeFases fabrica, int cantidadDeJugadores) throws Exception {
        this.fabrica = fabrica;
        faseActual = fabrica.crearFaseInicio(cantidadDeJugadores);

        mapa = faseActual.obtenerFaseInicio().obtenerMapa();
        turno = faseActual.obtenerFaseInicio().obtenerTurno();
        mazo = faseActual.obtenerFaseInicio().obtenerCanje();
        objetivos = faseActual.obtenerFaseInicio().obtenerObjetivos();
        objetivos.agregarSuscriptorAVictoria(this);
    }

    // inicio

    
    public void ubicarEjercitosEnPais(final int cantEjercitos, final IPais pais)
            throws FichasInsuficientesException, PaisNoExistenteException, EjercitosException, FaseErroneaException {
        faseActual.obtenerFaseInicio().ubicarEjercitosEnPais(cantEjercitos, pais);
    }

    // reagrupar

    
    public void transferirEjercitos(int cantidad, IPais unPais, IPais otroPais)
            throws FaseErroneaException, TransferirEjercitosException, AdyacenciaException {
        faseActual.obtenerFaseReagrupar().transferirEjercitos(cantidad, unPais, otroPais);
    }

    // atacar

    
    public void atacar(final IPais atacante, final int cantidadDeSoldados, final IPais defensor) throws Exception {
        faseActual.obtenerFaseAtacar().atacar(atacante, cantidadDeSoldados, defensor);
        if (atacante.obtenerConquistador().esIgualA(defensor.obtenerConquistador())) { atacante.obtenerConquistador().agregarTarjetaAleatoria(mazo.obtenerTarjeta()); }
    }

    // colocar

    
    public void colocarEjercitosEnPais(final int cantEjercitos, final IPais pais)
            throws EjercitosException, FichasInsuficientesException, PaisNoExistenteException, FaseErroneaException {
        faseActual.obtenerFaseColocar().colocarEjercitosEnPais(cantEjercitos, pais);
    }

    // datos persistentes del juego

    public int cantidadDeJugadores()  {
        return turno.cantidadDeJugadores();
    }

    // avanzar fase
    public void siguienteFase() throws FaseIncompletaException, EjercitosException, TurnoException {
        faseActual = faseActual.siguienteFase(fabrica);
    }

    public IFase faseActual() {
        return faseActual;
    }

    
    public Mazo obtenerCanje() {
        return mazo;
    }

    
    public IMapa obtenerMapa() {
        return mapa;
    }

    public void activarTarjeta(Tarjeta tarjeta) throws NoExisteTarjetaException, NoSePuedeProducirCanjeException, PaisNoExistenteException {
        faseActual.activarTarjeta(tarjeta);
    }

    public void realizarCanje(List<Tarjeta> tarjetas) throws NoSePuedeProducirCanjeException, EjercitosException {
        faseActual.realizarCanje(tarjetas);
    }

    /*
        Obtiene los nombres de los colores de cada jugador existente en orden, 
        empezando por el jugador actual.
    */
    public List<String> obtenerNombresDeColores() {
        return turno.obtenerColores();
    }

    public IJugador jugadorActual() {
        return turno.jugadorActual();
    }

    public Boolean jugadorActualTieneEjercitos() {
        return (turno.jugadorActual().cantidadEjercitosPorColocar() != 0);
    }

    public void siguienteTurno() throws TurnoException, FaseIncompletaException {
        faseActual.siguienteTurno();

    }

    public int cantidadDePaises() {
        return mapa.obtenerPaises().size();
    }

    
    public void propertyChange(PropertyChangeEvent evento) {
        //TODO cambiar a estrategia 'juego completado'
        //y buscar el ganador
        this.juegoTerminado = true;
    }

	public List<String> obtenerObjetivos() {
		return objetivos.nombresDeObjetivos();
    }
    
    public Boolean juegoTerminado() {
		return this.juegoTerminado;
    }
    
    public IJugador obtenerGanador() throws AlgoTegException {
        if(!this.juegoTerminado()) 
            throw new AlgoTegException("No hay ganador aun");
        
        return turno.obtenerGanador();
	}
}