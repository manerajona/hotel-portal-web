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
    <jsp:param name="title" value="Auditoría" />
</jsp:include>

<div class="site-container">
    <jsp:include page="fragments/tables/message-table.jsp" />
    <jsp:include page="fragments/tables/reservation-table.jsp">
        <jsp:param name="isEditable" value="false" />
    </jsp:include>
    <jsp:include page="fragments/tables/user-table.jsp" />
</div>

<jsp:include page="fragments/footer.jsp" />

<script src="js/audit.js"></script>
<script src="js/controller.js"></script>

</body>

</html>