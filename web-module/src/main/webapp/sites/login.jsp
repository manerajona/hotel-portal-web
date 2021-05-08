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
    <jsp:param name="title" value="Log In" />
</jsp:include>

<div class="login-form">
    <c:choose>
        <c:when test="${passwordForm != null}">
            <jsp:include page="fragments/forms/password-form.jsp" />
        </c:when>
        <c:otherwise>
            <jsp:include page="fragments/forms/login-form.jsp" />
            <p class="text-center">¿Todavía no estás registrado?</p>
            <p class="text-center"><a href="${contextPath}/registration">Nuevo usuario</a></p>
        </c:otherwise>
    </c:choose>
</div>

<jsp:include page="fragments/footer.jsp" />

</body>

</html>