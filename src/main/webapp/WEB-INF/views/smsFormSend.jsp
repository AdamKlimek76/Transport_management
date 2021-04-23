<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl">
<%@ include file="header.jsp" %>
<table border="1">
    <thead>
    <th width="1406" bgcolor="olive">
        <span>Wysyłanie zleceń transportowych [SMS] do kierowców</span>
    </th>
    </thead>
</table>
<table border="1">
    <thead>

    <%@ include file="headerReports.jsp" %>

    <th width="1200">
        <table border="1">
            <thead>
            <th width="550">

                <c:url var="smsFullUrl" value="/user/reports/sms/add/full"/>
                <form:form method="post" modelAttribute="smsFull" action="${smsFullUrl}">
                    Nr telefonu kierowcy: ${smsFull.driver.phoneNumber}<br>
                    Nazwisko i imię kierowcy: ${smsFull.driver.fullName}
                    <form:hidden path="id"/>
                    <form:hidden path="driver.id"/><br>
                    <p>Wiadomość do wysłania:<br>
                        <form:textarea path="message"/></p>

                    <p><input type="submit" value="Wyślij"/></p>
                </form:form>
            </th>
            <th width="550">
                <c:url var="smsAliasUrl" value="/user/reports/sms/add/alias"/>
                <form:form method="post" modelAttribute="smsAlias" action="${smsAliasUrl}">
                    Nr telefonu kierowcy: ${smsAlias.driver.phoneNumber}<br>
                    Nazwisko i imię kierowcy: ${smsAlias.driver.fullName}
                    <form:hidden path="id"/>
                    <form:hidden path="driver.id"/><br>
                    <p>Wiadomość do wysłania:<br>
                        <form:textarea path="message"/></p>
                    <p><input type="submit" value="Wyślij"/></p>
                </form:form>
            </th>
            </thead>
        </table>
    </th>
    </thead>
</table>

</body>
</html>