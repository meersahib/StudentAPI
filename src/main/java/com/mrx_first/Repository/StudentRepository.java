package com.mrx_first.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrx_first.model.Student;

public interface StudentRepository extends JpaRepository<Student,  Long> {

}
