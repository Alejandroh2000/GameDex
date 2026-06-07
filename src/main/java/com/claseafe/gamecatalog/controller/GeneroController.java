package com.claseafe.gamecatalog.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.claseafe.gamecatalog.model.Genero;
import com.claseafe.gamecatalog.service.IGeneroService;

@Controller
@RequestMapping(value = "/generos")
public class GeneroController {

    @Autowired
    private IGeneroService generoService;

    // LISTAR - GET /generos/index
    @GetMapping("/index")
    public String mostrarIndex(Model model) {
        List<Genero> lista = generoService.buscarTodos();
        model.addAttribute("generos", lista);
        return "generos/listGeneros";
    }

    
    @GetMapping("/create")
    public String crear() {
        return "generos/formGenero";
    }

    
    @PostMapping("/save")
    public String guardar(Genero genero, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
            return "generos/formGenero";
        }
        generoService.guardar(genero);
        attributes.addFlashAttribute("msg", "El género fue guardado correctamente");
        return "redirect:/generos/index";
    }

    
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Genero genero = generoService.buscaPorId(id);
        model.addAttribute("genero", genero);
        return "generos/formGenero";
    }

    
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable Integer id, RedirectAttributes attributes) {
        generoService.eliminar(id);
        attributes.addFlashAttribute("msg", "El género fue eliminado correctamente");
        return "redirect:/generos/index";
    }

    
    @GetMapping("/view/{id}")
    public String verDetalle(@PathVariable Integer id, Model model) {
        Genero genero = generoService.buscaPorId(id);
        model.addAttribute("genero", genero);
        return "generos/detalleGenero";
    }
}
