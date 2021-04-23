<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl">
<%@ include file="header.jsp" %>
<table border="1">
    <thead>
    <th width="1406" bgcolor="olive">
        <span>Menu zmiana awizacji (lub zmiana statusu) zlecenia</span>
    </th>
    </thead>
</table>
<table border="1">
    <thead>

    <%@ include file="headerOrder.jsp" %>

    <th width="1200">
        <span>Zlecenie nr ${editBookedOrder.orderNumber}</span></br>
        <table border="1">
            <thead>
            <th width="550">
                <span>Załadunek</span>
                <p>Firma: ${editBookedOrder.loadingPlace.company}</p>
                <p>Miejsce: ${editBookedOrder.loadingPlace.postCode}
                    ${editBookedOrder.loadingPlace.place}
                </p>
                <p>Data: ${editBookedOrder.loadingDate}</p>
                <p>Godzina: ${editBookedOrder.loadingHour}</p>
            </th>
            <th width="550">
                <span>Rozładunek</span>
                <p>Firma: ${editBookedOrder.unloadingPlace.company}</p>
                <p>Miejsce: ${editBookedOrder.unloadingPlace.postCode}
                    ${editBookedOrder.unloadingPlace.place}
                </p>
                <p>Data: ${editBookedOrder.deliveryDate}</p>
                <p>Godzina: ${editBookedOrder.deliveryHour}</p>
            </th>
            </thead>
        </table>

        <table border="1">
            <thead>
            <th width="1106">
                <p>Przewożony ładunek: ${editBookedOrder.cargo.name}</p>
            </th>
            </thead>
        </table>

        <p><span>Awizuj zlecenie</span></p>
        <c:url var="editBookOrderUrl" value="/user/order/newOrder/editBooked"/>
        <form:form method="post" modelAttribute="editBookedOrder" action="${editBookOrderUrl}">
            <form:hidden path="id"/>
            <form:hidden path="updated"/>
            <form:hidden path="created"/>
            <form:hidden path="orderNumber"/>
            <form:hidden path="loadingPlace.id"/>
            <form:hidden path="unloadingPlace.id"/>
            <form:hidden path="loadingDate"/>
            <form:hidden path="deliveryDate"/>
            <form:hidden path="loadingHour"/>
            <form:hidden path="deliveryHour"/>
            <form:hidden path="cargo.id"/>

            <p>Zmień status: <form:select path="status">
                <form:option value="w trakcie" label="w trakcie"/>
                <form:option value="zrealizowane" label="zrealizowane"/>
            </form:select>
            </p>
            <form:errors path="status" cssClass="error"/>

            <p>Kierowca: <form:select path="driver.id" items="${drivers}"
                                      itemLabel="fullName"  itemValue="id"/></p>
            <form:errors path="driver" cssClass="error" />
            <p>Ciągnik: <form:select path="truck.id" items="${trucks}"
                                     itemLabel="registerNumber"  itemValue="id"/></p>
            <form:errors path="truck" cssClass="error" />
            <p>Naczepa: <form:select path="semitrailer.id" items="${semitrailers}"
                                     itemLabel="registerNumber"  itemValue="id"/></p>
            <form:errors path="semitrailer" cssClass="error" />

            <p><input type="submit" value="Zmień"/></p>
        </form:form>

    </th>
    </thead>
</table>

</body>
</html>