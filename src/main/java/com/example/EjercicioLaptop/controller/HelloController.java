package com.example.EjercicioLaptop.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @GetMapping ("/hello")
    public String saludar(){

        return "Hello good night";
    }

}
