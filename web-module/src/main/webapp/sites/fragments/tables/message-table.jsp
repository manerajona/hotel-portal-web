<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div id="message-table">

    <h4>Mensajes</h4>

    <div class="table table-sm">
        <input id="txtMessage" type="text" class="form-control form-control-sm" onkeyup="filterMessages(event)"
            placeholder="Buscar mensajes..">

        <table id="tbMessage" class="table table-striped table-light">
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
                        <td class="text-center">
                            <spring:url value="/message/${message.getId()}/delete" var="deleteUrl" />
                            <button class="btn btn-danger btn-lg" onclick="this.disabled=true;post('${deleteUrl}')">
                                <span class="iconify" data-icon="simple-line-icons:trash" data-inline="false"></span>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>