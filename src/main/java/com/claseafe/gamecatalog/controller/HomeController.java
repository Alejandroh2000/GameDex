package com.claseafe.gamecatalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.claseafe.gamecatalog.service.IVideojuegoService;
import com.claseafe.gamecatalog.service.IGeneroService;
import com.claseafe.gamecatalog.service.IDesarrolladorService;

@Controller
public class HomeController {

    @Autowired
    private IVideojuegoService videojuegoService;

    @Autowired
    private IGeneroService generoService;
    
    @Autowired
    private IDesarrolladorService desarrolladorService;


    @GetMapping("/")
    public String index(Model model) {
    model.addAttribute("videojuegos", videojuegoService.buscarTodos());
    model.addAttribute("generos", generoService.buscarTodos());
    model.addAttribute("totalDesarrolladores", desarrolladorService.buscarTodos().size());
        
        return "home";
    }
}
