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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.claseafe.gamecatalog.model.Plataforma;
import com.claseafe.gamecatalog.model.Videojuego;
import com.claseafe.gamecatalog.service.IDesarrolladorService;
import com.claseafe.gamecatalog.service.IGeneroService;
import com.claseafe.gamecatalog.service.IPlataformaService;
import com.claseafe.gamecatalog.service.IVideojuegoService;

@Controller
@RequestMapping("/videojuegos")
public class VideojuegoController {

    @Autowired
    private IVideojuegoService videojuegoService;

    @Autowired
    private IGeneroService generoService;

    @Autowired
    private IDesarrolladorService desarrolladorService;

    @Autowired
    private IPlataformaService plataformaService;

    
    @GetMapping("/index")
    public String mostrarIndex(Model model) {
        model.addAttribute("videojuegos", videojuegoService.buscarTodos());
        return "videojuegos/listVideojuegos";
    }

    
    @GetMapping("/view/{id}")
    public String verDetalle(@PathVariable("id") int id, Model model) {
        Videojuego videojuego = videojuegoService.buscaPorId(id);
        model.addAttribute("videojuego", videojuego);
        return "videojuegos/detalleVideojuego";
    }

    
    @GetMapping("/create")
    public String crear(Videojuego videojuego, Model model) {
        cargarDatosFormulario(model);
        return "videojuegos/formVideojuego";
    }

   
    @PostMapping("/save")
    public String guardar(Videojuego videojuego,
                          BindingResult result,
                          @RequestParam(value = "idPlataformas", required = false) List<Integer> idPlataformas,
                          RedirectAttributes attributes,
                          Model model) {

        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
            cargarDatosFormulario(model);
            return "videojuegos/formVideojuego";
        }

        
        if (idPlataformas != null && !idPlataformas.isEmpty()) {
            List<Plataforma> plataformasSeleccionadas = idPlataformas.stream()
                    .map(id -> plataformaService.buscaPorId(id))
                    .filter(p -> p != null)
                    .collect(java.util.stream.Collectors.toList());
            videojuego.setPlataformas(plataformasSeleccionadas);
        }

        videojuegoService.guardar(videojuego);
        attributes.addFlashAttribute("msg", "El videojuego fue guardado correctamente");
        return "redirect:/videojuegos/index";
    }

    
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("videojuego", videojuegoService.buscaPorId(id));
        cargarDatosFormulario(model);
        return "videojuegos/formVideojuego";
    }

    
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable Integer id, RedirectAttributes attributes) {
        videojuegoService.eliminar(id);
        attributes.addFlashAttribute("msg", "El videojuego fue eliminado correctamente");
        return "redirect:/videojuegos/index";
    }

    
    private void cargarDatosFormulario(Model model) {
        model.addAttribute("generos", generoService.buscarTodos());
        model.addAttribute("desarrolladores", desarrolladorService.buscarTodos());
        model.addAttribute("plataformas", plataformaService.buscarTodas());
        model.addAttribute("clasificaciones",
            java.util.List.of("E", "E10+", "T", "M", "AO"));
        model.addAttribute("estatuses",
            java.util.List.of("Disponible", "Agotado", "Próximamente"));
    }
}
