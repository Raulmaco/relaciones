package com.example.jpademo.application.port;

import com.example.jpademo.domain.Student;
import com.example.jpademo.infraestructure.controller.dto.input.StudentInputDto;
import com.example.jpademo.infraestructure.controller.dto.output.PersonaOutputDto;
import com.example.jpademo.infraestructure.controller.dto.output.StudentPersonaOutputDto;
import com.example.jpademo.infraestructure.exceptions.NotFoundException;

import java.util.List;

public interface StudentServiceInterface {
    public StudentPersonaOutputDto añadirDto (StudentInputDto studentInputDto) throws NotFoundException;

    public Student getid(String id) throws NotFoundException ;

    public void borrar(String id) throws NotFoundException;

    public void modificar (String id, StudentInputDto studentInputDto) throws NotFoundException;

    public List<PersonaOutputDto> mostrar();

    public List<PersonaOutputDto> mostrarSoloPersona();

    public void añadirAsignatura(String id,List<String> id_asignatura);

    public void eliminarAsignatura(String id,List<String> id_asignatura) throws NotFoundException;
}
