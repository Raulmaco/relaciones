package com.example.jpademo.domain;


import com.example.jpademo.infraestructure.controller.dto.input.PersonaInputDto;
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

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "ID_Persona")
    Persona persona;

    @Column
    String comments;

    @Column(nullable = false)
    String branch;

 /*   @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL)
    List<Student> studentList = new ArrayList<>();*/


    public Profesor() {

    }
/*
    public Student(PersonaInputDto personaInputDto) {
        setPersona(personaInputDto);

    }*/

}
