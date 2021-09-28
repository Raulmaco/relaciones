package com.example.jpademo.application;

import com.example.jpademo.application.port.StudentServiceInterface;
import com.example.jpademo.domain.Asignatura;
import com.example.jpademo.domain.Persona;
import com.example.jpademo.domain.Profesor;
import com.example.jpademo.domain.Student;
import com.example.jpademo.infraestructure.controller.dto.input.StudentInputDto;
import com.example.jpademo.infraestructure.controller.dto.output.PersonaOutputDto;
import com.example.jpademo.infraestructure.controller.dto.output.StudentPersonaOutputDto;
import com.example.jpademo.infraestructure.exceptions.NotFoundException;
import com.example.jpademo.infraestructure.repository.AsignaturaRepository;
import com.example.jpademo.infraestructure.repository.ProfesorRepository;
import com.example.jpademo.infraestructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    AsignaturaRepository asignaturaRepository;

    @Autowired
    AsignaturaService asignaturaService;

    public StudentPersonaOutputDto añadirDto (StudentInputDto studentInputDto) throws NotFoundException{
        Persona persona= personaService.getid(studentInputDto.getId_persona());
        Profesor profesor = profesorService.getid(studentInputDto.getId_profesor());
        List<Asignatura> asignaturaList = new ArrayList<>();
        if(studentInputDto.getAsignaturas()!= null){
            for (String a:
                    studentInputDto.getAsignaturas()) {
                asignaturaList.add(asignaturaService.getid(a));
            }
        }

        Student student = new Student(studentInputDto, persona, profesor, asignaturaList);

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
        persona.setStudent(student);
        studentRepository.save(student);
        StudentPersonaOutputDto output = new StudentPersonaOutputDto(student);
        return output;
    }




    public void borrar(String id) throws NotFoundException {
        Student student= studentRepository.findById(id).orElseThrow(() -> new NotFoundException("No existe un estudiante con ese ID"));
        Profesor profesor = student.getProfesor();
        Persona persona = student.getPersona();
        List<Asignatura> asignaturas = student.getAsignaturas();

        if(profesor!=null){
            throw new NotFoundException("El estudiante tiene un profesor asignado. No puede ser borrado.");
        }else{
            if(persona!=null){
                throw new NotFoundException("El estudiante tiene una persona asignado. No puede ser borrado.");
            }else{
                if(asignaturas!=null){
                    throw new NotFoundException("El estudiante tiene alguna asignatura asignada. No puede ser borrado.");
                }else{
                    studentRepository.deleteById(id);
                }
            }
        }


    }



    public Student getid(String id) throws NotFoundException {
        Student student = studentRepository.findById(id).orElseThrow(() -> new NotFoundException("Estudiante no encontrado"));
        return student;
    }
    public List<PersonaOutputDto> mostrarSoloPersona(){
        return studentRepository.findAll().stream().map( p -> new PersonaOutputDto(p.getPersona())).collect(Collectors.toList());
    }

    public List<PersonaOutputDto> mostrar(){
        return studentRepository.findAll().stream().map( p -> new StudentPersonaOutputDto(p)).collect(Collectors.toList());
    }

    public void modificar (String id, StudentInputDto studentInputDto) throws NotFoundException {
        Student student= studentRepository.findById(id).orElseThrow(() -> new NotFoundException("No existe una persona con ese ID"));
        Persona persona= personaService.getid(studentInputDto.getId_persona());
        Profesor profesor = profesorService.getid(studentInputDto.getId_profesor());
        List<Asignatura> asignaturaList = new ArrayList<>();
        for (String a:
                studentInputDto.getAsignaturas()) {
            asignaturaList.add(asignaturaService.getid(a));
        }
        student.setStudent(studentInputDto, persona, profesor, asignaturaList);
        studentRepository.save(student);
    }

    public void añadirAsignatura(String id,List<String> id_asignatura) throws NotFoundException{
        Student student= studentRepository.findById(id).orElseThrow(() -> new NotFoundException("No existe una persona con ese ID"));
        List<Asignatura> asignaturas = student.getAsignaturas();
        for (String a:
             id_asignatura) {
            Asignatura asignatura = asignaturaRepository.findById(a).orElseThrow(() -> new NotFoundException("Una de las asignaturas introducidas no existe"));
            asignaturas.add(asignatura);
            asignatura.getStudent().add(student);
            asignaturaRepository.save(asignatura);
        }
        student.setAsignaturas(asignaturas);
        studentRepository.save(student);
    }

    public void eliminarAsignatura(String id,List<String> id_asignatura) throws NotFoundException{
        Student student= studentRepository.findById(id).orElseThrow(() -> new NotFoundException("No existe una persona con ese ID"));
        List<Asignatura> asignaturas = student.getAsignaturas();
        for (String a:
                id_asignatura) {
            Asignatura asignatura = asignaturaRepository.findById(a).orElseThrow(() -> new NotFoundException("Una de las asignaturas introducidas no existe"));
            asignaturas.remove(asignatura);
            asignatura.getStudent().remove(student);
            asignaturaRepository.save(asignatura);
        }
        student.setAsignaturas(asignaturas);
        studentRepository.save(student);
    }
}
