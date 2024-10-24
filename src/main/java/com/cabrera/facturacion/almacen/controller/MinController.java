package com.cabrera.facturacion.almacen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MinController {

    @GetMapping("/")

    public String home() {
        return "index";
    }

    @GetMapping("/infracciones")

    public String infracciones() {
        return "infracciones";
    }
}