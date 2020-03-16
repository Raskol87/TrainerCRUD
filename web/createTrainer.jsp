<%-- 
    Document   : createTrainer
    Created on : Mar 15, 2020, 5:57:08 PM
    Author     : kyrik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Trainer</title>
    </head>
    <body>
        
        <%@include file="index.html" %>
        
        <h4>Provide Trainer Data</h4>
        <br>
        <form  action="control" method="POST">
            <input type="text" hidden="true" name="action" value="create"/>
                   First Name : <input  type="text" name="firstName" /> <br>
            Last Name : <input type="text" name="lastName" /><br>
            Subject : <input type="text" name="subject" /><br>
            <input type="submit"/>

        </form>
        <jsp:useBean id="createTrainer" class="entities.Trainer" scope="session"/>

    </body>
</html>
