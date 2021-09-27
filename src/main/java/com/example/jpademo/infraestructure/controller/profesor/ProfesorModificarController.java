package com.example.jpademo.infraestructure.controller.profesor;

import com.example.jpademo.application.port.ProfesorServiceInterface;
import com.example.jpademo.application.port.StudentServiceInterface;
import com.example.jpademo.infraestructure.controller.dto.input.ProfesorInputDto;
import com.example.jpademo.infraestructure.controller.dto.input.StudentInputDto;
import com.example.jpademo.infraestructure.exceptions.UnprocessableException;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/profesor")
public class ProfesorModificarController {

    @Autowired
    ProfesorServiceInterface profesorServiceInterface;


    @PutMapping("{id}")
    public void modificaProfesor(@PathVariable String id, @Valid @RequestBody ProfesorInputDto profesorInputDto, Errors errors) throws NotFoundException, UnprocessableException {
        if(errors.hasErrors()){
            throw new UnprocessableException("Profesor no válido");
        }
        profesorServiceInterface.modificar(id,profesorInputDto);
    }
}
