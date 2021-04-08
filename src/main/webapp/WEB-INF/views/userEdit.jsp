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

        <%@ include file="userFormHeader.jsp"%>

        <p><input type="submit" value="Zmień"/></p>
    </form:form>

    </th>
    </thead>
</table>
</body>
</html>