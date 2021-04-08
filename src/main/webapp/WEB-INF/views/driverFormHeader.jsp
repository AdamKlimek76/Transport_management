<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form:hidden path="id" />
<p>Imię: <form:input path="firstName"/></p>
<form:errors path="firstName" cssClass="error"/>

<p>Nazwisko: <form:input path="lastName"/></p>
<form:errors path="lastName" cssClass="error"/>

<p>Nr telefonu: <form:input path="phoneNumber"/></p>
<form:errors path="phoneNumber" cssClass="error"/>

<p>Wynagrodzenie: <form:input path="salary"/></p>
<form:errors path="salary" cssClass="error"/>