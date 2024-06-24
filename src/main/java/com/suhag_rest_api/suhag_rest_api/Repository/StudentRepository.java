package com.suhag_rest_api.suhag_rest_api.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.suhag_rest_api.suhag_rest_api.Entities.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    public Student findById(int id);

    @Query("select s from Student s where s.email=:e")
    public Student findByEmail(@Param("e") String email);

}
