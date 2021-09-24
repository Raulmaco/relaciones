package com.example.jpademo.application;

import com.example.jpademo.application.port.StudentServiceInterface;
import com.example.jpademo.domain.Persona;
import com.example.jpademo.domain.Student;
import com.example.jpademo.infraestructure.controller.dto.input.PersonaInputDto;
import com.example.jpademo.infraestructure.controller.dto.input.StudentInputDto;
import com.example.jpademo.infraestructure.controller.dto.output.PersonaOutputDto;
import com.example.jpademo.infraestructure.controller.dto.output.StudentOutputDto;
import com.example.jpademo.infraestructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements StudentServiceInterface {

    @Autowired
    StudentRepository studentRepository;

    public StudentOutputDto añadirDto (StudentInputDto studentInputDto){
        System.out.println("Entrando a add estudiante");
        Student student = new Student(studentInputDto);
        studentRepository.save(student);
        StudentOutputDto output = new StudentOutputDto(student);
        return output;
    }
}
