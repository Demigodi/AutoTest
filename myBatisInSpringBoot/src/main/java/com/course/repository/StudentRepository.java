package com.course.repository;

import com.course.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface StudentRepository {

    public List<Student> findAll();
    public Student findById(int id);
    public void save(Student student);
    public void update(Student student);
    public void deleteById(int id);
}
