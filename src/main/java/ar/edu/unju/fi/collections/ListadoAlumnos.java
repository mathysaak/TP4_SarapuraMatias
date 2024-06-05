package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.model.Materia;

public class ListadoAlumnos {

    public static List<Alumno> alumnos = new ArrayList<>();

    // Método para listar alumnos
    public static List<Alumno> listarAlumnos() {
        return alumnos.stream().filter(Alumno::getEstado).collect(Collectors.toList());
    }

    // Método para buscar alumnos por legajo
    public static Alumno buscarAlumnoPorLegajo(String legajo) {
        for (Alumno a : alumnos) {
            if (a.getLegajo().equals(legajo)) {
                return a;
            }
        }
        return null;
    }

    // Método para agregar un alumno
    public static void agregarAlumno(Alumno a) {
        a.setEstado(true);
        alumnos.add(a);
    }

    // Método para modificar un alumno
    public static void modificarAlumno(Alumno alumnoModificado) {
        for (int i = 0; i < alumnos.size(); i++) {
            Alumno alumno = alumnos.get(i);
            if (alumno.getLegajo().equals(alumnoModificado.getLegajo())) {
                alumnos.set(i, alumnoModificado);
                break;
            }
        }
    }


    // Método para eliminar un alumno
    public static void eliminarAlumno(String legajo) {
		 //borrado físico
	    alumnos.removeIf(alumno -> alumno.getLegajo().equals(legajo));
    }
}
