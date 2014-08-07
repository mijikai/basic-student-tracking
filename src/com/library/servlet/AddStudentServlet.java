package com.library.servlet;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.model.Student;

import com.library.serviceimpl.StudentServiceImpl;

public class AddStudentServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Student student = new Student();
        student.setStudentNo(req.getParameter("studentNo"));
        student.setFirstname(req.getParameter("firstname"));
        student.setLastname(req.getParameter("lastname"));
        student.setCourse(req.getParameter("course"));
        StudentServiceImpl impl = new StudentServiceImpl();
        impl.addStudent(student);
        resp.sendRedirect("DisplayStudentServlet");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        HttpSession session = req.getSession(true);
        if(session.getAttribute("login") == null) {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            return;
        }
        req.getRequestDispatcher("addStudent.jsp").forward(req, resp);
    }
}
