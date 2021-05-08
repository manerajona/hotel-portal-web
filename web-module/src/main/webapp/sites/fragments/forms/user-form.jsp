<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<spring:url value="/registration" var="registrationUrl" />

<form:form method="POST" modelAttribute="userForm" class="site-form" action="${registrationUrl}">
    <h2 class="text-center">Nuevo Usuario</h2>

    <div class="row">

        <form:hidden path="id" />

        <spring:bind path="firstName">
            <div class="col-xl-6 mt-3 ${status.error ? 'has-error' : ''}">
                <label>* Nombre</label>
                <form:input path="firstName" type="text" class="form-control" autofocus="true" />
                <strong>
                    <form:errors path="firstName"></form:errors>
                </strong>
            </div>
        </spring:bind>

        <spring:bind path="lastName">
            <div class="col-xl-6 mt-3 ${status.error ? 'has-error' : ''}">
                <label>* Apellido</label>
                <form:input path="lastName" type="text" class="form-control" />
                <strong>
                    <form:errors path="lastName"></form:errors>
                </strong>
            </div>
        </spring:bind>

        <spring:bind path="username">
            <div class="col-xl-6 mt-3 ${status.error ? 'has-error' : ''}">
                <label>* Username</label>
                <form:input path="username" type="text" class="form-control" />
                <strong>
                    <form:errors path="username"></form:errors>
                </strong>
            </div>
        </spring:bind>

        <spring:bind path="email">
            <div class="col-xl-6 mt-3 ${status.error ? 'has-error' : ''}">
                <label>* Correo electrónico</label>
                <form:input path="email" type="email" class="form-control" />
                <strong>
                    <form:errors path="email"></form:errors>
                </strong>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <div class="col-xl-6 mt-3 ${status.error ? 'has-error' : ''}">
                <label>* Nueva Contraseña</label>
                <form:input path="password" type="password" class="form-control" />
                <strong>
                    <form:errors path="password"></form:errors>
                </strong>
            </div>
        </spring:bind>

        <spring:bind path="passwordConfirm">
            <div class="col-xl-6 mt-3 ${status.error ? 'has-error' : ''}">
                <label>* Confirmar contraseña</label>
                <form:input path="passwordConfirm" type="password" class="form-control" />
                <strong>
                    <form:errors path="passwordConfirm"></form:errors>
                </strong>
            </div>
        </spring:bind>

        <div class="col-xl-6 mx-auto my-3">
            <button type="submit" class="btn btn-primary btn-block">Guardar</button>
        </div>
    </div>
    <div class="col-xl-6 mx-auto mt-3">
        <label class="checkbox-inline">
            <input type="checkbox" required="required"> Acepto términos y condiciones</label>
    </div>

</form:form>