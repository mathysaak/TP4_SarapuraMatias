package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoCarreras;
import ar.edu.unju.fi.model.Carrera;

@Controller
public class CarreraController {

    @Autowired
    Carrera nuevaCarrera = new Carrera();

    @GetMapping("/formularioCarrera")
    public ModelAndView getFormularioCarrera() {
        ModelAndView modeloVista = new ModelAndView("formCarrer");
        modeloVista.addObject("nuevaCarrera", nuevaCarrera);
        return modeloVista;
    }

    @PostMapping("/guardarCarrera")
    public ModelAndView saveCarrera(@ModelAttribute("nuevaCarrera") Carrera carreraParaGuardar) {
        // Buscar si ya existe una carrera con el mismo código y eliminarla
        Carrera carreraExistente = ListadoCarreras.buscarCarreraPorCodigo(carreraParaGuardar.getCodigo());
        if (carreraExistente != null) {
            ListadoCarreras.eliminarCarrera(carreraParaGuardar.getCodigo());
        }
        ListadoCarreras.agregarCarrera(carreraParaGuardar);

        ModelAndView modelView = new ModelAndView("listaDeCarreras");
        modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras());

        return modelView;
    }

    @GetMapping("/borrarCarrera/{codigo}")
    public ModelAndView deleteCarreraDelListado(@PathVariable(name="codigo") String codigo) {
        ListadoCarreras.eliminarCarrera(codigo);

        ModelAndView modelView = new ModelAndView("listaDeCarreras");
        modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras());

        return modelView;
    }

    @GetMapping("/editarCarrera/{codigo}")
    public ModelAndView getEditarCarrera(@PathVariable(name="codigo") String codigo) {
        Carrera carrera = ListadoCarreras.buscarCarreraPorCodigo(codigo);

        ModelAndView modeloVista = new ModelAndView("formCarrer");
        modeloVista.addObject("nuevaCarrera", carrera);

        return modeloVista;
    }

    @PostMapping("/actualizarCarrera")
    public ModelAndView updateCarrera(@ModelAttribute("nuevaCarrera") Carrera carreraModificada) {
        ListadoCarreras.modificarCarrera(carreraModificada);

        ModelAndView modelView = new ModelAndView("listaDeCarreras");
        modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras());

        return modelView;
    }
}


