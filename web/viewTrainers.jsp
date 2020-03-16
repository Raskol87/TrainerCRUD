<%-- 
    Document   : viewTrainers
    Created on : Mar 15, 2020, 9:45:55 PM
    Author     : kyrik
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Trainers</title>
    </head>
    <body>
        <%@include file="index.html" %>
        <jsp:useBean id="TrainerList" type="java.util.List<entities.Trainer>" scope="request" />
        <br> <br>
        <table>
            <thead>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Teaching Subject</th>
                </tr>
            </thead>
            <c:forEach var="currentTrainer" items="${TrainerList}" >
                <tr>
                    <td>${currentTrainer.firstName}</td>
                    <td>${currentTrainer.lastName}</td>
                    <td>${currentTrainer.subject}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
