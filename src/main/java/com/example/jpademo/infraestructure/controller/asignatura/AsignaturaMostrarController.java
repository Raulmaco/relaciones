package com.example.jpademo.infraestructure.controller.asignatura;


import com.example.jpademo.application.port.AsignaturaServiceInterface;
import com.example.jpademo.application.port.StudentServiceInterface;
import com.example.jpademo.domain.Asignatura;
import com.example.jpademo.domain.Student;
import com.example.jpademo.infraestructure.controller.dto.output.AsignaturaOutputDto;
import com.example.jpademo.infraestructure.controller.dto.output.StudentOutputDto;
import com.example.jpademo.infraestructure.controller.dto.output.StudentPersonaOutputDto;
import com.example.jpademo.infraestructure.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asignatura")
public class AsignaturaMostrarController {

    @Autowired
    AsignaturaServiceInterface asignaturaServiceInterface;


    @GetMapping("{id}")
    public AsignaturaOutputDto getId(@PathVariable String id, @RequestParam(name = "outputType",  defaultValue = "simple") String outputType) throws NotFoundException {
        Asignatura asignatura = asignaturaServiceInterface.getid(id);
        if (outputType.equals("full") ) {
            return new AsignaturaOutputDto(asignatura);
        } else {
            return new AsignaturaOutputDto(asignatura);
        }
    }


    @GetMapping("")
    public List<AsignaturaOutputDto> mostrarTodos()
    {
        return asignaturaServiceInterface.mostrar();
    }
}