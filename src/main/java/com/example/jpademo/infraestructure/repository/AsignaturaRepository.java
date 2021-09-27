package com.example.jpademo.infraestructure.repository;

import com.example.jpademo.domain.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignaturaRepository extends JpaRepository<Asignatura, String> {
}
