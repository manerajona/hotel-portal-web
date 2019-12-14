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

    <form:form method="POST" modelAttribute="passwordForm" action="${contextPath}/user/password/reset" class="form-signin">

        <h4 class="text-center">Cambiar mi contraseña</h4>
        <c:if test="${not empty message}">
            <div class="alert alert-${css} alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <strong>${message}</strong>
            </div>
        </c:if>

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

</div>

<jsp:include page="fragments/footer.jsp" />

</body>

</html>