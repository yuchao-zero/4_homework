package club.banyuan;

public class IllegalInputException extends Exception {
    private String exceptionType;

    public String getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(String exceptionType) {
        this.exceptionType = exceptionType;
    }


    public IllegalInputException() {
    }

    public IllegalInputException(String message) {
        super(message);
        exceptionType = message;
    }
}
