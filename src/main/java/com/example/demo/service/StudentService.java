package com.example.demo.service;

import com.example.demo.Dao.StudentDao;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    private StudentDao studentDao;
    @Autowired
    public StudentService(@Qualifier("fakeStudentDao") StudentDao studentDao){
        this.studentDao = studentDao;
    }
    public List<Student> getAllStudent(){
        return studentDao.selectAllStudent();
    }

    public int addStudent(Student student){
        return studentDao.insertStudent(student);
    }

    public int updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }
    public int deletedStudent(UUID id){
        return studentDao.deleteStudent(id);
    }
}
