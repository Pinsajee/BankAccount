<%-- 
    Document   : History
    Created on : Oct 26, 2018, 12:52:09 PM
    Author     : Student
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History</title>
    </head>
    <body>
        <h1>History Page</h1>
        
        <table>
            <tr>
                <td>#</td>>
                <td>Account ID</td>
                <td>Method</td>
                <td>Amount</td>
                <td>Create Date</td>
                <td>Balance</td>
                
            </tr>
            
            <c:forEach var="v" varStatus="vs" items="${his}">
                <tr>
                    <td>${vs.count}</td>
                    <td>${v.accountid.accountid}</td>
                    <td>${v.method}</td>
                    <td>${v.amount}</td>
                    <td>${v.createdate}</td>
                    <td>${v.balance}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
