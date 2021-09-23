package com.example.jpademo.infraestructure.controller;

import com.example.jpademo.application.port.PersonaServiceInterface;
import com.example.jpademo.domain.Persona;
import com.example.jpademo.application.PersonaService;
import com.example.jpademo.infraestructure.controller.dto.output.PersonaOutputDto;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class MostrarController {

    @Autowired
    PersonaServiceInterface personaService;


    @GetMapping("{id}")
    public PersonaOutputDto getId(@PathVariable Integer id) throws NotFoundException {
        Persona persona = personaService.getid(id);
        return new PersonaOutputDto(persona);
    }

    @GetMapping("/nombre/{nombre}")
    public List<PersonaOutputDto> putPersona(@PathVariable String nombre)
    {
        return personaService.getByNombre(nombre);
    }

    @GetMapping("")
    public List<PersonaOutputDto> mostrarTodos()
    {
        return personaService.mostrar();
    }
}
