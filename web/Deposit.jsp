<%-- 
    Document   : Deposit
    Created on : Oct 26, 2018, 12:52:02 PM
    Author     : Student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Deposit Page</title>
    </head>
    <body>
        <h1>Deposit Page</h1>
        ${sessionScope.user.balance}
        <form action="Deposit" method="post">
            <input type="number" name="deposit">
            <input type="submit" value="deposit">
        </form>
    </body>
</html>
