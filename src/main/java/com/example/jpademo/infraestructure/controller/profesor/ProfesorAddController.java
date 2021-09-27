package com.example.jpademo.infraestructure.controller.profesor;

import com.example.jpademo.application.port.ProfesorServiceInterface;
import com.example.jpademo.application.port.StudentServiceInterface;
import com.example.jpademo.infraestructure.controller.dto.input.ProfesorInputDto;
import com.example.jpademo.infraestructure.controller.dto.input.StudentInputDto;
import com.example.jpademo.infraestructure.controller.dto.output.ProfesorOutputDto;
import com.example.jpademo.infraestructure.controller.dto.output.StudentOutputDto;
import com.example.jpademo.infraestructure.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profesor")
public class ProfesorAddController {

    @Autowired
    ProfesorServiceInterface profesorServiceInterface;


    @PostMapping("")
    public ProfesorOutputDto añadeProfesor(@RequestBody ProfesorInputDto profesorInputDto) throws NotFoundException {
        return profesorServiceInterface.añadirDto(profesorInputDto);
    }


}