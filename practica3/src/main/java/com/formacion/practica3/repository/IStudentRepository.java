package com.formacion.practica3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formacion.practica3.entity.Student;

@Repository
public interface IStudentRepository extends CrudRepository<Student, Integer>{

}
