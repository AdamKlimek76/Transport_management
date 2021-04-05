<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl">
<%@ include file="header.jsp"%>
<table border="1">
    <thead>
    <th width="1406" bgcolor="olive">
        <span>Menu użytkownicy</span>
    </th>
    </thead>
</table>
<table border="1">
    <thead>
    <th width="200" bgcolor="#5f9ea0">
    <a href="${pageContext.request.contextPath}/admin/permission/add" r>
        <span>Dodaj użytkownika</span>
    </a>
    </th>
    <th width="1200">
<p><span>Edycja użytkownika</span></p>
    <c:url var="editUserUrl" value="/admin/permission/edit"/>
    <form:form method="post" modelAttribute="editUser" action="${editUserUrl}">
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

        <p><input type="submit" value="Zmień"/></p>
    </form:form>

    </th>
    </thead>
</table>
</body>
</html>