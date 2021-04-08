<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl">
<%@ include file="header.jsp" %>
<table border="1">
    <thead>
    <th width="1406" bgcolor="olive">
        <span>Menu naczepy</span>
    </th>
    </thead>
</table>
<table border="1">
    <thead>

    <%@ include file="headerData.jsp"%>

    <th width="1200">
        <a href="${pageContext.request.contextPath}/user/data/semitrailer/add"><span>Dodaj naczepę</span></a><br>
        <table border="1">
            <thead>
            <th width="150" bgcolor="gray"><span>Nr rejestracyjny</span></th>
            <th width="150" bgcolor="gray"><span>Marka</span></th>
            <th width="150" bgcolor="gray"><span>Rok produkcji</span></th>
            <th width="150" bgcolor="gray"><span>Typ naczepy</span></th>

            </thead>
            <tbody>
            <c:forEach items="${semitrailers}" var="semitrailer">
                <tr>
                    <td><c:out value="${semitrailer.registerNumber}"/></td>
                    <td><c:out value="${semitrailer.brand}"/></td>
                    <td><c:out value="${semitrailer.productionYear}"/></td>
                    <td><c:out value="${semitrailer.type}"/></td>
                    <td><a href='<c:url value="/user/data/semitrailer/edit/${semitrailer.id}" />'>Edytuj</a><br></td>
                    </td>
                    <td><a href='<c:url value="/user/data/semitrailer/delete/${semitrailer.id}" />'>Usuń</a><br></td>
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