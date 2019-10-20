<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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

