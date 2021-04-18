<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl">
<%@ include file="header.jsp" %>
<table border="1">
    <thead>
    <th width="1406" bgcolor="olive">
        <span>Menu awizacja zlecenia</span>
    </th>
    </thead>
</table>
<table border="1">
    <thead>

    <%@ include file="headerOrder.jsp" %>

    <th width="1200">
        <span>Zlecenie nr ${orderToBook.orderNumber}</span></br>
        <span>Data i czas wygenerownia zlecenia ${orderToBook.created}</span>
        <table border="1">
            <thead>
            <th width="550">
                <span>Załadunek</span>
                <p>Firma: ${orderToBook.loadingPlace.company}</p>
                <p>Miejsce: ${orderToBook.loadingPlace.postCode}
                    ${orderToBook.loadingPlace.place}
                </p>
                <p>Data: ${orderToBook.loadingDate}</p>
                <p>Godzina: ${orderToBook.loadingHour}</p>
            </th>
            <th width="550">
                <span>Rozładunek</span>
                <p>Firma: ${orderToBook.unloadingPlace.company}</p>
                <p>Miejsce: ${orderToBook.unloadingPlace.postCode}
                    ${orderToBook.unloadingPlace.place}
                </p>
                <p>Data: ${orderToBook.deliveryDate}</p>
                <p>Godzina: ${orderToBook.deliveryHour}</p>
            </th>
            </thead>
        </table>

        <table border="1">
            <thead>
            <th width="1106">
                <p>Przewożony ładunek: ${orderToBook.cargo.name}</p>
            </th>
            </thead>
        </table>

        <p><span>Awizuj zlecenie</span></p>
        <c:url var="bookOrderUrl" value="/user/order/newOrder/book"/>
        <form:form method="post" modelAttribute="orderToBook" action="${bookOrderUrl}">
            <form:hidden path="id"/>
            <form:hidden path="status"/>
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

            <p>Kierowca: <form:select path="driver.id" items="${drivers}"
                                               itemLabel="fullName"  itemValue="id"/></p>
            <form:errors path="driver" cssClass="error" />
            <p>Ciągnik: <form:select path="truck.id" items="${trucks}"
                                      itemLabel="registerNumber"  itemValue="id"/></p>
            <form:errors path="truck" cssClass="error" />
            <p>Naczepa: <form:select path="semitrailer.id" items="${semitrailers}"
                                      itemLabel="registerNumber"  itemValue="id"/></p>
            <form:errors path="semitrailer" cssClass="error" />

            <p><input type="submit" value="Awizuj"/></p>
        </form:form>

    </th>
    </thead>
</table>

</body>
</html>
