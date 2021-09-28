package com.example.jpademo.infraestructure.controller.dto.input;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class StudentInputDto {

    @NotNull
    public Integer id_persona;

    @NotNull
    public Integer num_hours_week;

    public String comments;

    public String id_profesor;

    public List<String> asignaturas;

    @NotNull
    public String branch;

}
