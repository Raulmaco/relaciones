package com.example.jpademo.infraestructure.controller.asignatura;

import com.example.jpademo.application.port.AsignaturaServiceInterface;
import com.example.jpademo.application.port.StudentServiceInterface;
import com.example.jpademo.infraestructure.controller.dto.input.AsignaturaInputDto;
import com.example.jpademo.infraestructure.controller.dto.input.StudentInputDto;
import com.example.jpademo.infraestructure.exceptions.UnprocessableException;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/asignatura")
public class AsignaturaModificarController {

    @Autowired
    AsignaturaServiceInterface asignaturaServiceInterface;


    @PutMapping("{id}")
    public void modificaAsignatura(@PathVariable String id, @Valid @RequestBody AsignaturaInputDto asignaturaInputDto, Errors errors) throws NotFoundException, UnprocessableException {
        if(errors.hasErrors()){
            throw new UnprocessableException("Asignatura no válida");
        }
        asignaturaServiceInterface.modificar(id,asignaturaInputDto);
    }


}
