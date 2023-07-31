package com.db.hibernate.services.serviceImpl;

import com.db.hibernate.beans.Student;
import com.db.hibernate.repositories.StudentRepo;
import com.db.hibernate.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Student findById(int id) {
        return studentRepo.findById(id).get();
    }

    @Override
    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    @Override
    public String deleteById(int id) {
        String name=studentRepo.findById(id).get().getStudentName();
        studentRepo.deleteById(id);
        return "Deleted Student "+name+" with Id "+id;
    }

    @Override
    public Student save(Student student) {
        return studentRepo.save(student);
    }
}
