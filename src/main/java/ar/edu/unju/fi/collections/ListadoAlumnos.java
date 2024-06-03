package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Alumno;



public class ListadoAlumnos {

	public static List<Alumno> alumnos = new ArrayList<Alumno>();
	
	//Metodo para listar alumnos		
	public static List<Alumno> listarAlumnos(){
		return alumnos;
	}
	
	//Metodo para buscar alumnos por id
	public static Alumno buscarAlumnoPorLegajo(String codigo) {
	    for (Alumno a : alumnos) {
	      if (a.getLegajo().equals(codigo)) {
	        return a;
	      }
	    }
	    return null;
	  }
	
	  // Método para agregar un alumno
	  public static void agregarAlumno(Alumno a) {
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
	  public static void eliminarAlumno(String leg) {
	    alumnos.removeIf(alumno -> alumno.getLegajo().equals(leg));
	  }
	
}
