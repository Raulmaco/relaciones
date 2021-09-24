package com.example.jpademo.infraestructure.controller.persona;

import com.example.jpademo.application.port.PersonaServiceInterface;
import com.example.jpademo.infraestructure.controller.dto.input.PersonaInputDto;
import com.example.jpademo.infraestructure.controller.dto.output.PersonaOutputDto;
import com.example.jpademo.application.PersonaService;
import com.example.jpademo.infraestructure.exceptions.UnprocessableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLOutput;

@RestController
@RequestMapping("/persona")
public class AddController {

    @Autowired
    PersonaServiceInterface personaService;


    @PostMapping("")
    public PersonaOutputDto añadePersona(@Valid @RequestBody PersonaInputDto personaInputDTO, Errors errors) throws UnprocessableException {
        if(errors.hasErrors()){
            throw new UnprocessableException("Persona no válida");
        }
        return personaService.añadirDto(personaInputDTO);
    }


}
