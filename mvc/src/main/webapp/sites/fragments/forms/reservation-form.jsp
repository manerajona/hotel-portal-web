<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<spring:url value="/reservation" var="reservationUrl" />

<form:form method="POST" modelAttribute="reservationForm" class="site-form" action="${reservationUrl}">
    <h2 class="text-center">Hace tu reserva</h2>
    <c:if test="${not empty message}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">×</span>
            </button>
            <strong>${message}</strong>
        </div>
    </c:if>
    <div class="row">

        <form:hidden path="id" />

        <spring:bind path="checkIn">
            <div class="col-xl-6 mt-3 ${status.error ? 'has-error' : ''}">
                <label>Fecha de Check in</label>
                <form:input path="checkIn" type="date" class="form-control form-control-lg" placeholder="Check in"
                    pattern="dd/MM/yyyy" required="required" autofocus="true" />
                <strong>
                    <form:errors path="checkIn"></form:errors>
                </strong>
            </div>
        </spring:bind>
        <spring:bind path="checkOut">
            <div class="col-xl-6 mt-3 ${status.error ? 'has-error' : ''}">
                <label>Fecha de Check out</label>
                <form:input path="checkOut" type="date" class="form-control form-control-lg" placeholder="Check out"
                    pattern="dd/MM/yyyy" required="required" />
                <strong>
                    <form:errors path="checkOut"></form:errors>
                </strong>
            </div>
        </spring:bind>
    </div>
    <div class="row">
        <spring:bind path="roomType">
            <div class="col-xl-6 mt-3 ${status.error ? 'has-error' : ''}">
                <label>Tipo de habitación</label>
                <form:select path="roomType" class="form-control form-control-lg" id="default-select">
                    <option data-display="Room type"> </option>
                    <form:option value="Laxaries">Laxaries Rooms</form:option>
                    <form:option value="Deluxe">Deluxe Room</form:option>
                    <form:option value="Signature">Signature Room</form:option>
                    <form:option value="Couple">Couple Room</form:option>
                </form:select>
                <strong>
                    <form:errors path="roomType"></form:errors>
                </strong>
            </div>
        </spring:bind>
        <spring:bind path="guests">
            <div class="col-xl-6 mt-3 ${status.error ? 'has-error' : ''}">
                <label>Húespedes</label>
                <form:select path="guests" class="form-control form-control-lg" id="default-select">
                    <option data-display="Adultos">0</option>
                    <form:option value="1">1</form:option>
                    <form:option value="2">2</form:option>
                    <form:option value="3">3</form:option>
                    <form:option value="4">4</form:option>
                </form:select>
                <strong>
                    <form:errors path="guests"></form:errors><strong>
            </div>
        </spring:bind>
    </div>
    
    <div class="row">
        <div class="col-xl-6 mx-auto my-4">
            <button type="submit" class="btn btn-primary btn-block">Aceptar</button>
        </div>
    </div>
    
</form:form>