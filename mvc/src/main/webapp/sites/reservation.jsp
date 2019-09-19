<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

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
        <form method="POST" action="${contextPath}/reservation" class="form-reservation">
            <h2 class="text-center">Hace tu reserva</h2>

            <div class="row">
                                          <div class="col-xl-6">
                                              <input type="date" class="form-control form-control-lg" placeholder="Check in"> <br/>
                                          </div>
                                          <div class="col-xl-6">
                                              <input type="date" class="form-control form-control-lg" placeholder="Check out"> <br/>
                                          </div>
                                          <div class="col-xl-6">
                                              <select class="form-control form-control-lg" id="default-select">
                                                <option data-display="Room type">Room type</option>
                                                <option value="1">Laxaries Rooms</option>
                                                <option value="2">Deluxe Room</option>
                                                <option value="3">Signature Room</option>
                                                <option value="4">Couple Room</option>
                                                </select> <br/>
                                          </div>
                                          <div class="col-xl-6">
                                              <select class="form-control form-control-lg" id="default-select">
                                                  <option data-display="Children">1</option>
                                                  <option value="1">2</option>
                                                  <option value="2">3</option>
                                                  <option value="3">4</option>
                                              </select> <br/>
                                          </div>
                                          <div class="col-xl-3 mx-auto">
                                              <button type="submit" class="btn btn-primary btn-block">Aceptar</button>
                                          </div>
                                      </div>
        </form>
        <p class="text-center">Todavía no estás registrado?</p>
        <p class="text-center"><a href="registration">Nuevo usuario</a></p>
    </div>

	<script src ="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Controller -->
    <script src="js/controller.js"></script>

</body>

</html>