<%-- 
    Document   : deleteTrainers
    Created on : Mar 15, 2020, 11:43:17 PM
    Author     : kyrik
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Trainers</title>
    </head>
    <body>
        <%@include file="index.html" %> 
        <jsp:useBean id="TrainerList" type="java.util.List<entities.Trainer>" scope="request" /><br> <br>

        <table>
            <thead>
                <tr>
                    <th>Check for Delete</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Teaching Subject</th>
                </tr>
            </thead>
            <form action="control" method="POST">
                <input type="text" hidden="true" name="action" value="delete"/>
                <c:forEach var="currentTrainer" items="${TrainerList}" >
                    <tr>
                        <td> <input type="checkbox" name="idToBeDel" value="${currentTrainer.idTrainer}"/></td>
                        <td>${currentTrainer.firstName}</td>
                        <td>${currentTrainer.lastName}</td>
                        <td>${currentTrainer.subject}</td>
                    </tr>
                </c:forEach>
                <input type="submit"/>
            </form> 

        </table>

    </body>
</html>
