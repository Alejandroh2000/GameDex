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
import com.claseafe.gamecatalog.model.Desarrollador;
import com.claseafe.gamecatalog.service.IDesarrolladorService;

@Controller
@RequestMapping(value = "/desarrolladores")
public class DesarrolladorController {

    @Autowired
    private IDesarrolladorService desarrolladorService;

    @GetMapping("/index")
    public String mostrarIndex(Model model) {
        List<Desarrollador> lista = desarrolladorService.buscarTodos();
        model.addAttribute("desarrolladores", lista);
        return "desarrolladores/listDesarrolladores";
    }

    @GetMapping("/create")
    public String crear() {
        return "desarrolladores/formDesarrollador";
    }

    @PostMapping("/save")
    public String guardar(Desarrollador desarrollador, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
            return "desarrolladores/formDesarrollador";
        }
        desarrolladorService.guardar(desarrollador);
        attributes.addFlashAttribute("msg", "El desarrollador fue guardado correctamente");
        return "redirect:/desarrolladores/index";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("desarrollador", desarrolladorService.buscaPorId(id));
        return "desarrolladores/formDesarrollador";
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable Integer id, RedirectAttributes attributes) {
        desarrolladorService.eliminar(id);
        attributes.addFlashAttribute("msg", "El desarrollador fue eliminado correctamente");
        return "redirect:/desarrolladores/index";
    }
}
