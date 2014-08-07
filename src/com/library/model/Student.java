package com.library.model;

public class Student {

    private String studentNo = "";
    private String lastname = "";
    private String firstname = "";
    private String course = "";

    public Student()
    {
        super();
    }

    public Student(String studentNo, String lastname, String firstname, String course) 
    {
        super();
        this.studentNo = studentNo;
        this.lastname = lastname;
        this.firstname = firstname;
        this.course = course;
    }

    public String getStudentNo()
    {
        return studentNo;
    }

    public void setStudentNo(String studentNo)
    {
        this.studentNo = studentNo;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname) 
    {
        this.firstname = firstname;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course)
    {
        this.course = course;
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof Student) {
            Student other = (Student)obj;
            return this.studentNo.equalsIgnoreCase(other.studentNo) &&
                    this.firstname.equalsIgnoreCase(other.firstname) &&
                    this.lastname.equalsIgnoreCase(other.lastname) &&
                    this.course.equalsIgnoreCase(other.course);
        }
        return false;
    }
}
