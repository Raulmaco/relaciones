package com.example.jpademo.infraestructure.controller.estudiante;

import com.example.jpademo.application.port.PersonaServiceInterface;
import com.example.jpademo.application.port.StudentServiceInterface;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estudiante")
public class StudentDeleteController {

        @Autowired
        StudentServiceInterface studentServiceInterface;

        @DeleteMapping("{id}")
        public void deleteStudent(@PathVariable String id) throws NotFoundException {
            studentServiceInterface.borrar(id);
        }


}
