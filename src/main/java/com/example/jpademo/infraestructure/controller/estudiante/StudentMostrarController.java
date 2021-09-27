package com.example.jpademo.infraestructure.controller.estudiante;


import com.example.jpademo.application.port.PersonaServiceInterface;
import com.example.jpademo.application.port.StudentServiceInterface;
import com.example.jpademo.domain.Persona;
import com.example.jpademo.domain.Student;
import com.example.jpademo.infraestructure.controller.dto.output.PersonaOutputDto;
import com.example.jpademo.infraestructure.controller.dto.output.StudentOutputDto;
import com.example.jpademo.infraestructure.controller.dto.output.StudentPersonaOutputDto;
import com.example.jpademo.infraestructure.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/estudiante")
public class StudentMostrarController {

    @Autowired
    StudentServiceInterface studentServiceInterface;


    @GetMapping("{id}")
    public StudentOutputDto getId(@PathVariable String id, @RequestParam(name = "outputType",  defaultValue = "simple") String outputType) throws NotFoundException {
        Student student = studentServiceInterface.getid(id);
        if (outputType.equals("full") ) {
            return new StudentPersonaOutputDto(student);
        } else {
            return new StudentOutputDto(student);
        }
    }


    @GetMapping("")
    public List<StudentOutputDto> mostrarTodos()
    {
        return studentServiceInterface.mostrar();
    }
}
