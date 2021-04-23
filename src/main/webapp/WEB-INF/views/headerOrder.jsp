<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<header>
    <th width="200" bgcolor="#5f9ea0">

        <a href="${pageContext.request.contextPath}/user/order/newOrder/new">
            <span>Nowe zlecenia</span>
        </a>
        <br><br>
        <a href="${pageContext.request.contextPath}/user/order/newOrder/booked">
            <span>Zaawizowane zlecenia</span>
        </a>
        <br><br>
        <a href="${pageContext.request.contextPath}/user/order/newOrder/done">
            <span>Zrealizowane zlecenia</span>
        </a>
        <br><br>
        <a href="${pageContext.request.contextPath}/user/order/newOrder/all">
            <span>Wszystkie zlecenia</span>
        </a>
    </th>
</header>
</html>