package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class Pais implements IPais {
    String nombre;
    int ejercitos;
    IJugador conquistador;
    List<IPais> adyacentes;

	public Pais(String n) {
		this.nombre = n;
		this.ejercitos = 0;
		adyacentes = new ArrayList<IPais>();
	}

	public String obtenerNombre() {
		return nombre;
	}

	public int cantidadEjercitos() {
		return ejercitos;
	}

	public void agregarEjercitos(int cantidadEjercitos) {
        ejercitos += cantidadEjercitos;
	}

	public void quitarEjercitos(long cantidadEjercitos) {
		ejercitos -= cantidadEjercitos;
	}

	public void definirConquistador(IJugador conquistador) {
		conquistador.asignarPais(this);
		this.conquistador = conquistador;
	}

	public void conquistar(IPais defensor) {
		(new Conquista()).conquistar(this.conquistador, defensor);
	}

	public IJugador obtenerConquistador() { return this.conquistador; }

	public void atacar(IPais defensor, int numeroEjercitos) throws Exception {
		IAtaque ataque = new Ataque(this, defensor, numeroEjercitos);
		atacar(ataque);
	}

	public void atacar(IAtaque ataque) {
		ataque.atacar();
	}

	public void agregarAdyacente(IPais pais) { adyacentes.add(pais); }

	public List<IPais> obtenerAdyacentes() {
		return adyacentes;
	}
}