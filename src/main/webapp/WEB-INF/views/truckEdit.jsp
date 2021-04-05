<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl">
<%@ include file="header.jsp"%>
<table border="1">
    <thead>
    <th width="1406" bgcolor="olive">
        <span>Menu ciągniki</span>
    </th>
    </thead>
</table>
<table border="1">
    <thead>

    <%@ include file="headerData.jsp"%>

    <th width="1200">
        <p><span>Edycja danych ciągnika</span></p>
        <c:url var="editTruckUrl" value="/user/data/truck/edit"/>
        <form:form method="post" modelAttribute="editTruck" action="${editTruckUrl}">
            <form:hidden path="id" />
            <p>Nr rejestracyjny ciągnika: <form:input path="registerNumber"/></p>
            <form:errors path="registerNumber" cssClass="error"/>

            <p>Marka: <form:input path="brand"/></p>
            <form:errors path="brand" cssClass="error"/>

            <p>Rok produkcji: <form:input path="productionYear"/></p>
            <form:errors path="productionYear" cssClass="error"/>

            <p>Zużycie paliwa: <form:input path="fuelConsumption"/></p>
            <form:errors path="fuelConsumption" cssClass="error"/>

            <p><input type="submit" value="Zmień"/></p>
        </form:form>

    </th>
    </thead>
</table>
</body>
</html>
