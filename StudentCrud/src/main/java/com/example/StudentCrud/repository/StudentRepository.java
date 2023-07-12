package com.example.StudentCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StudentCrud.domain.Student;
public interface StudentRepository extends JpaRepository<Student, Long> {

}
