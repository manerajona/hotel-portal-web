<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>

<jsp:include page="fragments/header.jsp">
    <jsp:param name="title" value="Mis reservas" />
</jsp:include>

<div class="site-container">

    <jsp:include page="fragments/tables/reservation-table.jsp">
        <jsp:param name="isEditable" value="true" />
    </jsp:include>
</div>

<jsp:include page="fragments/footer.jsp" />

<script src="${contextPath}/js/audit.js"></script>
<script src="${contextPath}/js/controller.js"></script>

</body>

</html>