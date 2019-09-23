<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Login</title>

    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/sites.css" rel="stylesheet">
    <link href="css/landing-page.css" rel="stylesheet">
</head>

<body>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="collapse navbar-collapse" id="navegacion">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="navbar-brand" href="index">Hotel Córdoba Inc.</a>
            </ul>
        </div>
    </nav>

    <div class="login-form">
        <form method="POST" action="${contextPath}/login" class="form-signin">
            <h2 class="text-center">Log in</h2>

            <div class="form-group {error != null ? 'has-error' : ''}">
                <span>${message}</span>
                <input name="username" type="text" class="form-control" placeholder="Username" required="required"
                    autofocus="true">
                <input name="password" type="password" class="form-control" placeholder="Password" required="required">
                <span>${error}</span>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

                <button type="submit" class="btn btn-primary btn-block">Ingresar</button>
            </div>
            <div class="clearfix">
                <a href="#" class="pull-left">Olvidé mi contraseña</a>
            </div>
        </form>
        <p class="text-center">¿Todavía no estás registrado?</p>
        <p class="text-center"><a href="registration">Nuevo usuario</a></p>
    </div>

    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="vendor/popper/umd/popper.min.js"></script>

</body>

</html>