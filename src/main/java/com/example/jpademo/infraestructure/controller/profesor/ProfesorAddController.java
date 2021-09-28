package com.example.jpademo.infraestructure.controller.profesor;

import com.example.jpademo.application.port.ProfesorServiceInterface;
import com.example.jpademo.infraestructure.controller.dto.input.ProfesorInputDto;
import com.example.jpademo.infraestructure.controller.dto.output.ProfesorOutputDto;
import com.example.jpademo.infraestructure.exceptions.NotFoundException;
import com.example.jpademo.infraestructure.exceptions.UnprocessableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/profesor")
public class ProfesorAddController {

    @Autowired
    ProfesorServiceInterface profesorServiceInterface;


    @PostMapping("")
    public ProfesorOutputDto añadeProfesor(@Valid @RequestBody ProfesorInputDto profesorInputDto, Errors errors) throws NotFoundException, UnprocessableException {
        if(errors.hasErrors()){
            throw new UnprocessableException("Profesor no válido");
        }
        return profesorServiceInterface.añadirDto(profesorInputDto);
    }


}