<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<spring:url value="/index" var="indexUrl" />

<form:form method="POST" modelAttribute="messageForm" action="${indexUrl}">
          <div class="form-row">
            <div class="col-12 col-md-12 mb-2 mb-md-0">
              <spring:bind path="name">
                <label>Nombre y Apellido</label>
                <form:input path="name" class="form-control form-control-lg" type="text" required="required" />
                <br />
              </spring:bind>

              <spring:bind path="subject">
                <label>Asunto</label>
                <form:input path="subject" class="form-control form-control-lg" type="text" required="required" />
                <br />
              </spring:bind>

              <spring:bind path="email">
                <label>Correo Electrónico</label>
                <form:input path="email" class="form-control form-control-lg" type="email" required="required" />
                <br />
              </spring:bind>

              <spring:bind path="phone">
                <label>Teléfono de contacto</label>
                <form:input path="phone" class="form-control form-control-lg" type="text" required="required" />
                <br />
              </spring:bind>

              <spring:bind path="content">
                <label>Mensaje</label><br />
                <form:textarea path="content" class="form-control form-control-lg" cols="50" rows="5" maxlength="250"
                  required="required" /> <br />
              </spring:bind>

            </div>
            <div class="col-xl-6 mx-auto">
              <input type="submit" class="btn btn-block btn-lg btn-primary" value="Enviar">
            </div>
          </div>
        </form:form>