package com.example.jpademo.infraestructure.controller;

import com.example.jpademo.domain.Persona;
import com.example.jpademo.domain.PersonaService;
import com.example.jpademo.infraestructure.controller.dto.output.PersonaOutputDto;
import com.example.jpademo.infraestructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class MostrarController {

    @Autowired
    PersonaService personaService;
    PersonaRepository personaRepository;


    @GetMapping("/id/{id}")
    public PersonaOutputDto getId(@PathVariable Integer id) throws Exception {


        Persona persona = personaService.getid(id);
        return new PersonaOutputDto(persona);
    }

    @GetMapping("/nombre/{nombre}")
    public List<PersonaOutputDto> putPersona(@PathVariable String nombre)
    {
        return personaService.getByNombre(nombre);
    }

    @GetMapping("/mostrar")
    public List<PersonaOutputDto> mostrarTodos()
    {
        return personaService.mostrar();
        //return personaRepository.findAll();
    }
}
