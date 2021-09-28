package com.example.jpademo.infraestructure.controller.dto.input;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ProfesorInputDto {

    @NotNull
    Integer id_persona;

    String comments;

    @NotNull
    String branch;


}
