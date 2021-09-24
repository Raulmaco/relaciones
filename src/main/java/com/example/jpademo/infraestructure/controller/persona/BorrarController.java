package com.example.jpademo.infraestructure.controller.persona;

import com.example.jpademo.application.PersonaService;
import com.example.jpademo.application.port.PersonaServiceInterface;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
public class BorrarController {

    @Autowired
    PersonaServiceInterface personaService;


    @DeleteMapping("{id}")
    public void borraPersona(@PathVariable Integer id) throws NotFoundException {
        personaService.borrar(id);
    }


}
