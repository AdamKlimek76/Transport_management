<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl">
<%@ include file="header.jsp"%>
<table border="1">
    <thead>
    <th width="1406" bgcolor="olive">
        <span>Menu kierowcy</span>
    </th>
    </thead>
</table>
<table border="1">
    <thead>

    <%@ include file="headerData.jsp"%>

    <th width="1200">
        <p><span>Dodawanie nowego kierowcę</span></p>

        <form:form method="post" modelAttribute="driver">

            <%@ include file="driverFormHeader.jsp"%>

            <p><input type="submit" value="Dodaj"/></p>
        </form:form>

    </th>
    </thead>
</table>

</body>
</html>