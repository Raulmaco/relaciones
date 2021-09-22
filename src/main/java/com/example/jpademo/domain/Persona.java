package com.example.jpademo.domain;


import com.example.jpademo.infraestructure.controller.dto.input.PersonaInputDto;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id_persona;

    @Column
    public String user;
    public String password;
    public String name;
    public String surname;
    public String company_email;
    public String personal_email;
    public String city;
    public Boolean active;
    public Date create_date;
    public String imagen_url;
    public Date termination_date;

    public Persona() {

    }

    public Persona(PersonaInputDto personaInputDto) {
        this.user = personaInputDto.user;
        this.password = personaInputDto.password;
        this.name = personaInputDto.name;
        this.surname = personaInputDto.surname;
        this.company_email = personaInputDto.company_email;
        this.personal_email = personaInputDto.personal_email;
        this.city = personaInputDto.city;
        this.active = personaInputDto.active;
        this.create_date  = personaInputDto.create_date;
        this.imagen_url = personaInputDto.imagen_url;
        this.termination_date = personaInputDto.termination_date;

    }
}
