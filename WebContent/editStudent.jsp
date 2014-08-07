<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.library.model.Student" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>Library System - Edit Information</title>
        <link rel="stylesheet" type="text/css" href="style.css"/>
    </head>
    <body>
        <div id="wrap">

            <div id="header">
                <h1> <a href="home.jsp"> Student Information </a> </h1>
            </div>

            <div id="menu">  </div>

            <div id="content">
                <h2> Update Information </h2>
                    <form action="${pageContext.request.contextPath}/EditStudentServlet" method="post" id="general-form">
                        <fieldset>
                            <legend> Basic Information </legend>
                            <ol>
                                <li> <label for="newStudentNo"> Student number: </label>
                                    <input type="text" value="${studentNo}" id="newStudentNo" name="newStudentNo"/> </li>
                                <li> <label for="newLastname"> Last name: </label>
                                    <input type="text" value="${lastname}" id="newLastname" name="newLastname"/> </li>
                                <li> <label for="newFirstname"> First name: </label>
                                    <input type="text" value="${firstname}" id="newFirstname" name="newFirstname"/> </li>
                                <li> <label for="newCourse"> Course: </label>
                                    <input type="text" value="${course}" id="newCourse" name="newCourse"/> </li>
                            </ol>
                        </fieldset>
                            <input type="hidden" value="${studentNo}" id="oldStudentNo" name="oldStudentNo"/>
                            <input type="hidden" value="${lastname}" id="oldLastname" name="oldLastname"/>
                            <input type="hidden" value="${firstname}" id="oldFirstname" name="oldFirstname"/>
                            <input type="hidden" value="${course}" id="oldCourse" name="oldCourse"/>
                            <input type="submit" value="Update" name="update"/>
                    </form>
            </div>

            <div id="sidebar">
                <h3> Navigation </h3>
                <ul>
                    <li> <a href="${pageContext.request.contextPath}/home.jsp"> Home </a> </li>
                    <li> <a href="${pageContext.request.contextPath}/DisplayStudentServlet">Student List</a> </li>
                    <li> <a href="${pageContext.request.contextPath}/AddStudentServlet">Add Student</a> </li>
            <j:choose>
                <j:when test="${sessionScope.login}">
                    <li> <a href="${pageContext.request.contextPath}/AuthenticateServlet"> Logout </a> </li>
                </j:when>
                <j:otherwise>
                    <li> <a href="${pageContext.request.contextPath}/login.jsp"> Login </a> </li>
                </j:otherwise>
            </j:choose>
                </ul>
            </div>

            <div style="clear: both;"></div>
            <div id="footer"> </div>

        </div>
    </body>
</html>
