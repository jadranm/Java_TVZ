package hr.tvz.exceptions;

public class NedozvoljenoStanjeStednogException extends RuntimeException {

    public NedozvoljenoStanjeStednogException() {
    }

    public NedozvoljenoStanjeStednogException(String message) {
        super(message);
    }

    public NedozvoljenoStanjeStednogException(String message, Throwable cause) {
        super(message, cause);
    }

    public NedozvoljenoStanjeStednogException(Throwable cause) {
        super(cause);
    }

    public NedozvoljenoStanjeStednogException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
