package com.example.jpademo.infraestructure.repository;

import com.example.jpademo.domain.Profesor;
import com.example.jpademo.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, String> {

}