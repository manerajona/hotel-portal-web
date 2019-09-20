package ar.edu.iua.portal.hotel.cons;

public interface Imessages {
    String SOMETHING_WENT_WRONG_PLEASE_TRY_AGAIN_LATER = "Algo salió mal, por favor intenta más tarde.";
    String USER_WITH_ID_NOT_FOUND = "El usuario con id %d existe.";
    String USERNAME_INCORRECT = "El username no existe.";
    String RESERVATION_WITH_ID_NOT_FOUND = "La reservación número %d no existe.";
    String CHECK_IN_MUST_BE_BEFORE_CHECK_OUT = "Fecha de check in debe ser menor a la de check out.";
    String GUESTS_MUST_BE_GREATER_THAN_ZERO = "El número de húespedes debe ser mayor a cero.";
    String PLEASE_REGISTER_YOUR_USER = "Por favor, registrate para hacer tu reserva.";
    String YOUR_USERNAME_AND_PASSWORD_IS_INVALID = "Username o password invalidos.";
    String YOU_HAVE_BEEN_LOGGED_OUT_SUCCESSFULLY = "You have been logged out successfully.";
    String THE_RESERVATION_WAS_REGISTERED = "Su reserva ha sido registrada.";
    String CHECK_IN_MUST_BE_BEFORE_TODAY = "La fecha de check in debe ser posterior a hoy";
}
