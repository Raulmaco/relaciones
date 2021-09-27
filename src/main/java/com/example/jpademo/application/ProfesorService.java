package com.example.jpademo.application;

import com.example.jpademo.application.port.ProfesorServiceInterface;
import com.example.jpademo.domain.Persona;
import com.example.jpademo.domain.Profesor;
import com.example.jpademo.domain.Student;
import com.example.jpademo.infraestructure.controller.dto.input.ProfesorInputDto;
import com.example.jpademo.infraestructure.controller.dto.input.StudentInputDto;
import com.example.jpademo.infraestructure.controller.dto.output.ProfesorOutputDto;
import com.example.jpademo.infraestructure.controller.dto.output.StudentOutputDto;
import com.example.jpademo.infraestructure.exceptions.NotFoundException;
import com.example.jpademo.infraestructure.repository.ProfesorRepository;
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

    @Override
    public ProfesorOutputDto añadirDto (ProfesorInputDto profesorInputDto) throws NotFoundException {
        Persona persona= personaService.getid(profesorInputDto.getId_persona());
        Profesor profesor = new Profesor(profesorInputDto, persona);
        profesorRepository.save(profesor);
        ProfesorOutputDto output = new ProfesorOutputDto(profesor);
        return output;
    }

    public void borrar(String id) throws NotFoundException {
        profesorRepository.findById(id).orElseThrow(() -> new NotFoundException("No existe un profesor con ese ID"));
        profesorRepository.deleteById(id);
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
    public List<ProfesorOutputDto> mostrar(){
        return profesorRepository.findAll().stream().map( p -> new ProfesorOutputDto(p)).collect(Collectors.toList());
    }

}
