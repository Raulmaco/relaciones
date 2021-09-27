package com.example.jpademo.infraestructure.controller.profesor;

import com.example.jpademo.application.port.ProfesorServiceInterface;
import com.example.jpademo.application.port.StudentServiceInterface;
import com.example.jpademo.domain.Profesor;
import com.example.jpademo.domain.Student;
import com.example.jpademo.infraestructure.controller.dto.output.ProfesorOutputDto;
import com.example.jpademo.infraestructure.controller.dto.output.StudentOutputDto;
import com.example.jpademo.infraestructure.controller.dto.output.StudentPersonaOutputDto;
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
    public ProfesorOutputDto getId(@PathVariable String id, @RequestParam(name = "outputType",  defaultValue = "simple") String outputType) throws NotFoundException {
        Profesor profesor = profesorServiceInterface.getid(id);
        if (outputType.equals("full") ) {
            return new ProfesorOutputDto(profesor);
        } else {
            return new ProfesorOutputDto(profesor);
        }
    }


    @GetMapping("")
    public List<ProfesorOutputDto> mostrarTodos()
    {
        return profesorServiceInterface.mostrar();
    }
}
