<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form:hidden path="id" />
<p>Nr rejestracyjny ciągnika: <form:input path="registerNumber"/></p>
<form:errors path="registerNumber" cssClass="error"/>

<p>Marka: <form:input path="brand"/></p>
<form:errors path="brand" cssClass="error"/>

<p>Rok produkcji: <form:input path="productionYear"/></p>
<form:errors path="productionYear" cssClass="error"/>

<p>Zużycie paliwa: <form:input path="fuelConsumption"/></p>
<form:errors path="fuelConsumption" cssClass="error"/>
