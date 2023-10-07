package com.suhag_rest_api.suhag_rest_api.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.suhag_rest_api.suhag_rest_api.StudentClass.Student;

@Service
// @Component

// any one can be used from @Service or @Component
//fake Services like DB
public class StudentServices {
    
    public static List<Student> list = new ArrayList<>();

    static{
        list.add(new Student(1,"Suhag","IT",9.04));
        list.add(new Student(2,"Priyanka","I&E",9.34));
        list.add(new Student(3,"Chiranjib","CSE",7.04));
        list.add(new Student(4,"Papun","CSE",8.4));
        list.add(new Student(5,"Happy","CS",5));
    }

    public List<Student> getAllStudent(){
        return list;
    }

    public Student getStudentById(int id){
        return list.stream().filter(e->e.getsId()==id).findFirst().get();
    }

    public Student addStudent(Student student){
        list.add(student);
        return student;
    }

    public void deleteStudent(int id){
        list = list.stream().filter(e->e.getsId()!=id).collect(Collectors.toList());
    }

    public void updateStudent(int Id, Student student){
        list = list.stream().map(s->{
            if(s.getsId()==Id){
                s.setsName(student.getsName());
                s.setsBranch(student.getsBranch());
                s.setsMark(student.getsMark());
            }
            return s;
        }).collect(Collectors.toList());
    }
}
