<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
