package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unju.fi.model.Materia;

public class ListadoMaterias {

    public static List<Materia> materias = new ArrayList<>();

    // Método para listar materias
    public static List<Materia> listarMaterias() {
        return materias.stream().filter(Materia::getEstado).collect(Collectors.toList());
    }

    // Método para buscar materia por código
    public static Materia buscarMateriaPorCodigo(String codigo) {
        for (Materia m : materias) {
            if (m.getCodigo().equals(codigo)) {
                return m;
            }
        }
        return null;
    }

    // Método para agregar una materia
    public static void agregarMateria(Materia m) {
        m.setEstado(true);
        materias.add(m);
    }

    // Método para modificar una materia
    public static void modificarMateria(Materia materiaModificada) {
        eliminarMateria(materiaModificada.getCodigo());
        agregarMateria(materiaModificada);
    }

    // Método para eliminar una materia
    public static void eliminarMateria(String codigo) {
        for (Materia materia : materias) {
            if (materia.getCodigo().equals(codigo)) {
                materia.setEstado(false);
                break;
            }
        }
    }
}

