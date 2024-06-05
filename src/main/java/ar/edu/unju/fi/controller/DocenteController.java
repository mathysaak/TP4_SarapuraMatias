package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoDocentes;
import ar.edu.unju.fi.model.Docente;


@Controller
public class DocenteController {
    @Autowired
    Docente nuevoDocente = new Docente();
    
    @GetMapping("/listaDocente")
    public ModelAndView getListaDocente() {
        ModelAndView modeloVista = new ModelAndView("listaDeDocentes");
        //modeloVista.addObject("nuevoDocente", nuevoDocente);
        return modeloVista;
    }
    
    @GetMapping("/formularioDocente")
    public ModelAndView getFormularioDocente() {
        ModelAndView modeloVista = new ModelAndView("formDocente");
        modeloVista.addObject("nuevoDocente", nuevoDocente);
        return modeloVista;
    }
    
    @PostMapping("/guardarDocente")
    public ModelAndView saveDocente(@ModelAttribute("nuevoDocente") Docente docenteParaGuardar) {
        // Buscar si ya existe un docente con el mismo legajo y eliminarlo
        Docente docenteExistente = ListadoDocentes.buscarDocentePorLegajo(docenteParaGuardar.getLegajo());
        if (docenteExistente != null) {
            ListadoDocentes.eliminarDocente(docenteParaGuardar.getLegajo());
        }
        ListadoDocentes.agregarDocente(docenteParaGuardar);

        ModelAndView modelView = new ModelAndView("listaDeDocentes");
        modelView.addObject("listadoDocentes", ListadoDocentes.listarDocentes());

        return modelView;
    }

    @GetMapping("/borrarDocente/{legajo}")
    public ModelAndView deleteDocenteDelListado(@PathVariable(name="legajo") String legajo) {
    	ListadoDocentes.eliminarDocente(legajo);

        ModelAndView modelView = new ModelAndView("listaDeDocentes");
        modelView.addObject("listadoDocentes", ListadoDocentes.listarDocentes());

        return modelView;
    }

    @GetMapping("/editarDocente/{legajo}")
    public ModelAndView getEditarDocente(@PathVariable(name="legajo") String legajo) {
    	Docente docente = ListadoDocentes.buscarDocentePorLegajo(legajo);

        ModelAndView modeloVista = new ModelAndView("formDocente");
        modeloVista.addObject("nuevoDocente", docente);

        return modeloVista;
    }

    @PostMapping("/actualizarDocente")
    public ModelAndView updateDocente(@ModelAttribute("nuevoDocente") Docente docenteModificado) {
        ListadoDocentes.modificarDocente(docenteModificado);

        ModelAndView modelView = new ModelAndView("listaDeDocentes");
        modelView.addObject("listadoDocentes", ListadoDocentes.listarDocentes());

        return modelView;
    }
}
