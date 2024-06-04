package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoMaterias;
import ar.edu.unju.fi.model.Materia;

@Controller
public class MateriaController {

    @Autowired
    Materia nuevaMateria = new Materia();

    @GetMapping("/formularioMateria")
    public ModelAndView getFormularioMateria() {
        ModelAndView modeloVista = new ModelAndView("formMateria");
        modeloVista.addObject("nuevaMateria", nuevaMateria);
        return modeloVista;
    }

    @PostMapping("/guardarMateria")
    public ModelAndView saveMateria(@ModelAttribute("nuevaMateria") Materia materiaParaGuardar) {
        // Buscar si ya existe una materia con el mismo código y eliminarla
        Materia materiaExistente = ListadoMaterias.buscarMateriaPorCodigo(materiaParaGuardar.getCodigo());
        if (materiaExistente != null) {
            ListadoMaterias.eliminarMateria(materiaParaGuardar.getCodigo());
        }
        ListadoMaterias.agregarMateria(materiaParaGuardar);

        ModelAndView modelView = new ModelAndView("listaDeMaterias");
        modelView.addObject("listadoMaterias", ListadoMaterias.listarMaterias());

        return modelView;
    }

    @GetMapping("/borrarMateria/{codigo}")
    public ModelAndView deleteMateriaDelListado(@PathVariable(name="codigo") String codigo) {
        ListadoMaterias.eliminarMateria(codigo);

        ModelAndView modelView = new ModelAndView("listaDeMaterias");
        modelView.addObject("listadoMaterias", ListadoMaterias.listarMaterias());

        return modelView;
    }

    @GetMapping("/editarMateria/{codigo}")
    public ModelAndView getEditarMateria(@PathVariable(name="codigo") String codigo) {
        Materia materia = ListadoMaterias.buscarMateriaPorCodigo(codigo);

        ModelAndView modeloVista = new ModelAndView("formMateria");
        modeloVista.addObject("nuevaMateria", materia);

        return modeloVista;
    }

    @PostMapping("/actualizarMateria")
    public ModelAndView updateMateria(@ModelAttribute("nuevaMateria") Materia materiaModificada) {
        ListadoMaterias.modificarMateria(materiaModificada);

        ModelAndView modelView = new ModelAndView("listaDeMaterias");
        modelView.addObject("listadoMaterias", ListadoMaterias.listarMaterias());

        return modelView;
    }
}
