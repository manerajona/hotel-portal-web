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

    <div class="reservation-form">
        <form:form method="POST" modelAttribute="userForm" class="reservation-form">
            <h2 class="text-center">Usuario</h2>
            <div class="row">
            <spring:bind path="username">
                <div class="col-xl-6 ${status.error ? 'has-error' : ''}">
                    <label>Username</label><form:input path="username" type="text" class="form-control"
                        required="required" autofocus="true"></form:input> <br/>
                    <form:errors path="username"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="email">
                            <div class="col-xl-6">
                                <label>Correo electrónico</label><form:input path="email" type="email" class="form-control"
                                    required="required"></form:input> <br/>
                            </div>
                        </spring:bind>

            <spring:bind path="firstName">
                <div class="col-xl-6">
                    <label>Nombre</label><form:input path="firstName" type="text" class="form-control"
                        required="required"></form:input> <br/>
                </div>
            </spring:bind>

            <spring:bind path="lastName">
                <div class="col-xl-6">
                    <label>Apellido</label><form:input path="lastName" type="text" class="form-control"
                        required="required"></form:input> <br/>
                </div>
            </spring:bind>

            <spring:bind path="password">
                <div class="col-xl-6 ${status.error ? 'has-error' : ''}">
                    <label>Nuevo password</label><form:input path="password" type="password" class="form-control"
                        required="required"></form:input> <br/>
                    <form:errors path="password"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="passwordConfirm">
                <div class="col-xl-6 ${status.error ? 'has-error' : ''}">
                    <label>Confirmar password</label><form:input path="passwordConfirm" type="password" class="form-control"
                        required="required"></form:input> <br/>
                    <form:errors path="passwordConfirm"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="username">
            <div class="col-xl-3 mx-auto">
                <button type="submit" class="btn btn-primary btn-block">Guardar</button> </br>
            </div>
            </spring:bind>
            </div>
            <div class="col-xl-6 mx-auto">
                            <label class="checkbox-inline">
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