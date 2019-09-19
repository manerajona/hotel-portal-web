package ar.edu.iua.portal.hotel.cons;

public interface Imessages {
    String SOMETHING_WENT_WRONG_PLEASE_TRY_AGAIN_LATER = "something went wrong please try again later.";
    String THE_USERNAME_OR_PASSWORD_ARE_INCORRECT = "The username or password are incorrect.";
    String USER_WITH_ID_NOT_FOUND = "User with id %d not found.";
    String USERNAME_INCORRECT = "The username is not found.";
    String RESERVATION_WITH_ID_NOT_FOUND = "Reservation with id %d not found.";
    String CHECK_IN_MUST_BE_BEFORE_CHECK_OUT = "Date of reservation must be before the date of leave.";
    String GUESTS_MUST_BE_GREATER_THAN_ZERO = "The number of guests must be one or more.";
}
