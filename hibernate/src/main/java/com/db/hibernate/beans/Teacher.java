package com.db.hibernate.beans;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Teacher_Record")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int teacherId;
    String teacherName;
    String subjects;

    @ManyToMany(mappedBy = "assignedTeachers")
    Set<Student> assignedStudents;
}
