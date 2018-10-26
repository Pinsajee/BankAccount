<%-- 
    Document   : Withdraw
    Created on : Oct 26, 2018, 12:51:47 PM
    Author     : Student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Withdraw Page</title>
    </head>
    <body>
        ${sessionScope.user.balance}
       <h1>Withdraw Page</h1>
        <form action="Withdraw" method="post">
            <input type="number" name="withdraw">
            <input type="submit" value="withdraw">
        </form>
    </body>
</html>
