package ru.calculator;

public class EmptyHolidaysRuntimeException extends RuntimeException {
    public EmptyHolidaysRuntimeException() {
    }

    public EmptyHolidaysRuntimeException(String message) {
        super(message);
    }

    public EmptyHolidaysRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyHolidaysRuntimeException(Throwable cause) {
        super(cause);
    }

    public EmptyHolidaysRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
