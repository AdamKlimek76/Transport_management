<%--
  Created by IntelliJ IDEA.
  User: adam
  Date: 03.04.2021
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" bgcolor="#5f9ea0">
    <thead>
    <th width="1400" height="150">
        <h1><span>System zarządzania transportem</span></h1>
    </th>
    </thead>
    <tbody>
    <tr>
        <td>
            <a href="${pageContext.request.contextPath}/user/data/truck/all">
                <h2><span>Dane transportowe</span></h2>
            </a>
        </td>
    </tr>

    <tr>
        <td>
            <a href="${pageContext.request.contextPath}/user/order/newOrder/new">
                <h2><span>Zlecenia transportowe</span></h2>
            </a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="${pageContext.request.contextPath}/admin/permission/all" r>
                <h2><span>Użytkownicy</span></h2>
            </a>
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>
