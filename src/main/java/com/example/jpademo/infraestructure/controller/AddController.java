package com.example.jpademo.infraestructure.controller;

import com.example.jpademo.application.port.PersonaServiceInterface;
import com.example.jpademo.infraestructure.controller.dto.input.PersonaInputDto;
import com.example.jpademo.infraestructure.controller.dto.output.PersonaOutputDto;
import com.example.jpademo.application.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
public class AddController {

    @Autowired
    PersonaServiceInterface personaService;


    @PostMapping("")
    public PersonaOutputDto añadePersona(@RequestBody PersonaInputDto personaInputDTO) {
        return personaService.añadirDto(personaInputDTO);
    }


}
