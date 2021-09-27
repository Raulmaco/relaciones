package com.example.jpademo.infraestructure.controller.dto.input;

import com.example.jpademo.domain.Persona;
import com.example.jpademo.domain.Student;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProfesorInputDto {

    Integer id_persona;

    String comments;

    @NotNull
    String branch;


}
