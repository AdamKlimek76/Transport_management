<%--
  Created by IntelliJ IDEA.
  User: adam
  Date: 05.04.2021
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<header>
    <head>
        <meta charset="UTF-8">
        <title>Title</title>
        <link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet"/>
    </head>
    <table border="1" bgcolor="#5f9ea0">
        <thead>
        <th width="200">
            LOGO
        </th>
        <th width="1200">
            <table>
                <thead>
                <th width="300">
                    <a href="${pageContext.request.contextPath}/user/data/truck/all">
                        <span>Dane transportowe</span>
                    </a>
                </th>
                <th width="300">
                    <a href="${pageContext.request.contextPath}/user/order/newOrder/new">
                        <span>Zlecenia transportowe</span>
                    </a>
                </th>
                <th width="300">
                    <a href="${pageContext.request.contextPath}/admin/permission/all" r>
                        <span>Użytkownicy</span>
                    </a>
                </th>
                </thead>
            </table>
        </th>
        </thead>
    </table>
</header>
</html>
