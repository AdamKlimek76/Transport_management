<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form:hidden path="id" />
<p>Nr rejestracyjny naczepy: <form:input path="registerNumber"/></p>
<form:errors path="registerNumber" cssClass="error"/>

<p>Marka: <form:input path="brand"/></p>
<form:errors path="brand" cssClass="error"/>

<p>Rok produkcji: <form:input path="productionYear"/></p>
<form:errors path="productionYear" cssClass="error"/>

<p>Typ naczepy: <form:select path="type">
    <form:option value="silo" label="silos"/>
    <form:option value="tank" label="cysterna"/>
</form:select>
</p>
<form:errors path="type" cssClass="error"/>
