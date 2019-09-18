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
    <title>Usuario nuevo</title>

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

    <div class="login-form">
        <form:form method="POST" modelAttribute="userForm">
            <h2 class="text-center">Usuario</h2>

            <spring:bind path="username">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label>Username</label><form:input path="username" type="text" class="form-control"
                        required="required" autofocus="true"></form:input>
                    <form:errors path="username"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="firstName">
                <div class="form-group">
                    <label>Nombre</label><form:input path="firstName" type="text" class="form-control"
                        required="required"></form:input>
                </div>
            </spring:bind>

            <spring:bind path="lastName">
                <div class="form-group">
                    <label>Apellido</label><form:input path="lastName" type="text" class="form-control"
                        required="required"></form:input>
                </div>
            </spring:bind>

            <spring:bind path="email">
                <div class="form-group">
                    <label>Correo electrónico</label><form:input path="email" type="email" class="form-control"
                        required="required"></form:input>
                </div>
            </spring:bind>

            <spring:bind path="password">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label>Nuevo password</label><form:input path="password" type="password" class="form-control"
                        required="required"></form:input>
                    <form:errors path="password"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="passwordConfirm">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label>Confirmar password</label><form:input path="passwordConfirm" type="password" class="form-control"
                        required="required"></form:input>
                    <form:errors path="passwordConfirm"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="username">
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block">Guardar</button>
            </div>
            </spring:bind>

            <div class="clearfix">
                <label class="pull-left checkbox-inline">
                <input type="checkbox" required="required"> Acepto términos y condiciones</label>
            </div>
        </form:form>
    </div>

	<script src ="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="js/newUser.js"></script>

    <!-- Controller -->
    <script src="js/controller.js"></script>

</body>

</html>