package com.example.jpademo.application.port;

import com.example.jpademo.domain.Asignatura;
import com.example.jpademo.infraestructure.controller.dto.input.AsignaturaInputDto;
import com.example.jpademo.infraestructure.controller.dto.output.AsignaturaOutputDto;
import com.example.jpademo.infraestructure.exceptions.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public interface AsignaturaServiceInterface {
    public AsignaturaOutputDto añadirDto (AsignaturaInputDto asignaturaInputDto) throws NotFoundException;

    public void borrar(String id) throws NotFoundException;

    public void modificar (String id, AsignaturaInputDto asignaturaInputDto) throws NotFoundException;

    public Asignatura getid(String id) throws NotFoundException ;

    public List<AsignaturaOutputDto> mostrar();
}
