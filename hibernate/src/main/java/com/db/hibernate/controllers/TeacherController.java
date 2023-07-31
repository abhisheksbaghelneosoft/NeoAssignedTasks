package com.db.hibernate.controllers;

import com.db.hibernate.beans.Teacher;
import com.db.hibernate.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/get-all")
    public List<Teacher> findAll()
    {
        return teacherService.findAll();
    }

    @PostMapping("/save")
    public Teacher save(@RequestBody Teacher teacher)
    {
        return teacherService.save(teacher);
    }

    @GetMapping("/get/{id}")
    public Teacher findByID(@PathVariable int id)
    {
        return teacherService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable int id)
    {
        return teacherService.deleteById(id);
    }
}
