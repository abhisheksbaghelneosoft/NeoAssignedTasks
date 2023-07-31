package com.db.hibernate.services;

import com.db.hibernate.beans.Teacher;

import java.util.List;

public interface TeacherService {

    public Teacher findById(int id);

    public List<Teacher> findAll();

    public String deleteById(int id);

    public Teacher save(Teacher teacher);

}
