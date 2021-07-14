package com.example.demo.Dao;

import com.example.demo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public class FakeStudentDao implements StudentDao{
    private static List<Student> Database = new ArrayList<>();

    @Override
    public int deleteStudent(UUID id) {
        Optional<Student> optionalStudent = selectStudentById(id);
        if(!optionalStudent.isPresent()) return -1;
        Database.remove((optionalStudent.get()));
        return 1;
    }

    @Override
    public int updateStudent(Student student) {
        Optional<Student> optionalStudent = selectStudentById(student.getId());
        if(!optionalStudent.isPresent()) return -1;
        int indexToUpdate = -1;
        for(int i=0;i<Database.size();i++){
            if(student.getId().equals(Database.get(i).getId())){
                indexToUpdate = i;
                break;
            }
        }
        Database.set(indexToUpdate,student);
        return 1;

    }

    @Override
    public List<Student> selectAllStudent() {
        return Database;
    }

    @Override
    public Optional<Student> selectStudentById(UUID id) {
        for(Student s: Database){
            if(s.getId().equals(id)){
                return Optional.of(s);
            }
        }
        return Optional.empty();
    }

    @Override
    public int insertStudent( Student student) {
        UUID id = UUID.randomUUID();
        Database.add(new Student(id,student.getName()));
        return 1;
    }
}
