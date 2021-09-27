package com.example.jpademo.application.port;

import com.example.jpademo.domain.Persona;
import com.example.jpademo.domain.Student;
import com.example.jpademo.infraestructure.controller.dto.input.PersonaInputDto;
import com.example.jpademo.infraestructure.controller.dto.input.StudentInputDto;
import com.example.jpademo.infraestructure.controller.dto.output.PersonaOutputDto;
import com.example.jpademo.infraestructure.controller.dto.output.StudentOutputDto;
import com.example.jpademo.infraestructure.exceptions.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public interface StudentServiceInterface {
    public StudentOutputDto añadirDto (StudentInputDto studentInputDto) throws NotFoundException;

    public Student getid(String id) throws NotFoundException ;

    public void borrar(String id) throws NotFoundException;

    public void modificar (String id, StudentInputDto studentInputDto) throws NotFoundException;

    public List<StudentOutputDto> mostrar();

}
