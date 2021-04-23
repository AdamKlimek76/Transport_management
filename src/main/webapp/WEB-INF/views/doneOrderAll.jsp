<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl">
<%@ include file="header.jsp" %>
<table border="1">
    <thead>
    <th width="1406" bgcolor="olive">
        <span>Menu zrealizowane zlecenia</span>
    </th>
    </thead>
</table>
<table border="1">
    <thead>

    <%@ include file="headerOrder.jsp"%>

    <th width="1200">
        <table border="1">
            <thead>
            <th width="550">
                <span>Sortowanie</span>
                <form method="post" action="/user/order/newOrder/done/sorted">
                    Sortuj zlecenia według:
                    <select name="sortedDoneOrders">
                            <option value="loadingPlace">Miejsca załadunku</option>
                            <option value="unloadingPlace">Miejsca rozładunku</option>
                    </select>
                    <br>
                    <input type="radio" name="sortingOptions" value="ASC" checked/>Sortuj rosnąco
                    <input type="radio" name="sortingOptions" value="DESC"/>Sortuj malejąco
                    <br>
                    <input type="submit" value="Sortuj"/>
                </form>
            </th>
            <th width="550">
                <span>Wyszukiwanie</span>
                <form method="post" action="/user/order/newOrder/done/found">
                    Wyszukaj zlecenia wg:
                    <select name="findDoneOrders">
                        <option value="driver">Nazwiska kierowcy</option>
                        <option value="trailerRegisterNumber">Nr rejestracyjnego naczepy</option>
                    </select>
                    <br>
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
            <c:forEach items="${doneOrders}" var="doneOrder">
                <tr>
                    <td><c:out value="${doneOrder.status}"/></td>
                    <td><c:out value="${doneOrder.orderNumber}"/></td>
                    <td><c:out value="${doneOrder.deliveryDate}"/></td>
                    <td><c:out value="${doneOrder.deliveryHour}"/></td>
                    <td><c:out value="${doneOrder.loadingDate}"/></td>
                    <td><c:out value="${doneOrder.loadingHour}"/></td>
                    <td><c:out value="${doneOrder.loadingPlace.company}"/></td>
                    <td><c:out value="${doneOrder.unloadingPlace.company}"/></td>
                    <td><c:out value="${doneOrder.cargo.name}"/></td>
                    <td><c:out value="${doneOrder.driver.fullName}"/></td>
                    <td><c:out value="${doneOrder.truck.registerNumber}"/></td>
                    <td><c:out value="${doneOrder.semitrailer.registerNumber}"/></td>
                    <td><a href='<c:url value="/user/order/newOrder/deleteDone/${doneOrder.id}" />'>Usuń</a><br></td>
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