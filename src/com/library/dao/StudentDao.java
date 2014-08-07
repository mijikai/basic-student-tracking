package com.library.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

import com.library.model.Student;

public class StudentDao
{
    private final File STUDENT_FILE = new File("D:/student.txt");

    public StudentDao()
    {
        try {
            if(!STUDENT_FILE.exists()) {
                STUDENT_FILE.createNewFile();
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public void insertStudent(Student student)
    {
        try {
            FileWriter writer = new FileWriter(STUDENT_FILE, true);
            writer.write(student.getStudentNo());
            writer.write(";");
            writer.write(student.getLastname());
            writer.write(";");
            writer.write(student.getFirstname());
            writer.write(";");
            writer.write(student.getCourse());
            writer.write("\n");
            writer.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }

    }

    public void deleteStudent(Student student)
    {
        try {
            List<Student> arr = getAllStudent();
            FileWriter writer = new FileWriter(STUDENT_FILE);
            for(Student elem : arr) {
                if(!elem.equals(student)) {
                    writer.write(elem.getStudentNo());
                    writer.write(";");
                    writer.write(elem.getLastname());
                    writer.write(";");
                    writer.write(elem.getFirstname());
                    writer.write(";");
                    writer.write(elem.getCourse());
                    writer.write("\n");
                }
            }
            writer.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public void updateStudent(Student student, Student newValue)
    {
        List<Student> all = getAllStudent();
        int index = all.indexOf(student);
        if(index == -1) {
            return;
        }

        try {
            all.set(index, newValue);
            FileWriter writer = new FileWriter(STUDENT_FILE);
            for(Student elem : all) {
                writer.write(elem.getStudentNo());
                writer.write(";");
                writer.write(elem.getLastname());
                writer.write(";");
                writer.write(elem.getFirstname());
                writer.write(";");
                writer.write(elem.getCourse());
                writer.write("\n");
            }
            writer.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    //filterStudent() - search for student

    public List<Student> filterStudent(String keyword)
    {
        List<Student> all = getAllStudent();
        List<Student> result = new ArrayList<Student>();
        keyword = keyword.toLowerCase();
        for(Student elem : all) {
            if(elem.getStudentNo().toLowerCase().contains(keyword) ||
                    elem.getFirstname().toLowerCase().contains(keyword) ||
                    elem.getLastname().toLowerCase().contains(keyword) ||
                    elem.getCourse().toLowerCase().contains(keyword)) {
                result.add(elem);
            }
        }
        return result;
    }

    public List<Student> getAllStudent()
    {
        String studentArr[];
        List<Student> studentList = new ArrayList<Student>();

        try {

            LineNumberReader lnr = new LineNumberReader(new FileReader(STUDENT_FILE));

            for(String studentData = lnr.readLine(); studentData!=null;studentData = lnr.readLine()){

                studentArr = studentData.split(";");
                if(studentArr.length < 4) {
                    continue;
                }

                Student student = new Student();

                student.setStudentNo(studentArr[0]);
                student.setLastname(studentArr[1]);
                student.setFirstname(studentArr[2]);
                student.setCourse(studentArr[3]);

                studentList.add(student);
            }

            lnr.close();

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        }

        return studentList;
    }
}
