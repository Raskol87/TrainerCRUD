<%-- 
    Document   : updateTrainers
    Created on : Mar 15, 2020, 11:52:46 PM
    Author     : kyrik
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Trainers</title>
    </head>
    <body>
        <%@include file="index.html" %>
        <jsp:useBean id="TrainerList" type="java.util.List<entities.Trainer>" scope="request" />
        <br> <br>
        <table>
            <thead>
                <tr>
                    <th> </th>
                    <th>Check for Update</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Teaching Subject</th>
                </tr>
            </thead>
            <form action="control" method="POST">
                <input type="text" hidden="true" name="action" value="update"/>
                <c:forEach var="currentTrainer" items="${TrainerList}" >
                    <tr>
                        <td><input type="text" name="idTrainer" value="${currentTrainer.idTrainer}" hidden="true"/></td>
                        <td><input type="checkbox" name="idToBeUp" value="${currentTrainer.idTrainer}"/></td>                    
                        <td><input type="text" name="firstName" value="${currentTrainer.firstName}" /></td>
                        <td><input type="text" name="lastName" value="${currentTrainer.lastName}"/></td>
                        <td><input type="text" name="subject" value="${currentTrainer.subject}"/></td>
                    </tr>
                </c:forEach>
                <input type="submit"/>
            </form> 
        </table>
    </body>
</html>
