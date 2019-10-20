<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<spring:url value="/user/password" var="passwordUrl" />

<form method="POST" action="${contextPath}/login" class="form-signin">

    <h2 class="text-center">Log in</h2>
    <c:if test="${not empty message}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">×</span>
            </button>
            <strong>${message}</strong>
        </div>
    </c:if>
    <input name="username" type="text" class="form-control" placeholder="Username" required="required" autofocus="true">
    <input name="password" type="password" class="form-control" placeholder="Password" required="required">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <button type="submit" class="btn btn-primary btn-block">Ingresar</button>
    <div class="col-xl-12 my-3">
        <a href="#" class="pull-left">Olvidé mi contraseña</a>
    </div>

</form>