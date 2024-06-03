package ar.edu.unju.fi.controller;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Carrera;

public class ListadoCarreras {

		public static List<Carrera> carerras = new ArrayList<Carrera>();
		
		public static List<Carrera> listarCarreras(){
			return carerras;
		}
		
		//public static Carrera buscarCarreraPorCodigo(String codigo) {
			//for (Carrera c: carerras) {
				//if(c.getCodigo().equals(codigo)) {
					//return c;
				//}
				//return null;
			//}
		//}
		public static void agregarCarrera(Carrera c) {
			carerras.add(c);
		}
		
		//public static void modificarCarrera(Carrera carreraModificada) {
			//for (int i = 0; i<carerras.size();i++) {
				//Carrera carrera = carerras.get(i);
				//if(carrera.getCodigo(.equals(carreraModificada.getCodigo())){
					//carerras.set(i,carreraModificada);
					//break;
				//}
			//}
			
			//public static void eliminarCarrera(String codigo) {
				//carreras.removeIf(carrera -> carreta.getCodigo().equals(codigo)));
			//}
		//}
		
}
