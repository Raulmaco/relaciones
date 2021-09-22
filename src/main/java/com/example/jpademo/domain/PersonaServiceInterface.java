package com.example.jpademo.domain;

import com.example.jpademo.infraestructure.controller.dto.input.PersonaInputDto;
import com.example.jpademo.infraestructure.controller.dto.output.PersonaOutputDto;

import java.util.List;
import java.util.stream.Collectors;

public interface PersonaServiceInterface {

    public void añadir (Persona persona);

    public PersonaOutputDto añadirDto (PersonaInputDto personaInputDTO);

    public void modificar (int id, PersonaInputDto persona);

    public void borrar(int id);

    public Persona getid(int id) throws Exception;

    public List<PersonaOutputDto> getByNombre(String nombre);

    public List<PersonaOutputDto> mostrar();
}
