package com.library.service;

import java.util.List;

import com.library.model.Student;

public interface StudentService 
{
    public void addStudent(Student student);
    public void removeStudent(Student student);
    public void editStudent(Student oldInfo, Student newInfo);

    public List<Student> getAllStudent();

    public List<Student> searchStudent(String keyword);

}
