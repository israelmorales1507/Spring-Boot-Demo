package com.example.Codedemo.DAO;

import com.example.Codedemo.entity.Student;

import java.util.List;

public interface IStudentDAO {
    void save(Student student);
    Student findById(Integer id);
    List<Student> finAll();

    List<Student> finByLastName(String lastName);

    void update(Student student);
}
