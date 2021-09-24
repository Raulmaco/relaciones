package com.example.jpademo.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name="estudiante_asignatura")
public class estudiante_asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id_asignatura;

  /*  @ManyToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "ID_Student")
    Student student;*/

    @Column
    String asingatura;

    @Column
    String comments;

    @Column(nullable = false)
    Date initial_date;

    @Column
    Date finish_date;

    public estudiante_asignatura() {

    }

}