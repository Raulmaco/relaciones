package com.example.jpademo.infraestructure.controller.dto.output;

import com.example.jpademo.domain.Persona;
import com.example.jpademo.domain.Profesor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorOutputDto extends PersonaOutputDto {

    private String id_profesor;
    private int id_persona;
    private String comments;
    @NotNull
    private String branch;

    public ProfesorOutputDto(Persona persona) {
        super(persona);
        if (persona == null) {
            return;
        }
        Profesor profesor = persona.getProfesor();
        this.setId_profesor(profesor.getId_profesor());
        this.setId_persona(profesor.getPersona().getId_persona());
        this.setBranch(profesor.getBranch());
        this.setComments(profesor.getComments());
    }

}
