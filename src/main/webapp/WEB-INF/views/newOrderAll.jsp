<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl">
<%@ include file="header.jsp" %>
<table border="1">
    <thead>
    <th width="1406" bgcolor="olive">
        <span>Menu nowe zlecenia</span>
    </th>
    </thead>
</table>
<table border="1">
    <thead>

    <%@ include file="headerOrder.jsp"%>

    <th width="1200">
        <a href="${pageContext.request.contextPath}/user/order/newOrder/add"><span>Dodaj nowe zlecenie</span></a><br>
        <table border="1">
            <thead>
            <th width="90" bgcolor="gray"><span>Status</span></th>
            <th width="100" bgcolor="gray"><span>Nr zam</span></th>
            <th width="100" bgcolor="gray"><span>Data dostawy</span></th>
            <th width="70" bgcolor="gray"><span>Godz dostawy</span></th>
            <th width="100" bgcolor="gray"><span>Data załadunku</span></th>
            <th width="90" bgcolor="gray"><span>Godz załadunku</span></th>
            <th width="150" bgcolor="gray"><span>Miejsce załadunku</span></th>
            <th width="150" bgcolor="gray"><span>Miejsce rozładunku</span></th>
            <th width="90" bgcolor="gray"><span>Ładunek</span></th>
            <th width="100" bgcolor="gray"><span><i>Szczegóły</i></span></th>
            <th width="100" bgcolor="gray"><span><i>Awizacja</i></span></th>
            <th width="100" bgcolor="gray"><span><i>Edycja</i></span></th>
            <th width="100" bgcolor="gray"><span><i>Usuwanie</i></span></th>

            </thead>
            <tbody>
            <c:forEach items="${newOrders}" var="newOrder">
                <tr>
                    <td><c:out value="${newOrder.status}"/></td>
                    <td><c:out value="${newOrder.orderNumber}"/></td>
                    <td><c:out value="${newOrder.deliveryDate}"/></td>
                    <td><c:out value="${newOrder.deliveryHour}"/></td>
                    <td><c:out value="${newOrder.loadingDate}"/></td>
                    <td><c:out value="${newOrder.loadingHour}"/></td>
                    <td><c:out value="${newOrder.loadingPlace.company}"/></td>
                    <td><c:out value="${newOrder.unloadingPlace.company}"/></td>
                    <td><c:out value="${newOrder.cargo.name}"/></td>
                    <td><a href='<c:url value="/user/order/newOrder/detail/${newOrder.id}" />'>Pokaż</a><br></td>
                    </td>
                    <td><a href='<c:url value="/user/order/newOrder/book/${newOrder.id}" />'>Awizuj</a><br></td>
                    </td>
                    <td><a href='<c:url value="/user/order/newOrder/edit/${newOrder.id}" />'>Edytuj</a><br></td>
                    </td>
                    <td><a href='<c:url value="/user/order/newOrder/delete/${newOrder.id}" />'>Usuń</a><br></td>
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
