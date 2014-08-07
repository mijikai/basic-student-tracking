<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.library.model.Student" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title> Login </title>
        <link rel="stylesheet" type="text/css" href="style.css"/>
    </head>
    <body>
        <div id="wrap">

            <div id="header">
                <h1> <a href="home.jsp"> Student Information </a> </h1>
            </div>

            <div id="menu">  </div>

            <div id="content">
                <h2> About </h2>
                <form action="${pageContext.request.contextPath}/AuthenticateServlet" method="post" id="general-form">
                    <fieldset>
                        <legend> Login </legend>
                        <ol>
                            <li> <label for="username"> Username: </label>
                                <input type="text" id="username" name="username"/> </li>
                            <li> <label for="password"> Password: </label>
                                <input type="password" id="password" name="password"/> </li>
                        </ol>
                    </fieldset>
                    <input type="submit" value="login"/>
                </form>
        <j:choose>
            <j:when test="${requestScope.error}">
                <div style="clear: both"></div>
                <p class="error"> Invalid username or password </p>
            </j:when>
        </j:choose>
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
