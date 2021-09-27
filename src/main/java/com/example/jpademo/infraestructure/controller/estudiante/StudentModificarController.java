package com.example.jpademo.infraestructure.controller.estudiante;

import com.example.jpademo.application.port.StudentServiceInterface;
import com.example.jpademo.infraestructure.controller.dto.input.StudentInputDto;
import com.example.jpademo.infraestructure.exceptions.UnprocessableException;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/estudiante")
public class StudentModificarController {

    @Autowired
    StudentServiceInterface studentServiceInterface;


    @PutMapping("{id}")
    public void modificaStudent(@PathVariable String id, @Valid @RequestBody StudentInputDto studentInputDto, Errors errors) throws NotFoundException, UnprocessableException {
        if(errors.hasErrors()){
            throw new UnprocessableException("Estudiante no válida");
        }
        studentServiceInterface.modificar(id,studentInputDto);
    }
}
