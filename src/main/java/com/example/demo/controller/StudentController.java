package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/student")
public class StudentController {
    private StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @GetMapping
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }
    @PostMapping
    public String addStudent(@RequestBody Student student){

        studentService.addStudent(student);
        return "student added.";
    }

    @PutMapping
    public String updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        return "student updated.";
    }
    @DeleteMapping(path = "{id}")
    public int deleteStudent(@PathVariable("id") UUID id){
        studentService.deletedStudent(id);
        return 1;
    }

}
