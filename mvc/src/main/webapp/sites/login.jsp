<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>

<jsp:include page="fragments/header.jsp">
    <jsp:param name="title" value="Log In" />
</jsp:include>



<div class="login-form">
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
            <input name="username" type="text" class="form-control" placeholder="Username" required="required"
                autofocus="true">
            <input name="password" type="password" class="form-control" placeholder="Password" required="required">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

            <button type="submit" class="btn btn-primary btn-block">Ingresar</button>
            <div class="clearfix">
                        <a href="#" class="pull-left">Cambiar mi contraseña</a>
                    </div>
        </div>
    </form>
    <p class="text-center">¿Todavía no estás registrado?</p>
    <p class="text-center"><a href="registration">Nuevo usuario</a></p>
</div>

<jsp:include page="fragments/footer.jsp" />

</body>

</html>