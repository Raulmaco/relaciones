package com.example.jpademo.application;


import com.example.jpademo.application.port.PersonaServiceInterface;
import com.example.jpademo.domain.Persona;
import com.example.jpademo.infraestructure.controller.dto.input.PersonaInputDto;
import com.example.jpademo.infraestructure.controller.dto.output.PersonaOutputDto;
import com.example.jpademo.infraestructure.exceptions.NotFoundException;
import com.example.jpademo.infraestructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaService implements PersonaServiceInterface {

    @Autowired
    PersonaRepository personaRepository;

    public void añadir (Persona persona){
        System.out.println("Entrando a add Persona");
        personaRepository.save(persona);
        System.out.println("hola");
    }

    public PersonaOutputDto añadirDto (PersonaInputDto personaInputDTO){
        System.out.println("Entrando a add Persona");
        Persona p = new Persona(personaInputDTO);
        personaRepository.save(p);
        PersonaOutputDto output = new PersonaOutputDto(p);
        return output;
    }

    public void modificar (int id, PersonaInputDto persona) throws NotFoundException {
        Persona persona1= personaRepository.findById(id).orElseThrow(() -> new NotFoundException("No existe una persona con ese ID"));
        persona1.setPersona(persona);
        personaRepository.save(persona1);
    }

    public void borrar(int id) throws NotFoundException {
        personaRepository.findById(id).orElseThrow(() -> new NotFoundException("No existe una persona con ese ID"));
        personaRepository.deleteById(id);
    }

    public Persona getid(int id) throws NotFoundException {
        Persona persona = personaRepository.findById(id).orElseThrow(() -> new NotFoundException("Persona no encontrada"));
        return persona;
    }

    public List<PersonaOutputDto> getByNombre(String nombre){
        return personaRepository.findByName(nombre).stream().map( p -> new PersonaOutputDto(p)).collect(Collectors.toList());
    }

    public List<PersonaOutputDto> mostrar(){
        return personaRepository.findAll().stream().map( p -> new PersonaOutputDto(p)).collect(Collectors.toList());
    }
}
