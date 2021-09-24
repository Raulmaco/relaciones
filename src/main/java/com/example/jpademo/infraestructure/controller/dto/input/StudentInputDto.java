package com.example.jpademo.infraestructure.controller.dto.input;

import com.example.jpademo.domain.Persona;
import com.example.jpademo.domain.Profesor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class StudentInputDto {
    public Persona persona;

    @NotNull
    public Integer num_hours_week;

    public String comments;

    public Profesor profesor;

    @NotNull
    public String branch;

}
