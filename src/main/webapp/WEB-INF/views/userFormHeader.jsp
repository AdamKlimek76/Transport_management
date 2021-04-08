<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form:hidden path="id" />
<p>Login: <form:input path="login"/></p>
<form:errors path="login" cssClass="error"/>

<p>Hasło: <form:input path="password"/></p>
<form:errors path="password" cssClass="error"/>

<p>Imię: <form:input path="firstName"/></p>
<form:errors path="firstName" cssClass="error"/>

<p>Nazwisko: <form:input path="lastName"/></p>
<form:errors path="lastName" cssClass="error"/>

<p>Stanowisko: <form:input path="position"/></p>
<form:errors path="position" cssClass="error"/>

<p>Uprawnienia: <form:select path="role">
    <form:option value="ADMIN" label="admin"/>
    <form:option value="USER" label="user"/>
</form:select>
</p>
<form:errors path="role" cssClass="error"/>
