<%-- 
    Document   : MyAccount
    Created on : Oct 26, 2018, 11:43:06 AM
    Author     : Student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Account Page</title>
    </head>
    <body>
        <h1>My Account</h1>
        ${sessionScope.user.name}
        ${sessionScope.user.balance}
        <a href="Deposit">Deposit</a>
        <a href="Withdraw">Withdraw</a>
        <a href="History">History</a>
        
        
        <a href="Logout">Logout</a>
        
    </body>
</html>
