<%-- 
    Document   : Login
    Created on : Oct 26, 2018, 11:40:16 AM
    Author     : Student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Login" method="post">
            ID: <input type="number" name = "accId" required><br><br>
            Pin: <input type="number" name = "accPin" required><br>
            <input type="submit" value= "submit">
            
            <br><br>
            
            ${message}
        </form>
    </body>
</html>
