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
    <link href="css/landing-page.css" rel="stylesheet">

</head>

<body>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="collapse navbar-collapse" id="navegacion">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="navbar-brand" href="index">Hotel Córdoba Inc.</a>
                </li>
            </ul>
        </div>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <form id="logoutForm" method="POST" action="${contextPath}/logout">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <input type="submit" onclick="document.forms['logoutForm'].submit()"
                    value="Logout | ${pageContext.request.userPrincipal.name}" />
            </form>
        </c:if>
    </nav>
    <br>
    <h2>Mensajes</h2>
    <div class="table-responsive">
        <input id="txtMessage" type="text" class="form-control form-control-lg" onkeyup="filterMessages(event)"
            placeholder="Buscar mensajes..">

        <table id="tbMessage" class="table">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Contenido</th>
                    <th scope="col">Titulo</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">E-mail</th>
                    <th scope="col">Teléfono</th>
                    <th scope="col">Usuario</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="message" items="${messages}">
                    <tr>
                        <td>${message.content}</td>
                        <td>${message.subject}</td>
                        <td>${message.name}</td>
                        <td>${message.email}</td>
                        <td>${message.phone}</td>
                        <td>${message.username}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <br>
    <h2>Reservas</h2>
    <div class="table-responsive">
        <input id="txtReservation" type="text" class="form-control form-control-lg" onkeyup="filterReservations(event)"
            placeholder="Buscar reservaciones..">

        <table id="tbReservation" class="table">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Check in</th>
                    <th scope="col">Check out</th>
                    <th scope="col">Habitación</th>
                    <th scope="col">Huéspedes</th>
                    <th scope="col">Usuario</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="reservation" items="${reservations}">
                    <tr>
                        <td>${reservation.checkIn}</td>
                        <td>${reservation.checkOut}</td>
                        <td>${reservation.roomType}</td>
                        <td>${reservation.guests}</td>
                        <td>${reservation.username}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <br>
    <h2>Users</h2>
    <div class="table-responsive">
        <input id="txtUser" type="text" class="form-control form-control-lg" onkeyup="filterUser(event)"
            placeholder="Buscar usuario..">

        <table id="tbUser" class="table">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Nombre</th>
                    <th scope="col">Apellido</th>
                    <th scope="col">E-mail</th>
                    <th scope="col">Usuario</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.email}</td>
                        <td>${user.username}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>


    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="vendor/popper/umd/popper.min.js"></script>
    <script src="js/audit.js"></script>

</body>

</html>