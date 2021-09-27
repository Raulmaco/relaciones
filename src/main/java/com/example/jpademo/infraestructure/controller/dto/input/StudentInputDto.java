package com.example.jpademo.infraestructure.controller.dto.input;

import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class StudentInputDto {
    public Integer id_persona;

    @NotNull
    public Integer num_hours_week;

    public String comments;

    public String id_profesor;

    @NotNull
    public String branch;

}
