package com.example.jpademo.infraestructure.controller;

import com.example.jpademo.domain.Persona;
import com.example.jpademo.domain.PersonaService;
import com.example.jpademo.infraestructure.controller.dto.input.PersonaInputDto;
import com.example.jpademo.infraestructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
public class ModificaController {

    @Autowired
    PersonaService personaService;


    @PutMapping("/id/{id}")
    public void modificaPersona(@PathVariable int id, @RequestBody PersonaInputDto persona )
    {
        personaService.modificar(id,persona);
    }
}
