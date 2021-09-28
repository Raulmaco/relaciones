package com.example.jpademo.application;

import com.example.jpademo.application.port.StudentServiceInterface;
import com.example.jpademo.domain.Persona;
import com.example.jpademo.domain.Profesor;
import com.example.jpademo.domain.Student;
import com.example.jpademo.infraestructure.controller.dto.input.StudentInputDto;
import com.example.jpademo.infraestructure.controller.dto.output.StudentOutputDto;
import com.example.jpademo.infraestructure.exceptions.NotFoundException;
import com.example.jpademo.infraestructure.repository.ProfesorRepository;
import com.example.jpademo.infraestructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService implements StudentServiceInterface {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    PersonaService personaService;

    @Autowired
    ProfesorService profesorService;

    @Autowired
    ProfesorRepository profesorRepository;

    public StudentOutputDto añadirDto (StudentInputDto studentInputDto) throws NotFoundException{
        Persona persona= personaService.getid(studentInputDto.getId_persona());
        Profesor profesor = profesorService.getid(studentInputDto.getId_profesor());
        Student student = new Student(studentInputDto, persona, profesor);

        List<Student> studentList = studentRepository.findAll().stream().collect(Collectors.toList());
        for (Student s:
                studentList) {
            if(s.getPersona().getId_persona()==studentInputDto.getId_persona()){
                throw new NotFoundException("Esa persona ya es un estudiante");
            }

        }

        List<Profesor> profesorList = profesorRepository.findAll().stream().collect(Collectors.toList());
        for (Profesor p:
                profesorList) {
            if(p.getPersona().getId_persona()==studentInputDto.getId_persona()){
                throw new NotFoundException("Esa persona ya es un profesor");
            }

        }

        studentRepository.save(student);
        StudentOutputDto output = new StudentOutputDto(student);
        return output;
    }




    public void borrar(String id) throws NotFoundException {
        studentRepository.findById(id).orElseThrow(() -> new NotFoundException("No existe un estudiante con ese ID"));
        studentRepository.deleteById(id);
    }

    public void modificar (String id, StudentInputDto studentInputDto) throws NotFoundException {
        Student student= studentRepository.findById(id).orElseThrow(() -> new NotFoundException("No existe una persona con ese ID"));
        Persona persona= personaService.getid(studentInputDto.getId_persona());
        Profesor profesor = profesorService.getid(studentInputDto.getId_profesor());
        student.setStudent(studentInputDto, persona, profesor);
        studentRepository.save(student);
    }

    public Student getid(String id) throws NotFoundException {
        Student student = studentRepository.findById(id).orElseThrow(() -> new NotFoundException("Persona no encontrada"));
        return student;
    }
    public List<StudentOutputDto> mostrar(){
        return studentRepository.findAll().stream().map( p -> new StudentOutputDto(p)).collect(Collectors.toList());
    }
}
