package com.example.jpademo.domain;


import com.example.jpademo.infraestructure.controller.dto.input.PersonaInputDto;
import com.example.jpademo.infraestructure.controller.dto.output.PersonaOutputDto;
import com.example.jpademo.infraestructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaService implements PersonaServiceInterface{

    @Autowired
    PersonaRepository personaRepository;

    //List<Persona> personas = new ArrayList<>();
    //int i=0;

   // public List<Persona> getPersonas() {
        //return personas;
   // }

    public void setPersonas(List<Persona> personas) {
        //this.personas = personas;
    }

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

    public void modificar (int id, PersonaInputDto persona)
    {
        Persona persona1= personaRepository.getById(id);
        persona1.setActive(persona.active);
        persona1.setCity(persona.city);
        persona1.setPassword(persona.password);
        persona1.setName(persona.name);
        persona1.setCompany_email(persona.company_email);
        persona1.setSurname(persona.surname);
        persona1.setPersonal_email(persona.personal_email);
        persona1.setCreate_date(persona.create_date);
        persona1.setUser(persona.user);
        persona1.setImagen_url(persona.imagen_url);
        persona1.setTermination_date(persona.termination_date);
        personaRepository.save(persona1);
    }

    public void borrar(int id){
        personaRepository.deleteById(id);
        //personas.remove(id);
    }

    public Persona getid(int id) throws Exception {
       // return personaRepository.getById(id);
        Persona persona = personaRepository.findById(id).orElseThrow(() -> new Exception("Persona no encontrada"));
        return persona;
    }

    public List<PersonaOutputDto> getByNombre(String nombre){
        return personaRepository.findByName(nombre).stream().map( p -> new PersonaOutputDto(p)).collect(Collectors.toList());
    }

    public List<PersonaOutputDto> mostrar(){
        return personaRepository.findAll().stream().map( p -> new PersonaOutputDto(p)).collect(Collectors.toList());
    }
}
