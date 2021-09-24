package com.example.jpademo.infraestructure.controller.dto.output;

import com.example.jpademo.application.PersonaService;
import com.example.jpademo.domain.Persona;
import com.example.jpademo.domain.Student;
import com.example.jpademo.infraestructure.controller.estudiante.StudentMostrarController;
import lombok.*;

import java.util.Date;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentPersonaOutputDto extends StudentOutputDto{

    private int id_persona;
    private String user;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private Boolean active;
    private Date create_date;
    private String imagen_url;
    private Date termination_date;



    public StudentPersonaOutputDto(Student student) {
        super(student);
        if (student == null) {
            return;
        }
        Persona p = student.getPersona();

        setId_student(student.getId_student());
        setComments(student.getComments());
        setNum_hours_week(student.getNum_hours_week());
        setBranch(student.getBranch());

        setId_persona(p.getId_persona());
        setName(p.getName());
        setUser(p.getUser());
        setPassword(p.getPassword());
        setSurname(p.getSurname());
        setCompany_email(p.getCompany_email());
        setPersonal_email(p.getPersonal_email());
        setCity(p.getCity());
        setActive(p.getActive());
        setCreate_date(p.getCreate_date());
        setImagen_url(p.getImagen_url());
        setTermination_date(p.getTermination_date());
    }


}
