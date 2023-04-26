package com.example.SpringBootTestDemo.service;

import com.example.SpringBootTestDemo.entity.Student;
import com.example.SpringBootTestDemo.exceptions.StudentNotFoundException;
import com.example.SpringBootTestDemo.repository.Studentrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class StudentServiceImpl implements StudentService{
    @Autowired
    private Studentrepo studentrepo;

    @Override
    public Student addStudent(Student student) {
        return studentrepo.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentrepo.findAll();
    }

    @Override
    public Student getStudentById(Integer id) {
        Optional<Student> student=studentrepo.findById(id);
        if(!student.isPresent()){
            throw new StudentNotFoundException("student wit id :"+id +"doesn't exist");

        }
        return student.get();
    }

    @Override
    public Student deleteStudentById(Integer id) {
        Optional<Student> student=studentrepo.findById(id);
        if(!student.isPresent()){
            throw new StudentNotFoundException("student wit id :"+id +"doesn't exist");

        }
        studentrepo.delete(student.get());
        return null;
    }

    @Override
    public List<Student> getStudentByName(String name) {
        return studentrepo.findByName(name);
    }
}
