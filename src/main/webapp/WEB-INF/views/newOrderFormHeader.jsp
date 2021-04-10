<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form:hidden path="id" />
<form:hidden path="status"/>
<form:hidden path="orderNumber"/>
<form:hidden path="created"/>
<p>Data dostawy: <form:input path="deliveryDate"/></p>
<form:errors path="deliveryDate" cssClass="error"/>

<p>Godzina dostawy: <form:input path="deliveryHour"/></p>
<form:errors path="deliveryHour" cssClass="error"/>

<p>Data załadunku: <form:input path="loadingDate"/></p>
<form:errors path="loadingDate" cssClass="error"/>

<p>Godzina załadunku: <form:input path="loadingHour"/></p>
<form:errors path="loadingHour" cssClass="error"/>

<p>Miejsce załadunku: <form:select path="loadingPlace.id" items="${loadingPlaces}"
                                   itemLabel="company" itemValue="id"/></p>
<form:errors path="loadingPlace" cssClass="error" />

<p>Miejsce rozładunku: <form:select path="unloadingPlace.id" items="${unloadingPlaces}"
                                   itemLabel="company" itemValue="id"/></p>
<form:errors path="unloadingPlace" cssClass="error" />

<p>Ładunek: <form:select path="cargo.id" items="${cargos}"
                                    itemLabel="name" itemValue="id"/></p>
<form:errors path="cargo" cssClass="error" />
