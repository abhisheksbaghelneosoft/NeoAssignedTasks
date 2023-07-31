package com.db.hibernate.services;

import com.db.hibernate.beans.Student;

import java.util.List;

public interface StudentService {

    public Student findById(int id);

    public List<Student> findAll();

    public String deleteById(int id);

    public Student save(Student student);

}
