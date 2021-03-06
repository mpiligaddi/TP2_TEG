package edu.fiuba.algo3.modelo.Mocks;

import edu.fiuba.algo3.modelo.Continente;
import edu.fiuba.algo3.modelo.Interfaces.*;

import java.util.List;

public class MapaMock implements IMapa {
    private List<IPais> paises;

    public MapaMock(List<IPais> paises) {
        definirPaises(paises);
    }

    @Override
    public List<IPais> obtenerPaises() {
        return paises;
    }

    @Override
    public void definirPaises(List<IPais> paises) {
        this.paises = paises;
    }

    @Override
    public List<String> obtenerNombresDeContinentes() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Continente buscarContinente(String nombre) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IPais obtenerPais(String pais) {
        return null;
    }
}

