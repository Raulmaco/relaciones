package com.example.jpademo.infraestructure.controller.dto.input;

import jdk.jfr.DataAmount;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

@Data
public class PersonaInputDto {
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
}
