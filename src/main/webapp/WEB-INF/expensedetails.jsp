<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Expense Details</title>
</head>
<body>
    <h1>Expense Details</h1>
    <p><strong>Name:</strong> <c:out value = "${oneExpense.name}"/></p>
    <p><strong>Vendor:</strong> <c:out value = "${oneEexpense.vendor}"/> </p>
    <p><strong>Amount:</strong> <c:out value = "${oneExpense.amount}"/></p>
    <p><strong>Description:</strong> <c:out value = "${oneExpense.description}"/></p>
    <a href="/expenses/edit/${oneExpense.id}">Edit</a>
       <form action="/expenses/delete/${oneExpense.id}" method="post">
         	<input type="hidden" name="_method" value="delete">
            <input type="submit" value="Delete">
       </form>
    <a href="/expenses">Back to List</a>
</body>
</html>
