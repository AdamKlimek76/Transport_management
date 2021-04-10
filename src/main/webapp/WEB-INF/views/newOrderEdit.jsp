<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl">
<%@ include file="header.jsp"%>
<table border="1">
    <thead>
    <th width="1406" bgcolor="olive">
        <span>Menu nowe zamówienia</span>
    </th>
    </thead>
</table>
<table border="1">
    <thead>

    <%@ include file="headerOrder.jsp"%>

    <th width="1200">
        <p><span>Edycja danych nowych zamówień</span></p>
        <c:url var="editNewOrderrUrl" value="/user/order/newOrder/edit"/>
        <form:form method="post" modelAttribute="editNewOrder" action="${editNewOrderrUrl}">

            <%@ include file="newOrderFormHeader.jsp"%>

            <p><input type="submit" value="Zmień"/></p>
        </form:form>

    </th>
    </thead>
</table>
</body>
</html>