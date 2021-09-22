package com.example.jpademo.infraestructure.controller;

import com.example.jpademo.domain.Persona;
import com.example.jpademo.domain.PersonaService;
import com.example.jpademo.infraestructure.controller.dto.input.PersonaInputDto;
import com.example.jpademo.infraestructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
public class ModificaController {

    @Autowired
    PersonaService personaService;
    PersonaRepository personaRepository;


    @PutMapping("/id/{id}")
    public void modificaPersona(@PathVariable int id, @RequestBody PersonaInputDto persona )
    {
        /*Persona persona1 = personaRepository.findById(id);
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
*/
        personaService.modificar(id,persona);
    }
}
