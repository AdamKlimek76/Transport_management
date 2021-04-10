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

    <%@ include file="headerOrder.jsp" %>

    <th width="1200">
        <span>Szczegóły zlecenia nr ${orderDetails.orderNumber}</span></br>
        <span>Data i czas wygenerownia zlecenia ${orderDetails.created}</span>
        <table border="1">
            <thead>
            <th width="550">
                <span>Załadunek</span>
                <p>Firma: ${orderDetails.loadingPlace.company}</p>
                <p>Miejsce: ${orderDetails.loadingPlace.postCode}
                    ${orderDetails.loadingPlace.place}
                </p>
                <p>Data: ${orderDetails.loadingDate}</p>
                <p>Godzina: ${orderDetails.loadingHour}</p>
            </th>
            <th width="550">
                <span>Rozładunek</span>
                <p>Firma: ${orderDetails.unloadingPlace.company}</p>
                <p>Miejsce: ${orderDetails.unloadingPlace.postCode}
                    ${orderDetails.unloadingPlace.place}
                </p>
                <p>Data: ${orderDetails.deliveryDate}</p>
                <p>Godzina: ${orderDetails.deliveryHour}</p>

            </th>
            </thead>
        </table>
        <table border="1">
            <thead>
            <th width="1106">
                <span>Przewożony ładunek: ${orderDetails.cargo.name}</span>
            </th>
            </thead>
        </table>
        <table border="1">
            <thead>
            <th width="550">
                <span>Kierowca</span>
                <p>Imię: ${orderDetails.driver.firstName}</p>
                <p>Nazwisko: ${orderDetails.driver.lastName}</p>
                <p>Nr telefonu: ${orderDetails.driver.phoneNumber}</p>
            </th>
            <th width="550">
                <span>Pojazd</span>
                <p>Nr rejestracyjny ciągnika: ${orderDetails.truck.registerNumber}</p>
                <p>Nr rejestracyjny naczepy: ${orderDetails.semitrailer.registerNumber}</p>
                <p>Typ naczepy: ${orderDetails.semitrailer.type}</p>
            </th>
            </thead>
        </table>
    </th>
    </thead>
</table>

</body>
</html>

