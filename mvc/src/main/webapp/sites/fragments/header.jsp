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

  <div class="collapse navbar-collapse">
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

    <ul class="navbar-nav ml-auto nav-flex-icons">
      <c:choose>
        <c:when test="${pageContext.request.userPrincipal.name != null}">
          <li class="nav-item">
          <a class="nav-link waves-effect waves-light">${pageContext.request.userPrincipal.name}
          </a>
          </li>
          <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink-333" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false"> <i class="fas fa-user"></i>
                  </a>

                  <spring:url value="/user/password" var="passwordUrl" />
                  <spring:url value="/my-reserv" var="reservationsUrl" />
                  <spring:url value="document.forms['logoutForm'].submit()" var="logoutUrl" />

                  <div class="dropdown-menu dropdown-menu-right dropdown-default"
                    aria-labelledby="navbarDropdownMenuLink-333">
                    <a class="dropdown-item" href="${passwordUrl}">Cambiar password</a>
                    <a class="dropdown-item" href="${reservationsUrl}">Mis reservaciones</a>
                    <form id="logoutForm" method="POST" action="${contextPath}/logout">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                <button type="submit" onclick="${logoutUrl}" class="dropdown-item">
                                <span class="iconify" data-icon="oi-account-logout" data-inline="false"></span> Salir</button>
                              </form>
                  </div>
                </li>
        </c:when>
        <c:otherwise>
          <li class="nav-item">
            <a class="nav-link waves-effect waves-light" href="${contextPath}/registration">
              <span class="iconify" data-icon="ant-design:user-add-outline" data-inline="false"></span> Nuevo usuario</a>
          </li>
          <li class="nav-item">
            <a class="nav-link waves-effect waves-light" href="${contextPath}/login">
              <span class="iconify" data-icon="oi-account-login" data-inline="false"></span> Login</a>
          </li>
        </c:otherwise>
      </c:choose>
    </ul>

</div>
</nav>