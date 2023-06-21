<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Expense List</title>
</head>
<body>
    <h1>Expense List</h1>
    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Vendor</th>
                <th>Amount</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="eachExpense" items="${expenseList}">
                <tr>
                    <td><c:out value="${eachExpense.name}"/> </td>
                    <td><c:out value="${eachExpense.vendor}"/> </td>
                    <td><c:out value="${eachExpense.amount}"/> </td>
                    <td>
                        <a href="/expenses/${eachExpense.id}">View</a>
                        <a href="/expenses/edit/${eachExpense.id}">Edit</a>
						<form action="/expenses/delete/${eachExpense.id}" method="post">
    						<input type="hidden" name="_method" value="delete">
    						<button type="submit" >Delete</button>
						</form>

                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="/expenses/create">Add Expense</a>
</body>
</html>
