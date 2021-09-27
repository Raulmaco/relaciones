package com.example.jpademo.infraestructure.controller.estudiante;

import com.example.jpademo.application.port.StudentServiceInterface;
import com.example.jpademo.infraestructure.controller.dto.input.StudentInputDto;
import com.example.jpademo.infraestructure.controller.dto.output.StudentOutputDto;
import com.example.jpademo.infraestructure.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/estudiante")
public class StudentAddController {

    @Autowired
    StudentServiceInterface studentServiceInterface;


    @PostMapping()
    public StudentOutputDto añadeStudent(@RequestBody StudentInputDto studentInputDto) throws NotFoundException {
        return studentServiceInterface.añadirDto(studentInputDto);
    }


}
