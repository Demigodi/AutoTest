package com.source.repository;

import com.source.entity.Student;

import java.util.Collection;
import java.util.List;

public interface StudentRepository {

    public Collection<Student> findAll();
    public Student findById(long id);
    public void save(Student student);
    public void update(Student student);
    public void deleteById(long id);
}
