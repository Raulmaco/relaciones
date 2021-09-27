package com.example.jpademo.domain;


import com.example.jpademo.infraestructure.controller.dto.input.ProfesorInputDto;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="profesor")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id_profesor;

    @OneToOne()
    @JoinColumn(name = "ID_Persona")
    Persona persona;

    @Column
    String comments;

    @Column(nullable = false)
    String branch;

    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL)
    List<Student> studentList = new ArrayList<>();


    public Profesor() {

    }
    public Profesor(ProfesorInputDto profesorInputDto, Persona persona) {
        setProfesor(profesorInputDto, persona);

    }

    public void setProfesor(ProfesorInputDto profesorInputDto, Persona persona){
        if (profesorInputDto==null)
            return;
        if (profesorInputDto.getId_persona()!=null)              this.persona = persona;
        if (profesorInputDto.getComments()!=null)              this.comments = profesorInputDto.getComments();
        if (profesorInputDto.getBranch()!=null)     this.branch = profesorInputDto.getBranch();
    }

}
