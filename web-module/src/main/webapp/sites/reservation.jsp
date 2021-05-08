<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>

<jsp:include page="fragments/header.jsp">
    <jsp:param name="title" value="Reservación" />
</jsp:include>

<div class="site-form">
    <jsp:include page="fragments/forms/reservation-form.jsp" />
</div>

<jsp:include page="fragments/footer.jsp" />

</body>

</html>