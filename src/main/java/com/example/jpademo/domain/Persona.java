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

    @OneToOne()
    @JoinColumn(name = "id_profesor")
    Profesor profesor;

    @OneToOne()
    @JoinColumn(name = "id_student")
    Student student;

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
        setPersona(personaInputDto);

    }

    public void setPersona(PersonaInputDto personaInputDto){
        if (personaInputDto==null)
            return;
        if (personaInputDto.user!=null)              this.user = personaInputDto.user;
        if (personaInputDto.password!=null)          this.password = personaInputDto.password;
        if (personaInputDto.name!=null)              this.name = personaInputDto.name;
        if (personaInputDto.surname!=null)           this.surname = personaInputDto.surname;
        if (personaInputDto.company_email!=null)     this.company_email = personaInputDto.company_email;
        if (personaInputDto.personal_email!=null)    this.personal_email = personaInputDto.personal_email;
        if (personaInputDto.city!=null)              this.city = personaInputDto.city;
        if (personaInputDto.active!=null)            this.active = personaInputDto.active;
        if (personaInputDto.create_date!=null)       this.create_date  = personaInputDto.create_date;
        if (personaInputDto.imagen_url!=null)        this.imagen_url = personaInputDto.imagen_url;
        if (personaInputDto.termination_date!=null)  this.termination_date = personaInputDto.termination_date;
    }
}
