<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Expense</title>
</head>
<body>
    <h1>Edit Expense</h1>
    <form:form action="/expenses/edit/${oneExpense.id }" method="post" modelAttribute="oneExpense">
    <input type="hidden" name="_method" value="put"/>
    	
        <form:label path="name">Name:</form:label>
        <form:input path="name" />
        <form:errors path="name"/><br>

        <form:label path="vendor">Vendor:</form:label>
        <form:input path="vendor" />
        <form:errors path="vendor"/><br>

        <form:label path="amount">Amount:</form:label>
        <form:input path="amount" type="number" />
        <form:errors path="amount"/><br>

        <form:label path="description">Description:</form:label>
        <form:textarea path="description" />
        <form:errors path="description"/><br>

        <button type="submit">Edit</button>
    </form:form>
</body>
</html>
