package com.suhag_rest_api.suhag_rest_api.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suhag_rest_api.suhag_rest_api.Entities.LoginUser;
import com.suhag_rest_api.suhag_rest_api.Entities.SignUpStudent;
import com.suhag_rest_api.suhag_rest_api.Entities.Student;
import com.suhag_rest_api.suhag_rest_api.Repository.LoginRepository;
import com.suhag_rest_api.suhag_rest_api.Repository.StudentRepository;

@Service
// @Component

// any one can be used from @Service or @Component
//fake Services like DB
public class StudentServices {
    
    // public static List<Student> list = new ArrayList<>();

    // static{
    //     list.add(new Student(1,"Suhag","IT",9.04));
    //     list.add(new Student(2,"Priyanka","I&E",9.34));
    //     list.add(new Student(3,"Chiranjib","CSE",7.04));
    //     list.add(new Student(4,"Papun","CSE",8.4));
    //     list.add(new Student(5,"Happy","CS",5));
    // }
    
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    LoginRepository loginRepositry;

    public List<Student> getAllStudent(){
        // return list;
        var list = (List<Student>) this.studentRepository.findAll();
        return list;
    }

    public Student getStudentById(int id){
        // return list.stream().filter(e->e.getsId()==id).findFirst().get();
        return this.studentRepository.findById(id);
    }

    public Student addStudent(SignUpStudent signUpStudent){
        // list.add(student);
        // return student;
        Student newStudent = new Student();
        newStudent.setsId(signUpStudent.getsId());
        newStudent.setEmail(signUpStudent.getsEmail());
        newStudent.setsName(signUpStudent.getsName());
        newStudent.setsBranch(signUpStudent.getsBranch());
        newStudent.setGender(signUpStudent.getsGender());
        newStudent.setsMark(signUpStudent.getsMark());
    
        LoginUser login = new LoginUser();
        login.setSid(signUpStudent.getsId());
        login.setEmail(signUpStudent.getsEmail());
        login.setPassword(signUpStudent.getPassword());

    
        this.studentRepository.save(newStudent);
        this.loginRepositry.save(login);
     
        return newStudent;
    }

    public void deleteStudent(int id){
        // list = list.stream().filter(e->e.getsId()!=id).collect(Collectors.toList());
        this.studentRepository.deleteById(id);
    }

    public void updateStudent(int Id, Student student){
        // list = list.stream().map(s->{
        //     if(s.getsId()==Id){
        //         s.setsName(student.getsName());
        //         s.setsBranch(student.getsBranch());
        //         s.setsMark(student.getsMark());
        //     }
        //     return s;
        // }).collect(Collectors.toList());
        student.setsId(Id);
        this.studentRepository.save(student);
    }

    public LoginUser loginStudent(String email,String sEmail,String password){
        LoginUser user = loginRepositry.findByEmail(email);
        if(user.getPassword()==password){
            return user;
        }
        else{
            return new LoginUser();
        }
    }
}
