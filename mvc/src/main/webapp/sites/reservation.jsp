<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Reservation</title>

    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/sites.css" rel="stylesheet">
    <link href="css/landing-page.css" rel="stylesheet">
</head>

<body>

    <!-- Navigation -->
    <nav class="navbar navbar-light bg-light static-top">
        <div class="container">
            <a class="navbar-brand" href="index">Hotel Córdoba Inc.</a>
        </div>
    </nav>

    <div class="reservation-form">
        <form:form method="POST" modelAttribute="reservationForm" class="form-reservation">
            <h2 class="text-center">Hace tu reserva</h2>
            <span>${message}</span>
            <div class="row">
                <spring:bind path="checkIn">
                    <div class="col-xl-6 ${status.error ? 'has-error' : ''}">
                        <label>Fecha de Check in</label>
                        <form:input path="checkIn" type="date" class="form-control form-control-lg"
                            placeholder="Check in" pattern="dd/MM/yyyy" required="required" />
                        <form:errors path="checkIn"></form:errors><br />
                    </div>
                </spring:bind>
                <spring:bind path="checkOut">
                    <div class="col-xl-6 ${status.error ? 'has-error' : ''}">
                        <label>Fecha de Check out</label>
                        <form:input path="checkOut" type="date" class="form-control form-control-lg"
                            placeholder="Check out" pattern="dd/MM/yyyy" required="required" />
                        <form:errors path="checkOut"></form:errors> <br />
                    </div>
                </spring:bind>
            </div>
            <div class="row">
                <spring:bind path="roomType">
                    <div class="col-xl-6 ${status.error ? 'has-error' : ''}">
                        <label>Tipo de habitación</label>
                        <form:select path="roomType" class="form-control form-control-lg" id="default-select">
                            <option data-display="Room type"> </option>
                            <option value="Laxaries">Laxaries Rooms</option>
                            <option value="Deluxe">Deluxe Room</option>
                            <option value="Signature">Signature Room</option>
                            <option value="Couple">Couple Room</option>
                        </form:select>
                        <form:errors path="roomType"></form:errors> <br />
                    </div>
                </spring:bind>
                <spring:bind path="guests">
                    <div class="col-xl-6 ${status.error ? 'has-error' : ''}">
                        <label>Húespedes</label>
                        <form:select path="guests" class="form-control form-control-lg" id="default-select">
                            <option data-display="Adultos">0</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                        </form:select>
                        <form:errors path="guests"></form:errors> <br />
                    </div>
                </spring:bind>
            </div>
            <span>${error}</span><br/>
            <div class="row">
                <div class="col-xl-3 mx-auto">
                    <button type="submit" class="btn btn-primary btn-block">Aceptar</button>
                </div>
            </div>
        </form:form>
    </div>
    <c:if test="${pageContext.request.userPrincipal.name == null}">
        <p class="text-center">¿Todavía no estás registrado?</p>
        <p class="text-center"><a href="login">Log in</a></p>
    </c:if>

    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="vendor/popper/umd/popper.min.js"></script>

</body>

</html>