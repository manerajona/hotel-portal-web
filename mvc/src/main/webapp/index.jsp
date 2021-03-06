<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="es">

<jsp:include page="sites/fragments/header.jsp">
  <jsp:param name="title" value="Home" />
</jsp:include>

<!-- call to action -->
<header class="masthead text-white text-center">
  <div class="overlay"></div>
  <div class="container">

    <c:if test="${not empty message}">
      <div class="alert alert-${css} alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
          <span aria-hidden="true">×</span>
        </button>
        <strong>${message}</strong>
      </div>
    </c:if>

    <div class="row">
      <div class="col-xl-9 mx-auto">
        <h1 class="mb-5">Bienvenido!</h1>
      </div>
      <div class="col-md-12 col-lg-8 col-xl-7 mx-auto">
        <form id="reservationForm" name="reservationForm" method="post" onsubmit="return OnSubmitReservationForm();">
          <div class="form-row">
            <div class="col-12 col-md-4 mb-2 mb-md-0">
              <input type="date" name="dateIn" id="dateIn" pattern="dd/MM/yyyy" class="form-control form-control-lg"
                placeholder="Check in" required="required">
            </div>
            <div class="col-12 col-md-4 mb-2 mb-md-0">
              <input type="date" name="dateOut" id="dateOut" pattern="dd/MM/yyyy" class="form-control form-control-lg"
                placeholder="Check out" required="required">
            </div>
            <div class="col-12 col-md-4">
              <input type="submit" class="btn btn-block btn-lg btn-primary" value="Reservar">
            </div>
          </div>
        </form>

      </div>
    </div>
  </div>
</header>

<!-- Icons Grid -->
<section class="features-icons bg-light text-center">
  <div class="container">
    <div class="row">
      <div class="col-lg-4">
        <div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
          <div class="features-icons-icon d-flex">
            <i class="icon-screen-desktop m-auto text-primary"></i>
          </div>
          <h3>Reservas Online</h3>
          <p class="lead mb-0">Crea un usuario y hace tu reserva on-line.</p>
        </div>
      </div>
      <div class="col-lg-4">
        <div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
          <div class="features-icons-icon d-flex">
            <i class="icon-layers m-auto text-primary"></i>
          </div>
          <h3>Desayuno incluido</h3>
          <p class="lead mb-0">Desayuno buffet de 8:00 a 11:00 am.</p>
        </div>
      </div>
      <div class="col-lg-4">
        <div class="features-icons-item mx-auto mb-0 mb-lg-3">
          <div class="features-icons-icon d-flex">
            <i class="icon-check m-auto text-primary"></i>
          </div>
          <h3>Check late</h3>
          <p class="lead mb-0">El día de tu partida te permitimos seguir disfrutando de nuestras instalacciones hasta
            las 18:00 hs.</p>
        </div>
      </div>
    </div>
  </div>
</section>

<!-- Image Showcases -->
<section class="showcase">
  <div class="container-fluid p-0">
    <div class="row no-gutters">

      <div class="col-lg-6 order-lg-2 text-white showcase-img" style="background-image: url('img/bg-showcase-1.jpg');">
      </div>
      <div class="col-lg-6 order-lg-1 my-auto showcase-text">
        <h2>Desayuno buffet</h2>
        <p class="lead mb-0">Contamos una propuesta completa y nutritiva, compuesta por la mejor panadería regional,
          lácteos, yogures, cereales, frutas, embutidos, infusiones y cafetería.</p>
      </div>
    </div>
    <div class="row no-gutters">
      <div class="col-lg-6 text-white showcase-img" style="background-image: url('img/bg-showcase-2.jpg');"></div>
      <div class="col-lg-6 my-auto showcase-text">
        <h2>Junior Suites</h2>
        <p class="lead mb-0">Junior suites donde se destaca la luminosidad y la generosidad de los detalles,
          estimulando el descanso y relax de nuestros huéspedes, brindándoles las más completas amenities.</p>
      </div>
    </div>
    <div class="row no-gutters">
      <div class="col-lg-6 order-lg-2 text-white showcase-img" style="background-image: url('img/bg-showcase-3.jpg');">
      </div>
      <div class="col-lg-6 order-lg-1 my-auto showcase-text">
        <h2>Spa &amp; Relax</h2>
        <p class="lead mb-0">Con una ubicación excepcional y la posibilidad de descansar en nuestras instalaciones que
          incluyen spa.</p>
      </div>
    </div>
  </div>
</section>

<!-- Map -->
<section class="map bg-light">
  <div class="row">
    <div class="col-xl-12">
      <iframe style="width: 100%; height: 350px; overflow: hidden; padding: 10px;"
        src="https://maps.google.com/?ll=-31.4200787,-64.1909648&z=17&t=m&output=embed" height="100" width="100"
        frameborder="0" scrolling="no"></iframe>
    </div>
  </div>
</section>

<!-- Message -->
<section class="call-to-action text-white text-center">
  <div class="overlay"></div>
  <div class="container">
    <div class="row">
      <div class="col-xl-9 mx-auto">
        <h2 class="mb-5">Dejanos tu mensaje</h2>
      </div>
      <div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
        <jsp:include page="sites/fragments/forms/message-form.jsp" />
      </div>
    </div>
  </div>
</section>

<jsp:include page="sites/fragments/footer.jsp" />

<script src="${contextPath}/js/index.js"></script>

</body>

</html>