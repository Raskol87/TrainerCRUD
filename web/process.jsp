<%-- 
    Document   : process
    Created on : Mar 15, 2020, 9:07:15 PM
    Author     : kyrik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>process</title>
    </head>
    <body>
        <h5>Trainer Name already exists.<br> Do you want to create duplicate or proceed to update of trainers</h5>
        
        <form action="control" method="POST">
            
            <input type="radio" id="yes" name="action" value="forcecreate">
            Yes, create duplicate <br>
            <input type="radio" id="no" name="action" value="loadupdate">
            No, proceed to update page <br>
            <input type="submit">
        </form>
        
    </body>
</html>
