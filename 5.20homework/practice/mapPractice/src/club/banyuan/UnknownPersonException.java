package club.banyuan;

public class UnknownPersonException extends Exception{

    public UnknownPersonException() {
        super();
    }

    public UnknownPersonException(String message) {
        super(message);
    }

    public UnknownPersonException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnknownPersonException(Throwable cause) {
        super(cause);
    }

    protected UnknownPersonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
