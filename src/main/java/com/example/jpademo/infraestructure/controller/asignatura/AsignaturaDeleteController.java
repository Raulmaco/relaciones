package com.example.jpademo.infraestructure.controller.asignatura;

import com.example.jpademo.application.port.AsignaturaServiceInterface;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asignatura")
public class AsignaturaDeleteController {

    @Autowired
    AsignaturaServiceInterface asignaturaServiceInterface;

    @DeleteMapping("{id}")
    public void deleteASignatura(@PathVariable String id) throws NotFoundException {
        asignaturaServiceInterface.borrar(id);
    }


}
