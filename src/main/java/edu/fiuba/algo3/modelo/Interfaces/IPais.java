package edu.fiuba.algo3.modelo.Interfaces;

import java.util.List;
import edu.fiuba.algo3.modelo.excepciones.AdyacenciaException;
import edu.fiuba.algo3.modelo.excepciones.TransferirEjercitosException;

public interface IPais {

	void agregarEjercitos(int i);

	IJugador obtenerConquistador();

	void atacar(IAtaque ataqueFalso);

	String obtenerNombre();

	void agregarAdyacente(IPais iPais);

	Boolean esAdyacenteA(IPais otroPais);

	void quitarEjercitos(long cantDerrotas);

	void conquistar(IPais defensor);

	int cantidadEjercitos();

	void atacar(IPais defensor, int cantidadDeSoldados) throws Exception;

	void definirConquistador(IJugador jugador2);
	
	public void transferirEjercitosA(int cantidad, IPais otroPais) throws TransferirEjercitosException, AdyacenciaException;

	public boolean sonMismoPais(IPais pais);

	List<IPais> obtenerAdyacentes();
}