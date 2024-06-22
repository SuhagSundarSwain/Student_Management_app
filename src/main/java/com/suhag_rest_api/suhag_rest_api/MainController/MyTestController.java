package com.suhag_rest_api.suhag_rest_api.MainController;

import org.springframework.web.bind.annotation.RestController;

import com.suhag_rest_api.suhag_rest_api.Entities.Student;
import com.suhag_rest_api.suhag_rest_api.Repository.StudentRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//this is only for practice purpose
@RestController
public class MyTestController {
    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/findByEmail/{email}")
    public ResponseEntity<Student> getMethodName(@PathVariable("email") String email) {
        try {
            return ResponseEntity.of(Optional.of(studentRepository.findByEmail(email)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

}
