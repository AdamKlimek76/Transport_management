<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl">
<%@ include file="header.jsp" %>
<table border="1">
    <thead>
    <th width="1406" bgcolor="olive">
        <span>Menu wszystkie zlecenia</span>
    </th>
    </thead>
</table>
<table border="1">
    <thead>

    <%@ include file="headerOrder.jsp" %>

    <th width="1200">

        <table border="1">
            <table border="1">
                <thead>
                <th width="1190">
                    <span>Wyszukiwanie we wszystkich widocznych kolumnach</span>
                    <form method="post" action="/user/order/newOrder/all/found">
                        Znajdź:
                        <input type="text" name="searchedText"/>
                        <br>
                        <input type="submit" value="Znajdź"/>
                    </form>
                </th>
                </thead>
            </table>
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
                <th width="100" bgcolor="gray"><span><i>Usuwanie</i></span></th>

                </thead>
                <tbody>
                <c:forEach items="${allOrders}" var="allOrder">
                    <tr>
                        <td><c:out value="${allOrder.status}"/></td>
                        <td><c:out value="${allOrder.orderNumber}"/></td>
                        <td><c:out value="${allOrder.deliveryDate}"/></td>
                        <td><c:out value="${allOrder.deliveryHour}"/></td>
                        <td><c:out value="${allOrder.loadingDate}"/></td>
                        <td><c:out value="${allOrder.loadingHour}"/></td>
                        <td><c:out value="${allOrder.loadingPlace.company}"/></td>
                        <td><c:out value="${allOrder.unloadingPlace.company}"/></td>
                        <td><c:out value="${allOrder.cargo.name}"/></td>
                        <td><c:out value="${allOrder.driver.fullName}"/></td>
                        <td><c:out value="${allOrder.truck.registerNumber}"/></td>
                        <td><c:out value="${allOrder.semitrailer.registerNumber}"/></td>
                        <td><a href='<c:url value="/user/order/newOrder/deleteAll/${allOrder.id}" />'>Usuń</a><br></td>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            </th>
            </thead>
        </table>
    </th>
    </thead>
</table>
        </body>
</html>
