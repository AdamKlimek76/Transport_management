<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl">
<%@ include file="header.jsp" %>
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
        <table border="1">
            <thead>
            <th width="150" bgcolor="gray"><span>Login</span></th>
            <th width="150" bgcolor="gray"><span>Hasło</span></th>
            <th width="150" bgcolor="gray"><span>Imię</span></th>
            <th width="150" bgcolor="gray"><span>Nazwisko</span></th>
            <th width="150" bgcolor="gray"><span>Stanowisko</span></th>
            <th width="100" bgcolor="gray"><span>Uprawnienia</span></th>
            <th width="100" bgcolor="gray"><span><i>Edycja</i></span></th>
            <th width="100" bgcolor="gray"><span><i>Usuwanie</i></span></th>

            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td><c:out value="${user.login}"/></td>
                    <td><c:out value="${user.password}"/></td>
                    <td><c:out value="${user.firstName}"/></td>
                    <td><c:out value="${user.lastName}"/></td>
                    <td><c:out value="${user.position}"/></td>
                    <td><c:out value="${user.role}"/></td>
                    <td><a href='<c:url value="/admin/permission/edit/${user.id}" />'>Edytuj</a><br></td>
                    </td>
                    <td><a href='<c:url value="/admin/permission/delete/${user.id}" />'>Usuń</a><br></td>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </th>
    </thead>
</table>

</body>
</html>
