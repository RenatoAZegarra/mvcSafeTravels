<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <title>Create Expense</title>
</head>
<body>
    <h1>Create Expense</h1>
    <form:form action="/expenses/create" method="post" modelAttribute="newExpense">
        <form:label path="name">Name:</form:label>
        <form:input path="name" />
        <form:errors path="name" /><br>

        <form:label path="vendor">Vendor:</form:label>
        <form:input path="vendor" />
        <form:errors path="vendor" /><br>

        <form:label path="amount">Amount:</form:label>
        <form:input path="amount" type="number" />
        <form:errors path="amount" /><br>

        <form:label path="description">Description:</form:label>
        <form:textarea path="description" />
        <form:errors path="description" /><br>

        <button type="submit">Create</button>
    </form:form>
</body>
</html>
