package com.example.jpademo.domain;

import com.example.jpademo.infraestructure.controller.dto.input.AsignaturaInputDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="asignatura")
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id_asignatura;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_Student")
    List<Student> student;

    @Column
    String asignatura;

    @Column
    String comments;

    @Column(nullable = false)
    Date initial_date;

    @Column
    Date finish_date;

    public Asignatura(AsignaturaInputDto asignaturaInputDto, List<Student> studentList) {
        setAsignatura(asignaturaInputDto, studentList);

    }

    public void setAsignatura(AsignaturaInputDto asignaturaInputDto, List<Student> student){
        if (asignaturaInputDto==null)
            return;
        if (asignaturaInputDto.getId_student()!=null)              this.student = student;
        if (asignaturaInputDto.getAsignatura()!=null)          this.asignatura = asignaturaInputDto.getAsignatura();
        if (asignaturaInputDto.getComments()!=null)              this.comments = asignaturaInputDto.getComments();
        if (asignaturaInputDto.getInitial_date()!=null)           this.initial_date = asignaturaInputDto.getInitial_date();
        if (asignaturaInputDto.getFinish_date()!=null)     this.finish_date = asignaturaInputDto.getFinish_date();
    }

}