package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unju.fi.model.Carrera;

public class ListadoCarreras {

    public static List<Carrera> carreras = new ArrayList<>();

    public static List<Carrera> listarCarreras() {
        return carreras.stream().filter(Carrera::isEstado).collect(Collectors.toList());
    }

    public static Carrera buscarCarreraPorCodigo(String codigo) {
        for (Carrera c : carreras) {
            if (c.getCodigo().equals(codigo)) {
                return c;
            }
        }
        return null;
    }

    public static void agregarCarrera(Carrera c) {
        c.setEstado(true);
        carreras.add(c);
    }

    public static void modificarCarrera(Carrera carreraModificada) {
        eliminarCarrera(carreraModificada.getCodigo());
        agregarCarrera(carreraModificada);
    }

    public static void eliminarCarrera(String codigo) {
        for (Carrera carrera : carreras) {
            if (carrera.getCodigo().equals(codigo)) {
                carrera.setEstado(false);
                break;
            }
        }
    }
}


