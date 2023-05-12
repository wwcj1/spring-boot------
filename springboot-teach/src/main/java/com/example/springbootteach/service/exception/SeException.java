package com.example.springbootteach.service.exception;/*
 * @Author snoopy
 * @Date $ $
 * @Param $

 */

public class SeException extends RuntimeException{

    public SeException() {
        super();
    }

    public SeException(String message) {
        super(message);
    }

    public SeException(String message, Throwable cause) {
        super(message, cause);
    }

    public SeException(Throwable cause) {
        super(cause);
    }

    protected SeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
