<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<head>
  <meta charset="utf-8">
  <title>Córdoba Hotel - ${param.title}</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <link href="${contextPath}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="${contextPath}/css/landing-page.css" rel="stylesheet">
  <link href="${contextPath}/css/sites.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="${contextPath}/vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
  <link href="${contextPath}/vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet" type="text/css">
</head>

<spring:url value="/" var="urlHome" />
<spring:url value="/users/add" var="urlAddUser" />

<!-- Navigation -->
<div class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="collapse navbar-collapse" id="navegacion">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="navbar-brand" href="${contextPath}/index">Hotel Córdoba Inc.</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#" data-toggle="modal" data-target="#aboutModal">Acerca del Hotel</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${contextPath}/reservation">Reservas online</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${contextPath}/audit">Auditoría</a>
      </li>
    </ul>
  </div>
  <c:choose>
    <c:when test="${pageContext.request.userPrincipal.name != null}">
      <form id="logoutForm" method="POST" action="${contextPath}/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <input type="submit" onclick="document.forms['logoutForm'].submit()" class="btn btn-default btn-lg"
          value="Logout">
        <span class="iconify" data-icon="ant-design:user-outline" data-inline="false"></span>
        ${pageContext.request.userPrincipal.name}
        </input>
      </form>
    </c:when>
    <c:otherwise>
      <a class="btn btn-primary" href="${contextPath}/login">
        <span class="iconify" data-icon="oi-account-login" data-inline="false"></span>
        Log In</a>
    </c:otherwise>
  </c:choose>
</div>