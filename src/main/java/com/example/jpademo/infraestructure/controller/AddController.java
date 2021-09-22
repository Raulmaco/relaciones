package com.example.jpademo.infraestructure.controller;

import com.example.jpademo.domain.Persona;
import com.example.jpademo.infraestructure.controller.dto.input.PersonaInputDto;
import com.example.jpademo.infraestructure.controller.dto.output.PersonaOutputDto;
import com.example.jpademo.domain.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
public class AddController {

    @Autowired
    PersonaService personaService;
    //PersonaRepository personaRepository;


    @PostMapping("")
    public PersonaOutputDto añadePersona(@RequestBody PersonaInputDto personaInputDTO) {

        return personaService.añadirDto(personaInputDTO);




/*        output.setId_persona(persona.getId_persona());
        output.setName(personaInputDTO.getName());
        output.setUser(personaInputDTO.getUser());
        output.setPassword(personaInputDTO.getPassword());
        output.setSurname(personaInputDTO.getSurname());
        output.setCompany_email(personaInputDTO.getCompany_email());
        output.setPersonal_email(personaInputDTO.getPersonal_email());
        output.setCity(personaInputDTO.getCity());
        output.setActive(personaInputDTO.getActive());
        output.setCreate_date(personaInputDTO.create_date);
        output.setImagen_url(personaInputDTO.getImagen_url());
        output.setTermination_date(personaInputDTO.termination_date);*/


    }

   /* @PostMapping("")
    public void añadePersona(@RequestBody Persona persona)
    {
        Persona persona1 = new Persona();
        persona1.setId_persona(persona.id_persona);
        persona1.setActive(persona.active);
        persona1.setCity(persona.city);
        persona.setPassword(persona.password);
        persona1.setName(persona.name);
        persona1.setCompany_email(persona.company_email);
        persona1.setSurname(persona.surname);
        persona1.setPersonal_email(persona.personal_email);
        persona1.setCreate_date(persona.create_date);
        persona1.setUser(persona.user);
        persona1.setImagen_url(persona.imagen_url);
        persona1.setTermination_date(persona.termination_date);
        System.out.println(persona1.name);
        personaService.añadir(persona1);
    }*/
}
