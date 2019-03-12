package com.fortiate.parser.field;

public class UnpackException extends RuntimeException {

    public UnpackException(String message) {
        super(message);
    }

    public UnpackException(String message, Throwable cause) {
        super(message, cause);
    }

}
