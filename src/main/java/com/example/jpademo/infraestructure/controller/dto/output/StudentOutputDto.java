package com.example.jpademo.infraestructure.controller.dto.output;

import com.example.jpademo.domain.Asignatura;
import com.example.jpademo.domain.Student;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentOutputDto extends PersonaOutputDto{

   private String id_student;
   private int id_persona;
   private List<String> asignaturas;
   @NotNull
   private Integer num_hours_week;
   private String comments;
   private String id_profesor;
   @NotNull
   private String branch;

    public StudentOutputDto(Student student) {
        if (student == null) {
            return;
        }
        this.setId_student(student.getId_student());
        this.setId_persona(student.getPersona().getId_persona());
        List<String> asignaturasList = new ArrayList<>();
        if(student.getAsignaturas()!=null) {
            for (Asignatura a :
                    student.getAsignaturas()) {
                asignaturasList.add(a.getId_asignatura());
            }
        }
        this.setAsignaturas(asignaturasList);
        this.setNum_hours_week(student.getNum_hours_week());
        this.setBranch(student.getBranch());
        this.setComments(student.getComments());
        this.setId_profesor(student.getProfesor().getId_profesor());
    }
}
