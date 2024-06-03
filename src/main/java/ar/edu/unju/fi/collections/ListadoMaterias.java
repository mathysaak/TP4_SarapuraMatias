package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Materia;

public class ListadoMaterias {
	
	public static List<Materia> materias = new ArrayList<Materia>();
	
	//Metodo para listar alumnos		
	public static List<Materia> listarMaterias(){
		return materias;
	}
	
	//Metodo para buscar materias por id
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
	    materias.add(m);
	  }

	  // Método para modificar una materia
	  public static void modificarMateri(Materia materiaModificada) {
	    for (int i = 0; i < materias.size(); i++) {
	      Materia materia = materias.get(i);
	      if (materia.getCodigo().equals(materiaModificada.getCodigo())) {
	        materias.set(i, materiaModificada);
	        break;
	      }
	    }
	  }

	  // Método para eliminar una materia
	  public static void eliminarMateria(String codigo) {
	    materias.removeIf(alumno -> alumno.getCodigo().equals(codigo));
	  }

}
