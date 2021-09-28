package com.example.jpademo.application;

import com.example.jpademo.application.port.ProfesorServiceInterface;
import com.example.jpademo.domain.Persona;
import com.example.jpademo.domain.Profesor;
import com.example.jpademo.domain.Student;
import com.example.jpademo.infraestructure.controller.dto.input.ProfesorInputDto;
import com.example.jpademo.infraestructure.controller.dto.output.PersonaOutputDto;
import com.example.jpademo.infraestructure.controller.dto.output.ProfesorOutputDto;
import com.example.jpademo.infraestructure.exceptions.NotFoundException;
import com.example.jpademo.infraestructure.repository.ProfesorRepository;
import com.example.jpademo.infraestructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfesorService implements ProfesorServiceInterface {

    @Autowired
    ProfesorRepository profesorRepository;

    @Autowired
    PersonaService personaService;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public ProfesorOutputDto añadirDto (ProfesorInputDto profesorInputDto) throws NotFoundException {
        Persona persona= personaService.getid(profesorInputDto.getId_persona());
        Profesor profesor = new Profesor(profesorInputDto, persona);
        List<Student> studentList = studentRepository.findAll().stream().collect(Collectors.toList());
        for (Student s:
                studentList) {
            if(s.getPersona().getId_persona()==profesorInputDto.getId_persona()){
                throw new NotFoundException("Esa persona ya es un estudiante");
            }

        }

        List<Profesor> profesorList = profesorRepository.findAll().stream().collect(Collectors.toList());
        for (Profesor p:
                profesorList) {
            if(p.getPersona().getId_persona()==profesorInputDto.getId_persona()){
                throw new NotFoundException("Esa persona ya es un profesor");
            }

        }
        persona.setProfesor(profesor);
        profesorRepository.save(profesor);
        ProfesorOutputDto output = new ProfesorOutputDto(persona);
        return output;
    }

    public void borrar(String id) throws NotFoundException {
        Profesor profesor = profesorRepository.findById(id).orElseThrow(() -> new NotFoundException("No existe un profesor con ese ID"));
        Persona persona = profesor.getPersona();
        List<Student> studentList = profesor.getStudentList();

        if(studentList!=null){
            throw new NotFoundException("El profesor tiene estudiantes asingados. No puede ser borrado.");
        }else{
            if(persona!=null){
                throw new NotFoundException("El profesor tiene una persona asignada. No puede ser borrado");
            }else{
                profesorRepository.deleteById(id);
            }
        }
    }

    public void modificar (String id, ProfesorInputDto profesorInputDto) throws NotFoundException {
        Profesor profesor= profesorRepository.findById(id).orElseThrow(() -> new NotFoundException("No existe una persona con ese ID"));
        Persona persona= personaService.getid(profesorInputDto.getId_persona());
        profesor.setProfesor(profesorInputDto, persona);
        profesorRepository.save(profesor);
    }

    public Profesor getid(String id) throws NotFoundException {
        Profesor profesor = profesorRepository.findById(id).orElseThrow(() -> new NotFoundException("No existe un profesor con ese ID"));
        return profesor;
    }
    public List<PersonaOutputDto> mostrarSoloPersona(){
        return profesorRepository.findAll().stream().map( p -> new PersonaOutputDto(p.getPersona())).collect(Collectors.toList());
    }

    public List<PersonaOutputDto> mostrar(){
        return profesorRepository.findAll().stream().map( p -> new ProfesorOutputDto(p.getPersona())).collect(Collectors.toList());
    }

}
