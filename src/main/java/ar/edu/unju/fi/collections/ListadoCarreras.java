package ar.edu.unju.fi.collections;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Carrera;

public class ListadoCarreras {

		public static List<Carrera> carerras = new ArrayList<Carrera>();
		
		//Metodo para listar carreras		
		public static List<Carrera> listarCarreras(){
			return carerras;
		}
		
		//Metodo para buscar carrera por id
		public static Carrera buscarCarreraPorCodigo(String codigo) {
		    for (Carrera c : carerras) {
		      if (c.getCodigo().equals(codigo)) {
		        return c;
		      }
		    }
		    return null;
		  }
		
		  // Método para agregar una carrera
		  public static void agregarCarrera(Carrera c) {
			//agregando el estado
			c.setEstado(true);
			carerras.add(c);
		  }
		
		  // Método para modificar una carrera
		  public static void modificarCarrera(Carrera carreraModificada) {
		    for (int i = 0; i < carerras.size(); i++) {
		      Carrera carrera = carerras.get(i);
		      if (carrera.getCodigo().equals(carreraModificada.getCodigo())) {
		    	  carerras.set(i, carreraModificada);
		        break;
		      }
		    }
		  }
			
			  // Método para eliminar una carrera
			  public static void eliminarCarrera(String codigo) {
				  //borrado físico
			    //carreras.removeIf(carrera -> carrera.getCodigo().equals(codigo));
				  
				  //borrado lógico
				  for (int i = 0; i < carerras.size(); i++) {
				      Carrera carrera = carerras.get(i);
				      if (carrera.getCodigo().equals(codigo)) {
				        carrera.setEstado(false);;
				        break;
				      }
				    }
			  }
		
}