package edu.fiuba.algo3.modelo;

import java.util.*;
import java.util.stream.*;

import org.junit.Test;

import edu.fiuba.algo3.modelo.Interfaces.*;

import static org.junit.Assert.assertEquals;
public class MazoTest {

    List<IPais> paises = Arrays.asList(
            "Estados Unidos",
            "Canadá", 
            "Brasil", 
            "Bolivia",
            "Colombia",
            "Chile",
            "Ecuador")
        .stream()
        .map(n -> new Pais(n))
        .collect(Collectors.toList());
    @Test
    public void test01MazoDePaises() {
        Canje mazo = new Canje(paises);
        IPais eeuu = paises.stream()
            .filter(p -> p.obtenerNombre() == "Estados Unidos")
            .findAny()
            .get();
        assertEquals(eeuu, mazo.obtenerTarjeta().obtenerPais());
    }
}