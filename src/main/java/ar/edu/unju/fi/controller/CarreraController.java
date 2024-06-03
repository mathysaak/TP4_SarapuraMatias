package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Carrera;

@Controller
public class CarreraController {
	@GetMapping()
	public ModelAndView getFormularioCarrera() { //Manejo de html y objetos
		//vosta formCarrerDocente.html
		ModelAndView modelView = new ModelAndView("formCarrerDocente");
		//agrega el objeto
		modelView.addObject(new Carrera());
		
		return modelView;
	}
}
