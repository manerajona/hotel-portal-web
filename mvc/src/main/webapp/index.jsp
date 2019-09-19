<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Hotel portal web</title>

  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="css/landing-page.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
  <link href="vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

</head>

<body>

  <!-- Navigation -->
  <nav class="navbar navbar-light bg-light static-top">
    <div class="container">
      <a class="navbar-brand" href="index">Hotel Córdoba Inc.</a>
      <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="submit" onclick="document.forms['logoutForm'].submit()" value="Logout : ${pageContext.request.userPrincipal.name}" />
        </form>
      </c:if>
      <c:if test="${pageContext.request.userPrincipal.name == null}">
        <a class="btn btn-primary" href="login">Usuarios</a>
      </c:if>
    </div>
  </nav>

  <!-- Masthead -->
  <header class="masthead text-white text-center">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-xl-9 mx-auto">
          <h1 class="mb-5">Bienvenido!</h1>
        </div>
        <div class="col-md-12 col-lg-8 col-xl-7 mx-auto">
          <form>
            <div class="form-row">
              <div class="col-12 col-md-4 mb-2 mb-md-0">
                <input type="date" class="form-control form-control-lg" placeholder="Fecha de llegada...">
              </div>
              <div class="col-12 col-md-4 mb-2 mb-md-0">
                <input type="date" class="form-control form-control-lg" placeholder="Fecha de check...">
              </div>
              <div class="col-12 col-md-4">
                <a class="btn btn-block btn-lg btn-primary" href="reservation">Reservar</a>
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
            <p class="lead mb-0">Crea un usuario, reserva on-line y disfruta beneficios exclusivos.</p>
          </div>
        </div>
        <div class="col-lg-4">
          <div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
            <div class="features-icons-icon d-flex">
              <i class="icon-layers m-auto text-primary"></i>
            </div>
            <h3>Desayuno incluido</h3>
            <p class="lead mb-0">Con tu reserva incuimos desayuno de 8:00 a 11:00 am.</p>
          </div>
        </div>
        <div class="col-lg-4">
          <div class="features-icons-item mx-auto mb-0 mb-lg-3">
            <div class="features-icons-icon d-flex">
              <i class="icon-check m-auto text-primary"></i>
            </div>
            <h3>Check late</h3>
            <p class="lead mb-0">Reserva on-line y el día de tu partida te permitimos seguir disfrutando de nuestras instalacciones hasta las 18:00 hs.</p>
          </div>
        </div>
      </div>
    </div>
  </section>

  <!-- Image Showcases -->
  <section class="showcase">
    <div class="container-fluid p-0">
      <div class="row no-gutters">

        <div class="col-lg-6 order-lg-2 text-white showcase-img" style="background-image: url('img/bg-showcase-1.jpg');"></div>
        <div class="col-lg-6 order-lg-1 my-auto showcase-text">
          <h2>Desayuno buffet</h2>
          <p class="lead mb-0">Contamos una propuesta completa y nutritiva, compuesta por la mejor panadería regional, lácteos, yogures, cereales, frutas, embutidos, infusiones y cafetería.</p>
        </div>
      </div>
      <div class="row no-gutters">
        <div class="col-lg-6 text-white showcase-img" style="background-image: url('img/bg-showcase-2.jpg');"></div>
        <div class="col-lg-6 my-auto showcase-text">
          <h2>Junior Suites</h2>
          <p class="lead mb-0">Junior suites donde se destaca la luminosidad y la generosidad de los detalles, estimulando el descanso y relax de nuestros huéspedes, brindándoles las más completas amenities.</p>
        </div>
      </div>
      <div class="row no-gutters">
        <div class="col-lg-6 order-lg-2 text-white showcase-img" style="background-image: url('img/bg-showcase-3.jpg');"></div>
        <div class="col-lg-6 order-lg-1 my-auto showcase-text">
          <h2>Spa &amp; Relax</h2>
          <p class="lead mb-0">Con una ubicación excepcional y la posibilidad de descansar en nuestras instalaciones que incluyen spa.</p>
        </div>
      </div>
    </div>
  </section>

  <!-- map -->
  <section class="map">
      <iframe style="width: 100%; height: 350px; overflow: hidden; padding: 10px;" src="https://maps.google.com/?ll=-31.4200787,-64.1909648&z=17&t=m&output=embed"
                  height="100" width="100" frameborder="0" scrolling="no"></iframe>
  </section>

  <!-- Call to Action -->
  <section class="call-to-action text-white text-center">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-xl-9 mx-auto">
          <h2 class="mb-5">Dejanos tu mensaje</h2>
        </div>
        <div class="col-md-10 col-lg-8 col-xl-7 mx-auto">

          <form:form method="POST" modelAttribute="messageForm" >
            <div class="form-row">
              <div class="col-12 col-md-12 mb-2 mb-md-0">
                <spring:bind path="name">
                    <label>Nombre y Apellido</label><form:input path="name" class="form-control form-control-lg"
                        type="text" required="required"></form:input> <br/>
                </spring:bind>

                <spring:bind path="subject">
                    <label>Asunto</label><form:input path="subject" class="form-control form-control-lg"
                        type="text" required="required"></form:input> <br/>
                </spring:bind>

                <spring:bind path="email">
                    <label>Correo Electrónico</label><form:input path="email" class="form-control form-control-lg"
                        type="email" required="required"></form:input> <br/>
                </spring:bind>

                <spring:bind path="phone">
                    <label>Teléfono de contacto</label><form:input path="phone" class="form-control form-control-lg"
                        type="text" required="required"></form:input> <br/>
                </spring:bind>

                <spring:bind path="content">
                    <label>Mensaje</label><br/>
                    <form:textarea path="content" class="form-control form-control-lg" cols="60" rows="4" required="required"/><br/>
                </spring:bind>

              </div>
              <div class="col-xl-8 mx-auto">
                <input type="submit" class="btn btn-block btn-lg btn-primary" value="Enviar">
              </div>
            </div>
          </form:form>

        </div>
      </div>
    </div>
  </section>

  <!-- Footer -->
  <footer class="footer bg-light">
    <div class="container">
      <div class="row">
        <div class="col-lg-6 h-100 text-center text-lg-left my-auto">
          <ul class="list-inline mb-2">
            <li class="list-inline-item">
              <a href="#">Sobre nosotros</a>
            </li>
            <li class="list-inline-item">&sdot;</li>
            <li class="list-inline-item">
              <a <a href="mailto:hello@cordobahotel.com.ar?Subject=Nueva%20consulta" target="_top">Contacto</a>
            </li>
            <li class="list-inline-item">&sdot;</li>
            <li class="list-inline-item">
              <a href="#">Ubicación</a>
            </li>
            <li class="list-inline-item">&sdot;</li>
            <li class="list-inline-item">
              <a href="#">Reservas online</a>
            </li>
          </ul>
          <p class="text-muted small mb-4 mb-lg-0">Hotel Córdoba Inc. 2019. Todos los derechos reservados.</p>
        </div>
        <div class="col-lg-6 h-100 text-center text-lg-right my-auto">
          <ul class="list-inline mb-0">
            <li class="list-inline-item mr-3">
              <a href="#">
                <i class="fab fa-facebook fa-2x fa-fw"></i>
              </a>
            </li>
            <li class="list-inline-item mr-3">
              <a href="#">
                <i class="fab fa-twitter-square fa-2x fa-fw"></i>
              </a>
            </li>
            <li class="list-inline-item">
              <a href="#">
                <i class="fab fa-instagram fa-2x fa-fw"></i>
              </a>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Controller -->
  <script src="js/controller.js"></script>

</body>

</html>
