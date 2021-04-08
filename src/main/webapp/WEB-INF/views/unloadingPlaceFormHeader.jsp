<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<form:hidden path="id" />
<p>Firma: <form:input path="company"/></p>
<form:errors path="company" cssClass="error"/>

<p>Kod pocztowy: <form:input path="postCode"/></p>
<form:errors path="postCode" cssClass="error"/>

<p>Poczta: <form:input path="post"/></p>
<form:errors path="post" cssClass="error"/>

<p>Miejscowość: <form:input path="place"/></p>
<form:errors path="place" cssClass="error"/>

<p>Kraj: <form:input path="country"/></p>
<form:errors path="country" cssClass="error"/>

<p>Alias: <form:input path="alias"/></p>
<form:errors path="alias" cssClass="error"/>
