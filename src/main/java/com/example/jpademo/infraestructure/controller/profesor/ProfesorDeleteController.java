package com.example.jpademo.infraestructure.controller.profesor;

import com.example.jpademo.application.port.ProfesorServiceInterface;
import com.example.jpademo.application.port.StudentServiceInterface;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profesor")
public class ProfesorDeleteController {

    @Autowired
    ProfesorServiceInterface profesorServiceInterface;

    @DeleteMapping("{id}")
    public void deleteProfesor(@PathVariable String id) throws NotFoundException {
        profesorServiceInterface.borrar(id);
    }


}