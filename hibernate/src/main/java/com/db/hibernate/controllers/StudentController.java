package com.db.hibernate.controllers;

import com.db.hibernate.beans.Student;
import com.db.hibernate.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/get-all")
    public List<Student> findAll()
    {
        return studentService.findAll();
    }

    @PostMapping("/save")
    public Student save(@RequestBody Student student)
    {
        return studentService.save(student);
    }

    @GetMapping("/get/{id}")
    public Student findByID(@PathVariable int id)
    {
        return studentService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable int id)
    {
        return studentService.deleteById(id);
    }
}
