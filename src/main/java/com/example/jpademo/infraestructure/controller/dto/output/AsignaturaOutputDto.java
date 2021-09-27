package com.example.jpademo.infraestructure.controller.dto.output;

import com.example.jpademo.domain.Asignatura;
import com.example.jpademo.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AsignaturaOutputDto {

    String id_asignatura;
    List<String> student;
    String asignatura;
    String comments;
    Date initial_date;
    Date finish_date;

    public AsignaturaOutputDto(Asignatura asignatura) {
        if (asignatura == null) {
            return;
        }
        List<String> stringList = new ArrayList<>();
        for (Student p:
             asignatura.getStudent()) {
            stringList.add(p.getId_student());
        }
        this.setStudent(stringList);
        this.setId_asignatura(asignatura.getId_asignatura());
        this.setAsignatura(asignatura.getAsignatura());
        this.setComments(asignatura.getComments());
        this.setInitial_date(asignatura.getInitial_date());
        this.setFinish_date(asignatura.getFinish_date());
    }

}