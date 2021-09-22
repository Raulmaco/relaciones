package com.example.jpademo.infraestructure.controller;

import com.example.jpademo.application.PersonaService;
import com.example.jpademo.application.port.PersonaServiceInterface;
import com.example.jpademo.infraestructure.controller.dto.input.PersonaInputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
public class ModificaController {

    @Autowired
    PersonaServiceInterface personaService;


    @PutMapping("{id}")
    public void modificaPersona(@PathVariable int id, @RequestBody PersonaInputDto persona ) throws Exception {
        personaService.modificar(id,persona);
    }
}
