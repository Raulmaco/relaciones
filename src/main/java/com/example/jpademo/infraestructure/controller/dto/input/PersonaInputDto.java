package com.example.jpademo.infraestructure.controller.dto.input;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class PersonaInputDto {
    @Length(min = 6,max = 10, message = "The field must be at least 6 characters and at less 50")
    public String user;
    @NotNull
    public String password;
    @NotNull
    public String name;
    @NotNull
    public String surname;

    @NotNull
    @Email(message = "No valido")
    public  String company_email;

    @NotNull
    @Email(message = "No valido")
    public String personal_email;
    @NotNull
    public String city;
    @NotNull
    public Boolean active;
    @NotNull
    public Date create_date;
    public String imagen_url;
    public Date termination_date;
}
