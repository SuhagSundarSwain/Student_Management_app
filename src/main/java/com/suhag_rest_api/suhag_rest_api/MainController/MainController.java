package com.suhag_rest_api.suhag_rest_api.MainController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.suhag_rest_api.suhag_rest_api.Services.StudentServices;
import com.suhag_rest_api.suhag_rest_api.StudentClass.Student;

// @Controller
// @ResponseBody
/* For RestApi Dev we can use @RestController at the place of @Controller */
@RestController
public class MainController {

    @Autowired
    StudentServices studentServices;

    //GET method RestAPI
    // @RequestMapping(value = "/student", method=RequestMethod.GET)
    /*@RequestMapping(method=RequestMethod.Get) == @GetMapping() */
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        /*Only for demo in One object; then I created fake services */
        // Student student = new Student();
        // student.setsId(441);
        // student.setsName("Suhag");
        // student.setsBranch("IT");
        // student.setsMark(9.01);
        


        //Jackson automatically conver object to JSON format
        // return student;
        return this.studentServices.getAllStudent();
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable("id") int Id){
        return this.studentServices.getStudentById(Id);
    }


    //POST method RestAPI
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        return this.studentServices.addStudent(student);
    }

    //DELETE method RestAPI
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable("id") int Id){
       this.studentServices.deleteStudent(Id);
    }

    //PUT method RestAPI
    @PutMapping("/students/{id}")
    public Student updateDetails(@PathVariable("id") int Id,@RequestBody Student student){
        this.studentServices.updateStudent(Id, student);
        return student;
    }
    
}
