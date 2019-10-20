<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<spring:url value="/user/password/update" var="passwordUrl" />

<form:form method="POST" modelAttribute="passwordForm" class="form-signin" action="${passwordUrl}">
    <h3 class="text-center">Nuevo Password</h3>
    <c:if test="${not empty message}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">×</span>
            </button>
            <strong>${message}</strong>
        </div>
    </c:if>
    <spring:bind path="username">
        <div class="${status.error ? 'has-error' : ''}">
            <form:input path="username" placeholder="Username" type="text" class="form-control" required="required"
                autofocus="true" />
            <strong>
                <form:errors path="username"></form:errors>
            </strong>
        </div>
    </spring:bind>

    <spring:bind path="oldPassword">
        <div class="${status.error ? 'has-error' : ''}">
            <form:input path="oldPassword" placeholder="Password actual" type="password" class="form-control"
                required="required" />
            <strong>
                <form:errors path="oldPassword"></form:errors>
            </strong>
        </div>
    </spring:bind>

    <spring:bind path="newPassword">
        <div class="${status.error ? 'has-error' : ''}">
            <form:input path="newPassword" placeholder="Nuevo password" type="password" class="form-control"
                required="required" />
            <strong>
                <form:errors path="newPassword"></form:errors>
            </strong>
        </div>
    </spring:bind>

    <spring:bind path="passwordConfirm">
        <div class="${status.error ? 'has-error' : ''}">
            <form:input path="passwordConfirm" placeholder="Confirmar password" type="password" class="form-control"
                required="required" />
            <strong>
                <form:errors path="passwordConfirm"></form:errors>
            </strong>
        </div>
    </spring:bind>
    <button type="submit" class="btn btn-primary btn-block">Guardar</button>
</form:form>