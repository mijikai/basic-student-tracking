package com.library.serviceimpl;

import java.util.List;
import com.library.dao.StudentDao;
import com.library.model.Student;
import com.library.service.StudentService;

public class StudentServiceImpl implements StudentService {


    public void addStudent(Student student) 
    {
        StudentDao studentdao = new StudentDao();
        studentdao.insertStudent(student);
    }

    public void removeStudent(Student student)
    {
        StudentDao studentdao = new StudentDao();
        studentdao.deleteStudent(student);
    }

    public void editStudent(Student oldValue, Student newValue) 
    {
        StudentDao studentdao = new StudentDao();
        studentdao.updateStudent(oldValue, newValue);
    }

    public List<Student> getAllStudent()
    {

        StudentDao studentdao = new StudentDao();
        List<Student> studentList = studentdao.getAllStudent();

        return studentList;
    }

    public List<Student> searchStudent(String keyword)
    {

        StudentDao studentdao = new StudentDao();
        List<Student> studentList = studentdao.filterStudent(keyword);

        return studentList;
    }
}
