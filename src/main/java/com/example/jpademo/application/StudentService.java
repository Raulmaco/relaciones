package com.example.jpademo.application;

import com.example.jpademo.application.port.PersonaServiceInterface;
import com.example.jpademo.application.port.StudentServiceInterface;
import com.example.jpademo.domain.Persona;
import com.example.jpademo.domain.Student;
import com.example.jpademo.infraestructure.controller.dto.input.PersonaInputDto;
import com.example.jpademo.infraestructure.controller.dto.input.StudentInputDto;
import com.example.jpademo.infraestructure.controller.dto.output.PersonaOutputDto;
import com.example.jpademo.infraestructure.controller.dto.output.StudentOutputDto;
import com.example.jpademo.infraestructure.exceptions.NotFoundException;
import com.example.jpademo.infraestructure.repository.PersonaRepository;
import com.example.jpademo.infraestructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements StudentServiceInterface {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    PersonaService personaService;

    public StudentOutputDto añadirDto (StudentInputDto studentInputDto) throws NotFoundException{
        System.out.println("Entrando a add estudiante");
        System.out.println("el id es "+ studentInputDto.getId_persona());
       // Persona persona = personaRepository.findById(studentInputDto.getId_persona()).orElseThrow(() -> new NotFoundException("Persona no encontrada"));
        Persona persona= personaService.getid(studentInputDto.getId_persona());
        System.out.println("la persona es "+ persona.getUser());
        Student student = new Student(studentInputDto, persona);
        studentRepository.save(student);
        StudentOutputDto output = new StudentOutputDto(student);
        return output;
    }

    public Student getid(String id) throws NotFoundException {
        Student student = studentRepository.findById(id).orElseThrow(() -> new NotFoundException("Persona no encontrada"));
        return student;
    }
}
