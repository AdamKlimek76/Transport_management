<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl">
<%@ include file="header.jsp" %>
<table border="1">
    <thead>
    <th width="1406" bgcolor="olive">
        <span>Menu miejsca załadunku</span>
    </th>
    </thead>
</table>
<table border="1">
    <thead>

    <%@ include file="headerData.jsp"%>

    <th width="1200">
        <a href="${pageContext.request.contextPath}/user/data/loadingPlace/add"><span>Dodaj miejsce załadunku</span></a><br>
        <table border="1">
            <thead>
            <th width="150" bgcolor="gray"><span>Firma</span></th>
            <th width="150" bgcolor="gray"><span>Kod pocztowy</span></th>
            <th width="150" bgcolor="gray"><span>Poczta</span></th>
            <th width="150" bgcolor="gray"><span>Miejscowość</span></th>
            <th width="150" bgcolor="gray"><span>Kraj</span></th>
            <th width="150" bgcolor="gray"><span>Alias</span></th>
            <th width="100" bgcolor="gray"><span><i>Edycja</i></span></th>
            <th width="100" bgcolor="gray"><span><i>Usuwanie</i></span></th>

            </thead>
            <tbody>
            <c:forEach items="${loadingPlaces}" var="loadingPlace">
                <tr>
                    <td><c:out value="${loadingPlace.company}"/></td>
                    <td><c:out value="${loadingPlace.postCode}"/></td>
                    <td><c:out value="${loadingPlace.post}"/></td>
                    <td><c:out value="${loadingPlace.place}"/></td>
                    <td><c:out value="${loadingPlace.country}"/></td>
                    <td><c:out value="${loadingPlace.alias}"/></td>
                    <td><a href='<c:url value="/user/data/loadingPlace/edit/${loadingPlace.id}" />'>Edytuj</a><br></td>
                    </td>
                    <td><a href='<c:url value="/user/data/loadingPlace/delete/${loadingPlace.id}" />'>Usuń</a><br></td>
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