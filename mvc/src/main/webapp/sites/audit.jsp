<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>

<jsp:include page="fragments/header.jsp">
    <jsp:param name="title" value="Auditoría" />
</jsp:include>

<div class="container">

    <div id="message-table">

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
                            <td><textarea rows="2" cols="30" readonly>${message.content}</textarea></td>
                            <td>${message.subject}</td>
                            <td>${message.name}</td>
                            <td>${message.email}</td>
                            <td>${message.phone}</td>
                            <td>${message.username}</td>
                            <td>
                                <spring:url value="/message/${message.getId()}/delete" var="deleteUrl" />
                                <button class="btn btn-danger btn-lg" onclick="this.disabled=true;post('${deleteUrl}')">
                                    <span class="iconify" data-icon="simple-line-icons:trash"
                                        data-inline="false"></span>
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <div id="reservation-table">

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
                            <td>${reservation.checkIn}</td>
                            <td>${reservation.checkOut}</td>
                            <td>${reservation.roomType}</td>
                            <td>${reservation.guests}</td>
                            <td>${reservation.username}</td>
                            <td>
                                <spring:url value="/reservation/${reservation.id}/delete" var="deleteUrl" />
                                <spring:url value="/reservation/${reservation.id}/update" var="updateUrl" />
                                <button class="btn btn-danger btn-lg" onclick="this.disabled=true;post('${deleteUrl}')">
                                    <span class="iconify" data-icon="simple-line-icons:trash"
                                        data-inline="false"></span>
                                </button>
                                <button class="btn btn-success btn-lg" onclick="location.href='${updateUrl}'">
                                    <span class="iconify" data-icon="ic:outline-edit" data-inline="false"></span>
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <div id="user-table">

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

                                <spring:url value="/user/${user.id}/delete" var="deleteUrl" />
                                <spring:url value="#" var="updateUrl" />
                                <c:if test="${user.username!='admin'}">
                                    <button class="btn btn-danger btn-lg"
                                        onclick="this.disabled=true;post('${deleteUrl}')">
                                        <span class="iconify" data-icon="simple-line-icons:trash"
                                            data-inline="false"></span>
                                    </button>
                                    <button class="btn btn-success btn-lg" onclick="location.href='${updateUrl}'"><span
                                            class="iconify" data-icon="ic:outline-edit" data-inline="false"></span>
                                    </button>
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
<script src="js/controller.js"></script>

</body>

</html>