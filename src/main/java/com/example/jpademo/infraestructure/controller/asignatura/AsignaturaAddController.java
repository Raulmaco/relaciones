package com.example.jpademo.infraestructure.controller.asignatura;

import com.example.jpademo.application.port.AsignaturaServiceInterface;
import com.example.jpademo.application.port.StudentServiceInterface;
import com.example.jpademo.infraestructure.controller.dto.input.AsignaturaInputDto;
import com.example.jpademo.infraestructure.controller.dto.input.StudentInputDto;
import com.example.jpademo.infraestructure.controller.dto.output.AsignaturaOutputDto;
import com.example.jpademo.infraestructure.controller.dto.output.StudentOutputDto;
import com.example.jpademo.infraestructure.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asignatura")
public class AsignaturaAddController {

    @Autowired
    AsignaturaServiceInterface asignaturaServiceInterface;


    @PostMapping("/hola")
    public AsignaturaOutputDto añadeAsignatura(@RequestBody AsignaturaInputDto asignaturaInputDto) throws NotFoundException {
        return asignaturaServiceInterface.añadirDto(asignaturaInputDto);
    }


}
