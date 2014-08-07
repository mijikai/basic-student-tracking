package com.library.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.model.Student;
import com.library.serviceimpl.StudentServiceImpl;


public class DisplayStudentServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession(true);
        if(session.getAttribute("login") == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        StudentServiceImpl studentserviceimpl = new StudentServiceImpl();

        List<Student> studentList = studentserviceimpl.getAllStudent();

        session.setAttribute("studentList", studentList);

        request.getRequestDispatcher("studentlist.jsp").forward(request, response);
    }

}
