<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl">
<%@ include file="header.jsp" %>
<table border="1">
    <thead>
    <th width="1406" bgcolor="olive">
        <span>Menu ciągniki</span>
    </th>
    </thead>
</table>
<table border="1">
    <thead>

    <%@ include file="headerData.jsp"%>

    <th width="1200">
        <a href="${pageContext.request.contextPath}/user/data/truck/add"><span>Dodaj ciągnik</span></a><br>
        <table border="1">
            <thead>
            <th width="150" bgcolor="gray"><span>Nr rejestracyjny</span></th>
            <th width="150" bgcolor="gray"><span>Marka</span></th>
            <th width="150" bgcolor="gray"><span>Rok produkcji</span></th>
            <th width="150" bgcolor="gray"><span>Zużycie paliwa</span></th>
            <th width="100" bgcolor="gray"><span><i>Edycja</i></span></th>
            <th width="100" bgcolor="gray"><span><i>Usuwanie</i></span></th>

            </thead>
            <tbody>
            <c:forEach items="${trucks}" var="truck">
                <tr>
                    <td><c:out value="${truck.registerNumber}"/></td>
                    <td><c:out value="${truck.brand}"/></td>
                    <td><c:out value="${truck.productionYear}"/></td>
                    <td><c:out value="${truck.fuelConsumption}"/></td>
                    <td><a href='<c:url value="/user/data/truck/edit/${truck.id}" />'>Edytuj</a><br></td>
                    </td>
                    <td><a href='<c:url value="/user/data/truck/delete/${truck.id}" />'>Usuń</a><br></td>
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
