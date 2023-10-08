package com.suhag_rest_api.suhag_rest_api.MainController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.suhag_rest_api.suhag_rest_api.Entities.LoginUser;
import com.suhag_rest_api.suhag_rest_api.Entities.SignUpStudent;
import com.suhag_rest_api.suhag_rest_api.Entities.Student;
import com.suhag_rest_api.suhag_rest_api.Services.StudentServices;

// @Controller
// @ResponseBody
/* For RestApi Dev we can use @RestController at the place of @Controller */
@RestController
public class APIController {

    @Autowired
    StudentServices studentServices;

    //GET method RestAPI
    // @RequestMapping(value = "/student", method=RequestMethod.GET)
    /*@RequestMapping(method=RequestMethod.Get) == @GetMapping() */
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        /*Only for demo in One object; then I created fake services */
        // Student student = new Student();
        // student.setsId(441);
        // student.setsName("Suhag");
        // student.setsBranch("IT");
        // student.setsMark(9.01);
        


        //Jackson automatically conver object to JSON format
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
    public ResponseEntity<Student> getStudent(@PathVariable("id") int Id){
        // return this.studentServices.getStudentById(Id);
        try {
            var student = this.studentServices.getStudentById(Id);
            return ResponseEntity.of(Optional.of(student));
        } catch (Exception e) {
          return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        

    
    }


    //POST method RestAPI
    @PostMapping("/students")
    public ResponseEntity<Void> addStudent(@RequestBody SignUpStudent signUpStudent){
        // return this.studentServices.addStudent(student);
        try {
            this.studentServices.addStudent(signUpStudent);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //DELETE method RestAPI
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") int Id){
       try {
        this.studentServices.deleteStudent(Id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
       } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
    }

    //PUT method RestAPI
    @PutMapping("/students/{id}")
    public Student updateDetails(@PathVariable("id") int Id,@RequestBody Student student){
        this.studentServices.updateStudent(Id, student);
        return student;
    }


    @GetMapping("/login/{email}")
    public LoginUser login(@PathVariable("email") String email,@RequestBody String sEmail,String password ){
        return studentServices.loginStudent(email, sEmail,password);
    }
    
}
