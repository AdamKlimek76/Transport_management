<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl">
<%@ include file="header.jsp" %>
<table border="1">
    <thead>
    <th width="1406" bgcolor="olive">
        <span>Menu miejsca rozładunku</span>
    </th>
    </thead>
</table>
<table border="1">
    <thead>

    <%@ include file="headerData.jsp"%>

    <th width="1200">
        <a href="${pageContext.request.contextPath}/user/data/unloadingPlace/add"><span>Dodaj miejsce rozładunku</span></a><br>
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
            <c:forEach items="${unloadingPlaces}" var="unloadingPlace">
                <tr>
                    <td><c:out value="${unloadingPlace.company}"/></td>
                    <td><c:out value="${unloadingPlace.postCode}"/></td>
                    <td><c:out value="${unloadingPlace.post}"/></td>
                    <td><c:out value="${unloadingPlace.place}"/></td>
                    <td><c:out value="${unloadingPlace.country}"/></td>
                    <td><c:out value="${unloadingPlace.alias}"/></td>
                    <td><a href='<c:url value="/user/data/unloadingPlace/edit/${unloadingPlace.id}" />'>Edytuj</a><br></td>
                    </td>
                    <td><a href='<c:url value="/user/data/unloadingPlace/delete/${unloadingPlace.id}" />'>Usuń</a><br></td>
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
