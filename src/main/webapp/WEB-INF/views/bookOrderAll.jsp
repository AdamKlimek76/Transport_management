<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl">
<%@ include file="header.jsp" %>
<table border="1">
    <thead>
    <th width="1406" bgcolor="olive">
        <span>Menu zaawizowane (w trakcie realizacji) zlecenia</span>
    </th>
    </thead>
</table>
<table border="1">
    <thead>

    <%@ include file="headerOrder.jsp"%>

    <th width="1200">
        <table border="1">
            <thead>
            <th width="90" bgcolor="gray"><span>Status</span></th>
            <th width="100" bgcolor="gray"><span>Nr zam</span></th>
            <th width="100" bgcolor="gray"><span>Data dostawy</span></th>
            <th width="70" bgcolor="gray"><span>Godz dost</span></th>
            <th width="100" bgcolor="gray"><span>Data załadunku</span></th>
            <th width="70" bgcolor="gray"><span>Godz załad</span></th>
            <th width="150" bgcolor="gray"><span>Miejsce załadunku</span></th>
            <th width="150" bgcolor="gray"><span>Miejsce rozładunku</span></th>
            <th width="90" bgcolor="gray"><span>Ładunek</span></th>
            <th width="100" bgcolor="gray"><span><i>Kierowca</i></span></th>
            <th width="70" bgcolor="gray"><span><i>Ciągnik</i></span></th>
            <th width="70" bgcolor="gray"><span><i>Naczepa</i></span></th>
            <th width="100" bgcolor="gray"><span><i>Edycja</i></span></th>
            <th width="70" bgcolor="gray"><span><i>Usuw</i></span></th>
            <th width="70" bgcolor="gray"><span><i>Sms</i></span></th>

            </thead>
            <tbody>
            <c:forEach items="${bookedOrders}" var="bookedOrder">
                <tr>
                    <td><c:out value="${bookedOrder.status}"/></td>
                    <td><c:out value="${bookedOrder.orderNumber}"/></td>
                    <td><c:out value="${bookedOrder.deliveryDate}"/></td>
                    <td><c:out value="${bookedOrder.deliveryHour}"/></td>
                    <td><c:out value="${bookedOrder.loadingDate}"/></td>
                    <td><c:out value="${bookedOrder.loadingHour}"/></td>
                    <td><c:out value="${bookedOrder.loadingPlace.company}"/></td>
                    <td><c:out value="${bookedOrder.unloadingPlace.company}"/></td>
                    <td><c:out value="${bookedOrder.cargo.name}"/></td>
                    <td><c:out value="${bookedOrder.driver.fullName}"/></td>
                    <td><c:out value="${bookedOrder.truck.registerNumber}"/></td>
                    <td><c:out value="${bookedOrder.semitrailer.registerNumber}"/></td>
                    <td><a href='<c:url value="/user/order/newOrder/editBooked/${bookedOrder.id}" />'>Edytuj</a><br></td>
                    </td>
                    <td><a href='<c:url value="/user/order/newOrder/deleteBooked/${bookedOrder.id}" />'>Usuń</a><br></td>
                    </td>
                    <td><a href='<c:url value="/user/reports/sms/add/${bookedOrder.id}" />'>Wyślij</a><br></td>
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