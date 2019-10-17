<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<jsp:include page="sites/fragments/header.jsp">
<jsp:param name="title" value="Error" />
</jsp:include>

	<div class="container">

		<h1>Algo salió mal :´(</h1>

		<p>${exception.message}</p>

		  	<c:forEach items="${exception.stackTrace}" var="stackTrace"> 
				${stackTrace} 
			</c:forEach>


	</div>

	<jsp:include page="sites/fragments/footer.jsp" />

</body>
</html>