package com.example.jpademo.domain;


import com.example.jpademo.infraestructure.controller.dto.input.StudentInputDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id_student;

    @OneToOne()
    @JoinColumn(name = "ID_Persona")
    Persona persona;

    @Column()
    Integer num_hours_week;

    @Column
    String comments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Profesor")
    Profesor profesor;

    @Column()
    String branch;



   public Student(StudentInputDto studentInputDto, Persona persona, Profesor profesor) {
        setStudent(studentInputDto, persona, profesor);

    }

    public void setStudent(StudentInputDto studentInputDto, Persona persona, Profesor profesor){
        if (studentInputDto==null)
            return;
        if (studentInputDto.getId_persona()!=null)              this.persona = persona;
        if (studentInputDto.getNum_hours_week()!=null)          this.num_hours_week = studentInputDto.num_hours_week;
        if (studentInputDto.getComments()!=null)              this.comments = studentInputDto.comments;
        if (studentInputDto.getId_profesor()!=null)           this.profesor = profesor;
        if (studentInputDto.getBranch()!=null)     this.branch = studentInputDto.branch;
    }
}
