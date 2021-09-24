package com.example.jpademo.application.port;

import com.example.jpademo.infraestructure.controller.dto.input.StudentInputDto;
import com.example.jpademo.infraestructure.controller.dto.output.StudentOutputDto;

public interface StudentServiceInterface {
    public StudentOutputDto añadirDto (StudentInputDto studentInputDto);
}
