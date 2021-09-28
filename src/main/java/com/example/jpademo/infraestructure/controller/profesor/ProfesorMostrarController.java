package com.example.jpademo.infraestructure.controller.profesor;

import com.example.jpademo.application.port.ProfesorServiceInterface;
import com.example.jpademo.domain.Profesor;
import com.example.jpademo.infraestructure.controller.dto.output.PersonaOutputDto;
import com.example.jpademo.infraestructure.controller.dto.output.ProfesorOutputDto;
import com.example.jpademo.infraestructure.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesor")
public class ProfesorMostrarController {

    @Autowired
    ProfesorServiceInterface profesorServiceInterface;


    @GetMapping("{id}")
    public PersonaOutputDto getId(@PathVariable String id, @RequestParam(name = "soloPersona",  defaultValue = "false") String outputType) throws NotFoundException {
        Profesor profesor = profesorServiceInterface.getid(id);
        if (outputType.equals("true") ) {
            return new PersonaOutputDto(profesor.getPersona());
        } else {
            return new ProfesorOutputDto(profesor.getPersona());
        }
    }


    @GetMapping("")
    public List<PersonaOutputDto> mostrarTodos(@RequestParam(name = "soloPersona",  defaultValue = "false") String outputType)
    {
        if (outputType.equals("true") ) {
            return profesorServiceInterface.mostrarSoloPersona();
        } else {
            return profesorServiceInterface.mostrar();
        }
    }

}
