package com.nilam.spring.boot.crud.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nilam.spring.boot.crud.rest.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	List<Student> findByCity(String city);

}
