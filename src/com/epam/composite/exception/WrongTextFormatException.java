package com.epam.composite.exception;

/**
 * Created by Dmitry on 06.07.2014.
 */
public class WrongTextFormatException extends Exception {
    public WrongTextFormatException() {
        super();
    }
    public WrongTextFormatException(String message) {
        super(message);
    }
    public WrongTextFormatException(String message, Throwable cause) {
        super(message, cause);
    }
    public WrongTextFormatException(Throwable cause) {
        super(cause);
    }
}
