package com.suhag_rest_api.suhag_rest_api.MainController;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.suhag_rest_api.suhag_rest_api.Entities.ErrorResponse;
import com.suhag_rest_api.suhag_rest_api.Entities.LoginUser;
import com.suhag_rest_api.suhag_rest_api.Entities.Student;
import com.suhag_rest_api.suhag_rest_api.Services.StudentServices;

import jakarta.validation.Valid;

// @Controller
// @ResponseBody
/* For RestApi Dev we can use @RestController at the place of @Controller */
@RestController
public class APIController {

    @Autowired
    StudentServices studentServices;

    // GET method RestAPI
    // @RequestMapping(value = "/student", method=RequestMethod.GET)
    /* @RequestMapping(method=RequestMethod.Get) == @GetMapping() */
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        /* Only for demo in One object; then I created fake services */
        // Student student = new Studeznt();
        // student.setsId(441);
        // student.setsName("Suhag");
        // student.setsBranch("IT");
        // student.setsMark(9.01);

        // Jackson automatically conver object to JSON format
        // return student;
        // return this.studentServices.getAllStudent();

        try {
            var list = this.studentServices.getAllStudent();
            return ResponseEntity.of(Optional.of(list));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") int Id) {
        // return this.studentServices.getStudentById(Id);
        try {
            var student = this.studentServices.getStudentById(Id);
            return ResponseEntity.of(Optional.of(student));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    // POST method RestAPI
    @PostMapping("/students")
    public ResponseEntity<Object> addStudent(@Valid @RequestBody Student student, BindingResult result) {

        if (result.hasErrors()) {
            Map<String, String> errors = result.getFieldErrors().stream()
                    .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            ErrorResponse errorResponse = new ErrorResponse("Validation Error", errors);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }

        // return this.studentServices.addStudent(student);
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(this.studentServices.addStudent(student));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // DELETE method RestAPI
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") int Id) {
        try {
            this.studentServices.deleteStudent(Id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // PUT method RestAPI
    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateDetails(@PathVariable("id") int Id, @RequestBody Student student) {
        try {
            Student updatedStudent = this.studentServices.updateStudent(Id, student);
            return ResponseEntity.of(Optional.of(updatedStudent));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }

    @GetMapping("/login/{email}")
    public LoginUser login(@PathVariable("email") String email, @RequestBody String sEmail, String password) {
        return studentServices.loginStudent(email, sEmail, password);
    }

}
