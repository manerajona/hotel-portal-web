<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
  <meta charset="utf-8">
  <title>Córdoba Hotel - ${param.title}</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="css/landing-page.css" rel="stylesheet">
  <link href="css/sites.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
  <link href="vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet" type="text/css">
</head>

<spring:url value="/" var="urlHome" />
<spring:url value="/users/add" var="urlAddUser" />

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="collapse navbar-collapse" id="navegacion">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="navbar-brand" href="index">Hotel Córdoba Inc.</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#" data-toggle="modal" data-target="#aboutModal">Acerca del Hotel</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="reservation">Reservas online</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="audit">Auditoría</a>
      </li>
    </ul>
  </div>
  <c:if test="${pageContext.request.userPrincipal.name != null}">
    <form id="logoutForm" method="POST" action="${contextPath}/logout">
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
      <input type="submit" onclick="document.forms['logoutForm'].submit()"
      class="btn btn-default btn-lg"
        value="Logout">
        <span>${pageContext.request.userPrincipal.name}</span>
        </input>
    </form>
  </c:if>
  <c:if test="${pageContext.request.userPrincipal.name == null}">
    <a class="btn btn-primary" href="login">LogIn</a>
  </c:if>
</nav>