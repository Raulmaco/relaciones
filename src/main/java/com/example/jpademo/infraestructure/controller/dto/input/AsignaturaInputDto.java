package com.example.jpademo.infraestructure.controller.dto.input;

import com.example.jpademo.domain.Student;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
public class AsignaturaInputDto {

    List<String> id_student;
    String asignatura;
    String comments;
    @NotNull
    Date initial_date;
    Date finish_date;


}
