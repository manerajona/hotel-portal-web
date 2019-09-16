<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Usuario nuevo</title>

    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/login.css" rel="stylesheet">

    </style>
    </head>
    <body>
    <div class="login-form">
        <form id="createUser" action="/">
            <h2 class="text-center">Usuario</h2>
            <div><input name="id" type="hidden" value="-1"></div>
            <div class="form-group">
                <label>Username</label><input name="username" type="text" class="form-control" required="required">
            </div>
            <div class="form-group">
                <label>Nombre</label><input name="firstName" type="text" class="form-control" required="required">
            </div>
            <div class="form-group">
                <label>Apellido</label><input name="lastName" type="text" class="form-control" required="required">
            </div>
            <div class="form-group">
                <label>Correo electrónico</label><input name="email" type="email" class="form-control" required="required">
            </div>
            <div class="form-group">
                <label>Nuevo password</label><input id="password" name="password" type="password" class="form-control" required="required">
            </div>
            <div class="form-group">
                <label>Confirma password</label><input id="confirm_password" name="confirm_password" type="password" class="form-control" required="required">
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block">Guardar</button>
            </div>
            <div class="clearfix">
                <label class="pull-left checkbox-inline"><input type="checkbox" required="required"> Acepto términos y condiciones</label>
            </div>
        </form>
    </div>

	<script src ="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="js/newUser.js"></script>

    <!-- Controller -->
    <script src="js/controller.js"></script>

</body>

</html>