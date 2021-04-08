<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <p><span>Dodawanie nowego użytkownika</span></p>

    <form:form method="post" modelAttribute="user">

        <%@ include file="userFormHeader.jsp"%>

        <p><input type="submit" value="Dodaj"/></p>
    </form:form>

    </th>
    </thead>
</table>

</body>
</html>
