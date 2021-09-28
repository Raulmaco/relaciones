package com.example.jpademo.infraestructure.controller.estudiante;


import com.example.jpademo.application.port.StudentServiceInterface;
import com.example.jpademo.domain.Student;
import com.example.jpademo.infraestructure.controller.dto.output.PersonaOutputDto;
import com.example.jpademo.infraestructure.controller.dto.output.StudentPersonaOutputDto;
import com.example.jpademo.infraestructure.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiante")
public class StudentMostrarController {

    @Autowired
    StudentServiceInterface studentServiceInterface;


    /*@GetMapping("{id}")
    public StudentOutputDto getId(@PathVariable String id, @RequestParam(name = "outputType",  defaultValue = "simple") String outputType) throws NotFoundException {
        Student student = studentServiceInterface.getid(id);
        if (outputType.equals("full") ) {
            return new StudentPersonaOutputDto(student);
        } else {
            return new StudentOutputDto(student);
        }
    }*/

    @GetMapping("{id}")
    public PersonaOutputDto getId(@PathVariable String id, @RequestParam(name = "soloPersona",  defaultValue = "false") String outputType) throws NotFoundException {
        Student student = studentServiceInterface.getid(id);
        if (outputType.equals("true") ) {
            return new PersonaOutputDto(student.getPersona());
        } else {
            return new StudentPersonaOutputDto(student);
        }
    }



    @GetMapping("")
    public List<PersonaOutputDto> mostrarTodos(@RequestParam(name = "soloPersona",  defaultValue = "false") String outputType)
    {
        if (outputType.equals("true") ) {
            return studentServiceInterface.mostrarSoloPersona();
        } else {
            return studentServiceInterface.mostrar();
        }

    }
}
