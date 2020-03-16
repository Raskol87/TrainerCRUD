<%-- 
    Document   : createSuccess
    Created on : Mar 15, 2020, 9:35:39 PM
    Author     : kyrik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Succesful Create</title>
    </head>
    <body>
        <%@include file="index.html" %>

        <jsp:useBean id="createTrainer" class="entities.Trainer" scope="session"/>
        <h4>Trainer <jsp:getProperty name="createTrainer" property="firstName"/> 
            <jsp:getProperty name="createTrainer" property="lastName"/>, 
            teaching <jsp:getProperty name="createTrainer" property="subject"/> 
            succesfully created</h4>

    </body>
</html>
