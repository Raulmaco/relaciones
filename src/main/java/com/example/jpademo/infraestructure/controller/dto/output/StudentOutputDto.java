package com.example.jpademo.infraestructure.controller.dto.output;

import com.example.jpademo.domain.Persona;
import com.example.jpademo.domain.Profesor;
import com.example.jpademo.domain.Student;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class StudentOutputDto {

    String id_student;

    Persona persona;

    @NotNull
    Integer num_hours_week;

    String comments;

    Profesor profesor;

    @NotNull
    String branch;

    public StudentOutputDto(Student student) {
        if (student == null) {
            return;
        }
        setId_student(student.getId_student());
        setPersona(student.getPersona());
        setNum_hours_week(student.getNum_hours_week());
        setBranch(student.getBranch());
        setComments(student.getComments());
        setProfesor(student.getProfesor());
    }
}
