<%--
  Created by IntelliJ IDEA.
  User: lottehpt
  Date: 10/29/2021
  Time: 1:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Customer Manager</title>
</head>
<body>
<div align="center">
    <h2>Customer Manager</h2>
    <form method="get" action="search">
        <input type="text" name="keyword" /> &nbsp;
        <input type="submit" value="Search" />
    </form>
    <h3><a href="/new">New Customer</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>E-mail</th>
            <th>Address</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${listCustomer}" var="customer">
            <tr>
                <td>${customer.id}</td>
                <td>${customer.name}</td>
                <td>${customer.email}</td>
                <td>${customer.address}</td>
                <td>
                    <a href="/edit?id=${customer.id}">Edit</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="/delete?id=${customer.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
