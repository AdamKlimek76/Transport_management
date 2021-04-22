<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl">
<%@ include file="header.jsp" %>
<table border="1">
    <thead>
    <th width="1406" bgcolor="olive">
        <span>Raport wysłanych smsów</span>
    </th>
    </thead>
</table>
<table border="1">
    <thead>

    <%@ include file="headerReports.jsp"%>

    <th width="1200">
        <table border="1">
            <thead>
            <th width="50" bgcolor="gray"><span>Id</span></th>
            <th width="120" bgcolor="gray"><span>Nr telefonu</span></th>
            <th width="150" bgcolor="gray"><span>Nazwisko i imię</span></th>
            <th width="130" bgcolor="gray"><span>Kiedy wysłano</span></th>
            <th width="690" bgcolor="gray"><span><i>Treść wiadomości</i></span></th>
            <th width="50" bgcolor="gray"><span><i>Usuw</i></span></th>

            </thead>
            <tbody>
            <c:forEach items="${allSms}" var="oneSms">
                <tr>
                    <td><c:out value="${oneSms.id}"/></td>
                    <td><c:out value="${oneSms.driver.phoneNumber}"/></td>
                    <td><c:out value="${oneSms.driver.fullName}"/></td>
                    <td><c:out value="${oneSms.created}"/></td>
                    <td><c:out value="${oneSms.message}"/></td>
                    <td><a href='<c:url value="/user/reports/sms/delete/${oneSms.id}" />'>Usuń</a><br></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </th>
    </thead>
</table>

</body>
</html>