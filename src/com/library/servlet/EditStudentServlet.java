package com.library.servlet;

import java.io.IOException;

import java.util.Enumeration;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.serviceimpl.StudentServiceImpl;

import com.library.model.Student;

public class EditStudentServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        if(req.getParameter("edit") != null) {
            Enumeration<String> paramNames = req.getParameterNames();
            String paramName;
            while(paramNames.hasMoreElements()) {
                paramName = paramNames.nextElement();
                req.setAttribute(paramName, req.getParameter(paramName));
            }
            req.getRequestDispatcher("editStudent.jsp").forward(req, resp);
        } else if(req.getParameter("delete") != null) {
            Student student = new Student();
            student.setStudentNo(req.getParameter("studentNo"));
            student.setFirstname(req.getParameter("firstname"));
            student.setLastname(req.getParameter("lastname"));
            student.setCourse(req.getParameter("course"));
            StudentServiceImpl impl = new StudentServiceImpl();
            impl.removeStudent(student);
            resp.sendRedirect("DisplayStudentServlet");
        } else if(req.getParameter("update") != null) {
            Student oldValue = new Student();
            oldValue.setStudentNo(req.getParameter("oldStudentNo"));
            oldValue.setFirstname(req.getParameter("oldFirstname"));
            oldValue.setLastname(req.getParameter("oldLastname"));
            oldValue.setCourse(req.getParameter("oldCourse"));
            Student newValue = new Student();
            newValue.setStudentNo(req.getParameter("newStudentNo"));
            newValue.setFirstname(req.getParameter("newFirstname"));
            newValue.setLastname(req.getParameter("newLastname"));
            newValue.setCourse(req.getParameter("newCourse"));
            StudentServiceImpl impl = new StudentServiceImpl();
            impl.editStudent(oldValue, newValue);
            resp.sendRedirect("DisplayStudentServlet");
        }
    }

}
