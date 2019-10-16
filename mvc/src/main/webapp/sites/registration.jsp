<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>

<jsp:include page="fragments/header.jsp">
<jsp:param name="title" value="Registración" />
</jsp:include>

<body>

    <div class="reservation-form">
        <form:form method="POST" modelAttribute="userForm" class="reservation-form">
            <h2 class="text-center">Usuario</h2>
            <div class="row">

                <spring:bind path="firstName">
                    <div class="col-xl-6">
                        <label>Nombre</label>
                        <form:input path="firstName" type="text" class="form-control" required="required"
                            autofocus="true" />
                        <br />
                    </div>
                </spring:bind>

                <spring:bind path="lastName">
                    <div class="col-xl-6">
                        <label>Apellido</label>
                        <form:input path="lastName" type="text" class="form-control" required="required" />
                        <br />
                    </div>
                </spring:bind>

                <spring:bind path="username">
                    <div class="col-xl-6 ${status.error ? 'has-error' : ''}">
                        <label>Username</label>
                        <form:input path="username" type="text" class="form-control" required="required" /><br />
                        <form:errors path="username"></form:errors>
                    </div>
                </spring:bind>

                <spring:bind path="email">
                    <div class="col-xl-6">
                        <label>Correo electrónico</label>
                        <form:input path="email" type="email" class="form-control" required="required" />
                        <br />
                    </div>
                </spring:bind>

                <spring:bind path="password">
                    <div class="col-xl-6 ${status.error ? 'has-error' : ''}">
                        <label>Nuevo password</label>
                        <form:input path="password" type="password" class="form-control" required="required" />
                        <br />
                        <form:errors path="password"></form:errors>
                    </div>
                </spring:bind>

                <spring:bind path="passwordConfirm">
                    <div class="col-xl-6 ${status.error ? 'has-error' : ''}">
                        <label>Confirmar password</label>
                        <form:input path="passwordConfirm" type="password" class="form-control" required="required" />
                        <br />
                        <form:errors path="passwordConfirm"></form:errors>
                    </div>
                </spring:bind>

                <div class="col-xl-3 mx-auto">
                    <button type="submit" class="btn btn-primary btn-block">Guardar</button> </br>
                </div>
            </div>
            <div class="col-xl-6 mx-auto">
                <label class="checkbox-inline">
                    <input type="checkbox" required="required"> Acepto términos y condiciones</label>
            </div>
        </form:form>

        <p class="text-center">¿Ya estás registrado?</p>
        <p class="text-center"><a href="login">Log in</a></p>

    </div>

    <jsp:include page="fragments/footer.jsp" />

</body>

</html>