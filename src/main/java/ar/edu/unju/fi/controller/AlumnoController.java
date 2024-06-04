package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoAlumnos;
import ar.edu.unju.fi.model.Alumno;

@Controller
public class AlumnoController {

    @Autowired
    Alumno nuevoAlumno = new Alumno();

    @GetMapping("/formularioAlumno")
    public ModelAndView getFormularioAlumno() {
        ModelAndView modeloVista = new ModelAndView("formAlumno");
        modeloVista.addObject("nuevoAlumno", nuevoAlumno);
        return modeloVista;
    }

    @PostMapping("/guardarAlumno")
    public ModelAndView saveAlumno(@ModelAttribute("nuevoAlumno") Alumno alumnoParaGuardar) {
        // Buscar si ya existe un alumno con el mismo legajo y eliminarlo
        Alumno alumnoExistente = ListadoAlumnos.buscarAlumnoPorLegajo(alumnoParaGuardar.getLegajo());
        if (alumnoExistente != null) {
            ListadoAlumnos.eliminarAlumno(alumnoParaGuardar.getLegajo());
        }
        ListadoAlumnos.agregarAlumno(alumnoParaGuardar);

        ModelAndView modelView = new ModelAndView("listaDeAlumnos");
        modelView.addObject("listadoAlumnos", ListadoAlumnos.listarAlumnos());

        return modelView;
    }

    @GetMapping("/borrarAlumno/{legajo}")
    public ModelAndView deleteAlumnoDelListado(@PathVariable(name="legajo") String legajo) {
        ListadoAlumnos.eliminarAlumno(legajo);

        ModelAndView modelView = new ModelAndView("listaDeAlumnos");
        modelView.addObject("listadoAlumnos", ListadoAlumnos.listarAlumnos());

        return modelView;
    }

    @GetMapping("/editarAlumno/{legajo}")
    public ModelAndView getEditarAlumno(@PathVariable(name="legajo") String legajo) {
        Alumno alumno = ListadoAlumnos.buscarAlumnoPorLegajo(legajo);

        ModelAndView modeloVista = new ModelAndView("formAlumno");
        modeloVista.addObject("nuevoAlumno", alumno);

        return modeloVista;
    }

    @PostMapping("/actualizarAlumno")
    public ModelAndView updateAlumno(@ModelAttribute("nuevoAlumno") Alumno alumnoModificado) {
        ListadoAlumnos.modificarAlumno(alumnoModificado);

        ModelAndView modelView = new ModelAndView("listaDeAlumnos");
        modelView.addObject("listadoAlumnos", ListadoAlumnos.listarAlumnos());

        return modelView;
    }
}
