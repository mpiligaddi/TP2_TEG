package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Interfaces.IPais;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ContinenteTest {
    public List<IPais> paises = Arrays.asList(
            "Estados Unidos",
            "Canadá",
            "México",
            "Groenlandia")
            .stream()
            .map(pais -> new Pais(pais))
            .collect(Collectors.toList());

    @Test
    public void test00JugadorConqusitaContinente() {
        Jugador jugador = new Jugador("Azul");
        Continente continente = new Continente("America del Norte", paises);

        paises.forEach(pais -> pais.definirConquistador(jugador));

        assertTrue(continente.fueConquistadoPor(jugador));
    }

    @Test
    public void test01JugadorNoConquistaContinente() {
        Jugador jugadorRojo = new Jugador("Rojo");
        Jugador jugadorAzul = new Jugador("Azul");

        Continente continente = new Continente("America del Norte", paises);

        paises.forEach(pais -> pais.definirConquistador(jugadorRojo));

        assertFalse(continente.fueConquistadoPor(jugadorAzul));
    }

}
