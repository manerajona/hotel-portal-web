<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!-- Footer -->
<footer class="footer bg-light">
  <div class="container">
    <div class="row">
      <div class="col-lg-6 h-100 text-center text-lg-left my-auto">
        <ul class="list-inline mb-2">
          <li class="list-inline-item">
            <a href="#" data-toggle="modal" data-target="#aboutModal">Acerca del Hotel</a>
          </li>
          <li class="list-inline-item">&sdot;</li>
          <li class="list-inline-item">
            <a href="mailto:hello@cordobahotel.com.ar?Subject=Nueva%20consulta" target="_top">Contacto</a>
          </li>
          <li class="list-inline-item">&sdot;</li>
          <li class="list-inline-item">
            <a href="${contextPath}/reservation">Reservas online</a>
          </li>
          <li class="list-inline-item">&sdot;</li>
          <li class="list-inline-item">
            <a href="${contextPath}/audit">Administración</a>
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

<!-- Modal -->
<div id="aboutModal" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>
      <div class="modal-body">
        <div class=row>
          <div class="col-xl-6 my-auto showcase-text">
            <img src="${contextPath}/img/HC-Logo.png" alt="logo" class="img-thumbnail">
            <hr>
            <h4>Dirección:</h4>
            <p class=" lead mb-0">Marcelo T Alvear 400</p>
            <p class=" lead mb-0">Córdoba, Argentina</p>
            <hr>
            <h4>Teléfono:</h4>
            <p class="lead mb-0">(0351) 4220033</p>
          </div>
          <div class="col-xl-6 my-auto showcase-text">
            <p>La estratégica ubicación del Hotel le permite un acceso inmediato a
              los centros comerciales y culturales más destacados de la ciudad
              de Córdoba. Tiendas de diseño y antigüedades, artesanías,
              museos y el arroyo La Cañada, son parte del paisaje que lo rodea.
              Disfrutar desde sus ventanales, con vista al arroyo La Cañada, le
              otorga un sentido de identidad al hotel y a la capital mediterránea.</p>
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
      </div>
    </div>
  </div>
</div>

<script src="${contextPath}/vendor/jquery/jquery.min.js"></script>
<script src="${contextPath}/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="${contextPath}/vendor/popper/umd/popper.min.js"></script>
<script src="${contextPath}/vendor/iconify/dist/iconify.min.js"></script>

</div>