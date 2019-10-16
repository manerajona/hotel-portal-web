<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>

<jsp:include page="fragments/header.jsp">
<jsp:param name="title" value="Auditoría" />
</jsp:include>

<body>

    <div class="container">

        <div id="message-table">
            <br>
            <h4>Mensajes</h4>

            <div class="table table-sm">
                <input id="txtMessage" type="text" class="form-control form-control-sm" onkeyup="filterMessages(event)"
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
                            <th scope="col"></th>
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
                                <td>
                                    <spring:url value="/audit/message/${message.getId()}/delete" var="deleteUrl" />
                                    <button class="btn btn-danger btn-sm"
                                        onclick="this.disabled=true;post('${deleteUrl}')">Eliminar</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <div id="reservation-table">
            <br>
            <h4>Reservas</h4>
            <div class="table table-sm">
                <input id="txtReservation" type="text" class="form-control form-control-sm"
                    onkeyup="filterReservations(event)" placeholder="Buscar reservaciones..">

                <table id="tbReservation" class="table">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">Check in</th>
                            <th scope="col">Check out</th>
                            <th scope="col">Habitación</th>
                            <th scope="col">Huéspedes</th>
                            <th scope="col">Usuario</th>
                            <th scope="col"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="reservation" items="${reservations}">
                            <tr>
                                <td><input value="${reservation.checkIn}" /></td>
                                <td><input value="${reservation.checkOut}" /></td>
                                <td><input value="${reservation.roomType}" /></td>
                                <td><input value="${reservation.guests}" /></td>
                                <td>${reservation.username}</td>
                                <td>
                                    <spring:url value="/audit/reservation/${reservation.id}/delete" var="deleteUrl" />
                                    <spring:url value="/audit/reservation/${reservation.id}/update" var="updateUrl" />
                                    <button class="btn btn-success btn-sm"
                                        onclick="location.href='${updateUrl}'">Actualizar</button>
                                    <button class="btn btn-danger btn-sm"
                                        onclick="this.disabled=true;post('${deleteUrl}')">Eliminar</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <div id="user-table">
            <br>
            <h4>Usuarios</h4>
            <div class="table table-sm">
                <input id="txtUser" type="text" class="form-control form-control-sm" onkeyup="filterUser(event)"
                    placeholder="Buscar usuario..">

                <table id="tbUser" class="table">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">Nombre</th>
                            <th scope="col">Apellido</th>
                            <th scope="col">E-mail</th>
                            <th scope="col">Usuario</th>
                            <th scope="col">Rol</th>
                            <th scope="col"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="user" items="${users}">
                            <tr>
                                <td>${user.firstName}</td>
                                <td>${user.lastName}</td>
                                <td>${user.email}</td>
                                <td>${user.username}</td>
                                <td>
                                    <c:forEach var="role" items="${user.roles}"> ${role.role} </c:forEach>
                                </td>
                                <td>

                                    <spring:url value="/audit/user/${user.getId()}/delete" var="deleteUrl" />
                                    <c:if test="${user.username!='admin'}">
                                        <button class="btn btn-danger btn-sm"
                                            onclick="this.disabled=true;post('${deleteUrl}')">Eliminar</button>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <jsp:include page="fragments/footer.jsp" />

    <script src="js/audit.js"></script>

</body>

</html>