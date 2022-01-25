package hr.tvz.exceptions;

public class RacunVecPostojiException extends Exception{

    public RacunVecPostojiException() {
    }

    public RacunVecPostojiException(String message) {
        super(message);
    }

    public RacunVecPostojiException(String message, Throwable cause) {
        super(message, cause);
    }

    public RacunVecPostojiException(Throwable cause) {
        super(cause);
    }

    public RacunVecPostojiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
