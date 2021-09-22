package com.example.jpademo.application.port;

import com.example.jpademo.domain.Persona;
import com.example.jpademo.infraestructure.controller.dto.input.PersonaInputDto;
import com.example.jpademo.infraestructure.controller.dto.output.PersonaOutputDto;

import java.util.List;
import java.util.stream.Collectors;

public interface PersonaServiceInterface {

    public void añadir (Persona persona);

    public PersonaOutputDto añadirDto (PersonaInputDto personaInputDTO);

    public void modificar (int id, PersonaInputDto persona) throws Exception;

    public void borrar(int id) throws Exception;

    public Persona getid(int id) throws Exception;

    public List<PersonaOutputDto> getByNombre(String nombre);

    public List<PersonaOutputDto> mostrar();
}
