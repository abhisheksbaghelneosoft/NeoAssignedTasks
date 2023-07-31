package com.db.hibernate.services.serviceImpl;

import com.db.hibernate.beans.Teacher;
import com.db.hibernate.repositories.TeacherRepo;
import com.db.hibernate.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepo teacherRepo;

    @Override
    public Teacher findById(int id) {
        return teacherRepo.findById(id).get();
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepo.findAll();
    }

    @Override
    public String deleteById(int id) {
        String name=teacherRepo.findById(id).get().getTeacherName();
        teacherRepo.deleteById(id);
        return "Deleted Teacher "+name+" with Id "+id;
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepo.save(teacher);
    }
}
