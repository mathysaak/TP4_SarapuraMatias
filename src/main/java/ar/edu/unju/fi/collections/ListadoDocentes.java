package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.model.Docente;

public class ListadoDocentes {
	public static List<Docente> docentes = new ArrayList<Docente>();
	
	// Método para listar docentes
	  public static List<Docente> listarDocentes() {
        return docentes.stream().filter(Docente::getEstado).collect(Collectors.toList());
	  }

	  // Método para buscar una materia por ID
	  public static Docente buscarDocentePorLegajo(String leg) {
	    for (Docente d : docentes) {
	      if (d.getLegajo().equals(leg)) {
	        return d;
	      }
	    }
	    return null;
	  }

	  // Método para agregar un Docente
	  public static void agregarDocente(Docente d) {
		  d.setEstado(true);
	    docentes.add(d);
	  }

	  // Método para modificar un Docente
	    public static void modificarDocente(Docente docenteModificado) {
	        eliminarDocente(docenteModificado.getLegajo());
	        agregarDocente(docenteModificado);
	    }

	  // Método para eliminar un docente
	    public static void eliminarDocente(String legajo) {
	        for (Docente alumno : docentes) {
	            if (alumno.getLegajo().equals(legajo)) {
	                alumno.setEstado(false);
	                break;
	            }
	        }
	    }
}
