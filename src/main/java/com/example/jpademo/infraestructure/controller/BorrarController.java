package com.example.jpademo.infraestructure.controller;

import com.example.jpademo.domain.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
public class BorrarController {

    @Autowired
    PersonaService personaService;


    @DeleteMapping("/{id}")
    public void borraPersona(@PathVariable Integer id)
    {
        personaService.borrar(id);
    }


}
