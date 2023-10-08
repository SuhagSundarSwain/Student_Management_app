package com.suhag_rest_api.suhag_rest_api.Repository;

import org.springframework.data.repository.CrudRepository;

import com.suhag_rest_api.suhag_rest_api.Entities.Student;

public interface StudentRepository extends CrudRepository<Student,Integer>  {

    public Student findById(int id);
    
}
