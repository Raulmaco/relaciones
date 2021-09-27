package com.example.jpademo.application.port;

import com.example.jpademo.domain.Profesor;
import com.example.jpademo.infraestructure.controller.dto.input.ProfesorInputDto;
import com.example.jpademo.infraestructure.controller.dto.output.ProfesorOutputDto;
import com.example.jpademo.infraestructure.exceptions.NotFoundException;

import java.util.List;

public interface ProfesorServiceInterface {

    public ProfesorOutputDto añadirDto (ProfesorInputDto profesorInputDto) throws NotFoundException;

    public void borrar(String id) throws NotFoundException;

    public void modificar (String id, ProfesorInputDto profesorInputDto) throws NotFoundException ;

    public Profesor getid(String id) throws NotFoundException;
    public List<ProfesorOutputDto> mostrar();

}
