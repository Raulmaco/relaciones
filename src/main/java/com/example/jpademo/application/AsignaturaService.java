package com.example.jpademo.application;

import com.example.jpademo.application.port.AsignaturaServiceInterface;
import com.example.jpademo.domain.Asignatura;
import com.example.jpademo.domain.Student;
import com.example.jpademo.infraestructure.controller.dto.input.AsignaturaInputDto;
import com.example.jpademo.infraestructure.controller.dto.output.AsignaturaOutputDto;
import com.example.jpademo.infraestructure.exceptions.NotFoundException;
import com.example.jpademo.infraestructure.repository.AsignaturaRepository;
import com.example.jpademo.infraestructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AsignaturaService implements AsignaturaServiceInterface {

    @Autowired
    AsignaturaRepository asignaturaRepository;

    @Autowired
    AsignaturaService asignaturaService;

    @Autowired
    StudentService studentService;

    @Autowired
    StudentRepository studentRepository;

    public AsignaturaOutputDto añadirDto (AsignaturaInputDto asignaturaInputDto) throws NotFoundException {
        List<Student> studentList = new ArrayList<>();
        if(asignaturaInputDto.getId_student()!=null) {
            for (String p : asignaturaInputDto.getId_student()) {
                Student student = studentService.getid(p);
                studentList.add(student);
            }
        }
        Asignatura asignatura = new Asignatura(asignaturaInputDto, studentList);

        if(studentList!=null) {
            for (Student student : studentList) {
                List<Asignatura> asignaturas = student.getAsignaturas();
                asignaturas.add(asignatura);
                student.setAsignaturas(asignaturas);
            }
        }
        asignaturaRepository.save(asignatura);
        AsignaturaOutputDto output = new AsignaturaOutputDto(asignatura);
        return output;
    }


    public void borrar(String id) throws NotFoundException {
        Asignatura asignatura= asignaturaRepository.findById(id).orElseThrow(() -> new NotFoundException("No existe un estudiante con ese ID"));
        List<Student> studentList = asignatura.getStudent();
        if(studentList!=null){
            throw new NotFoundException("La asignatura tiene algun estudiante matriculado. No puede ser borrada.");
        }else{
            asignaturaRepository.deleteById(id);
        }
    }

    public void modificar (String id, AsignaturaInputDto asignaturaInputDto) throws NotFoundException {
        List<Student> studentList = new ArrayList<>();
        for (String p: asignaturaInputDto.getId_student()) {
            Student student = studentService.getid(p);
            studentList.add(student);
        }
        Asignatura asignatura = asignaturaRepository.findById(id).orElseThrow(() -> new NotFoundException("No existe una asignatura con ese ID"));
        asignatura.setAsignatura(asignaturaInputDto,studentList);
        asignaturaRepository.save(asignatura);
    }
    public Asignatura getid(String id) throws NotFoundException {
        Asignatura asignatura = asignaturaRepository.findById(id).orElseThrow(() -> new NotFoundException("Asignatura no encontrada"));
        return asignatura;
    }
    public List<AsignaturaOutputDto> mostrar(){
        return asignaturaRepository.findAll().stream().map( p -> new AsignaturaOutputDto(p)).collect(Collectors.toList());
    }

}
