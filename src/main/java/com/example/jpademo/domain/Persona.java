package com.example.jpademo.domain;


import com.example.jpademo.infraestructure.controller.dto.input.PersonaInputDto;
import lombok.*;




import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Email;



import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_persona;

    @Length(min = 6,max = 10, message = "The field must be at least 6 characters and at less 50")
    String user;
    @Column(nullable = false)
    String password;
    @Column(nullable = false)
    String name;

    String surname;

    @Column(nullable = false)
    @Email(message = "No valido")
    String company_email;

    @Column(nullable = false)
    @Email(message = "No valido")
    String personal_email;
    @Column(nullable = false)
    String city;
    @Column(nullable = false)
    Boolean active;
    @Column(nullable = false)
    Date create_date;
    String imagen_url;
    Date termination_date;

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
