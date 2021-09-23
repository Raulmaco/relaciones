package com.example.jpademo.infraestructure.controller;

import com.example.jpademo.application.PersonaService;
import com.example.jpademo.application.port.PersonaServiceInterface;
import com.example.jpademo.infraestructure.controller.dto.input.PersonaInputDto;
import com.example.jpademo.infraestructure.exceptions.UnprocessableException;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/persona")
public class ModificaController {

    @Autowired
    PersonaServiceInterface personaService;


    @PutMapping("{id}")
    public void modificaPersona(@PathVariable int id, @Valid @RequestBody PersonaInputDto persona, Errors errors) throws NotFoundException, UnprocessableException {
        if(errors.hasErrors()){
            throw new UnprocessableException("Persona no válida");
        }
        personaService.modificar(id,persona);
    }
}
