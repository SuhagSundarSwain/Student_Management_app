package com.suhag_rest_api.suhag_rest_api.StudentRepository;

import org.springframework.data.repository.CrudRepository;

import com.suhag_rest_api.suhag_rest_api.StudentClass.Student;

public interface StudentRepository extends CrudRepository<Student,Integer>  {

    public Student findById(int id);
    
}
