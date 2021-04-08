<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl">
<%@ include file="header.jsp" %>
<table border="1">
    <thead>
    <th width="1406" bgcolor="olive">
        <span>Menu przewożony ładunek</span>
    </th>
    </thead>
</table>
<table border="1">
    <thead>

    <%@ include file="headerData.jsp"%>

    <th width="1200">
        <a href="${pageContext.request.contextPath}/user/data/cargo/add"><span>Dodaj ładunek</span></a><br>
        <table border="1">
            <thead>
            <th width="200" bgcolor="gray"><span>Nazwa</span></th>
            <th width="100" bgcolor="gray"><span><i>Edycja</i></span></th>
            <th width="100" bgcolor="gray"><span><i>Usuwanie</i></span></th>

            </thead>
            <tbody>
            <c:forEach items="${cargos}" var="cargo">
                <tr>
                    <td><c:out value="${cargo.name}"/></td>
                    <td><a href='<c:url value="/user/data/cargo/edit/${cargo.id}" />'>Edytuj</a><br></td>
                    </td>
                    <td><a href='<c:url value="/user/data/cargo/delete/${cargo.id}" />'>Usuń</a><br></td>
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
