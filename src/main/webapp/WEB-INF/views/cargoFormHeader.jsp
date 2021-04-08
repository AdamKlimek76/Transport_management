<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form:hidden path="id" />
<p>Nazwa ładunku: <form:input path="name"/></p>
<form:errors path="name" cssClass="error"/>
