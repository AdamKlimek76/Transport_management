<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl">
<%@ include file="header.jsp" %>
<table border="1">
    <thead>
    <th width="1406" bgcolor="olive">
        <span>Menu kierowcy</span>
    </th>
    </thead>
</table>
<table border="1">
    <thead>

    <%@ include file="headerData.jsp"%>

    <th width="1200">
        <a href="${pageContext.request.contextPath}/user/data/driver/add"><span>Dodaj kierowcę</span></a><br>
        <table border="1">
            <thead>
            <th width="150" bgcolor="gray"><span>Imię</span></th>
            <th width="150" bgcolor="gray"><span>Nazwisko</span></th>
            <th width="150" bgcolor="gray"><span>Nr telefonu</span></th>
            <th width="150" bgcolor="gray"><span>Wynagrodzenie</span></th>
            <th width="100" bgcolor="gray"><span><i>Edycja</i></span></th>
            <th width="100" bgcolor="gray"><span><i>Usuwanie</i></span></th>

            </thead>
            <tbody>
            <c:forEach items="${drivers}" var="driver">
                <tr>
                    <td><c:out value="${driver.firstName}"/></td>
                    <td><c:out value="${driver.lastName}"/></td>
                    <td><c:out value="${driver.phoneNumber}"/></td>
                    <td><c:out value="${driver.salary}"/></td>
                    <td><a href='<c:url value="/user/data/driver/edit/${driver.id}" />'>Edytuj</a><br></td>
                    </td>
                    <td><a href='<c:url value="/user/data/driver/delete/${driver.id}" />'>Usuń</a><br></td>
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