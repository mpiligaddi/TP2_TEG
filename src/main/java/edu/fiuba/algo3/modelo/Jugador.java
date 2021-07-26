package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.*;
import edu.fiuba.algo3.modelo.excepciones.*;

import java.util.List;
import java.util.ArrayList;

public class Jugador implements IJugador {

	private String color;
	private List<IPais> paises;
	private List<Tarjeta> tarjetas;
	private int ejercitosPorColocar;
	public Mazo mazo;
	int numeroDeCanje = 0;

	static int minimoPaises = 30;

	public Jugador(String colorDelJugador) {
		color = colorDelJugador;
		paises = new ArrayList<IPais>();
		tarjetas = new ArrayList<Tarjeta>();
		ejercitosPorColocar = 0;
	}

	public String obtenerColor() {
		return color;
	}

	public List<IPais> obtenerPaises() {
		return this.paises;
	}

	public int cantidadEjercitos() {
		return ejercitosPorColocar;
	}

	@Override
	public void inicializarEjercitos(int cantidad) throws EjercitosException {
		if(cantidad <= 0)
			throw new EjercitosException(null);
		ejercitosPorColocar += cantidad;
	}

	@Override
	public void agregarNuevosEjercitos(int cantidad) throws EjercitosException {
		this.ejercitosPorColocar = 0;
		if(cantidad <= 0) throw new EjercitosException("cantidadInvalida");
		// Si el jugador controla menos de seis países de todas maneras incorpora tres ejércitos.
		if(this.paises.size() < 6) {
			this.ejercitosPorColocar += 3;
		}
		else {
			this.ejercitosPorColocar += cantidad;
		}
	}

	//agrega un pais con un ejército nuevo. 
	//No afecta la cantidad de ejércitos por colocar del jugador.
	public void inicializarPais(IPais pais) {
		asignarPais(pais);
		pais.agregarEjercitos(1);
	}

	public void asignarPais(IPais pais) {
		paises.add(pais);
	}

	public void quitarPais(IPais pais) {
		paises.remove(pais);
	}

	public void agregarEjercitosAPais(IPais pais, int cantEjercitos) throws FichasInsuficientesError,
			PaisNoExistenteError, EjercitosException {
		verificarPais(pais);
		verificarCantidadDeEjercitos(cantEjercitos);
		pais.agregarEjercitos(cantEjercitos);
		quitarEjercitos(cantEjercitos);
	}

	private void verificarPais(IPais pais) throws PaisNoExistenteError {
		for(int i = 0 ; i < paises.size() ; i++) {
			if( paises.get(i).obtenerNombre().equals(pais.obtenerNombre())) {
				return;
			}
		}
		throw new PaisNoExistenteError("El jugador no es conquistador del pais " + pais.obtenerNombre());
	}

	private void verificarCantidadDeEjercitos(int cantEjercitos) throws FichasInsuficientesError{
		if(cantEjercitos > this.cantidadEjercitos()) {
			throw new FichasInsuficientesError("No tienes esa cantidad de fichas para colocar en el pais");
		}
	}

	//Sistema de canjes

	public void asignarCanje(Mazo mazoNuevo) {
		mazo = mazoNuevo;
	}

	public void agregarTarjetaAleatoria(Tarjeta tarjeta) {
		tarjetas.add(tarjeta);
	}

	public void activarTarjeta(Tarjeta tarjeta, ICanje tipoDeCanje) throws NoExisteTarjetaException, PaisNoExistenteError, NoSePuedeProducirCanjeException {
		this.realizarVerificaciones(tarjeta);
		tarjeta.activarTarjeta(this, tipoDeCanje);
		this.mazo.insertarAlFondoDelMazo(tarjeta);
		this.tarjetas.remove(tarjeta);
		this.actualizarNumeroDeCanje();
	}

	public void actualizarNumeroDeCanje() {
		numeroDeCanje++;
	}

	// verificaciones para los canjes

	public void realizarVerificaciones(Tarjeta tarjeta) throws NoExisteTarjetaException, PaisNoExistenteError {
		this.verificarQueExistaTarjeta(tarjeta);
		this.verificarQueExistaPais(tarjeta.obtenerPais());
	}

	public boolean verificarQueExistaTarjeta(Tarjeta tarjeta) throws NoExisteTarjetaException {
		for(int i = 0 ; i < tarjetas.size() ; i++) {
			if(tarjetas.get(i).obtenerPais() == tarjeta.obtenerPais()) {
				return true;
			}
		}
		throw new NoExisteTarjetaException("No tienes la tarjeta que buscas activar");
	}

	public boolean verificarQueExistaPais(IPais pais) throws PaisNoExistenteError {
		for(int i = 0 ; i < this.cantidadPaises() ; i++) {
			if(this.obtenerPaises().get(i).obtenerNombre().equals(pais.obtenerNombre())) {
				return true;
			}
		}
		throw new PaisNoExistenteError("No tienes este pais para agregar fichas");
	}

	@Override
	public int cantidadTarjetas() {
		return tarjetas.size();
	}

	@Override
	public void quitarEjercitos(int cantidadAQuitar) throws EjercitosException {
		ejercitosPorColocar -= cantidadAQuitar;
		if(ejercitosPorColocar < 0) throw new EjercitosException("quita demasiados ejercitos");
	}

	@Override
	public int cantidadPaises() {
		return paises.size();
	}

}
