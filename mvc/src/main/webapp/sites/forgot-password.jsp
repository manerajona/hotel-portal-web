<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>

<jsp:include page="fragments/header.jsp">
    <jsp:param name="title" value="Forgot" />
</jsp:include>

<div class="login-form">

    <form:form method="POST" modelAttribute="userForm" action="${contextPath}/user/password/forgot" class="form-signin">

        <h4 class="text-center">Olvidé mi contraseña</h4>
        <c:if test="${not empty message}">
            <div class="alert alert-${css} alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <strong>${message}</strong>
            </div>
        </c:if>
        <c:choose>
            <c:when test="${css != 'success'}">
                <label>Ingresa tu email y te enviaremos un correo para cambiar tu contraseña,</label>
                <spring:bind path="email">
                    <form:input path="email" name="email" type="email" class="form-control"
                        placeholder="email@something.com" required="required" autofocus="true" />
                </spring:bind>
                <button type="submit" class="btn btn-primary btn-block">Enviar</button>
            </c:when>
            <c:otherwise>
                <p class="text-center"><a href="${contextPath}/index">Volver</a></p>
            </c:otherwise>
        </c:choose>

    </form:form>

</div>

<jsp:include page="fragments/footer.jsp" />

</body>

</html>