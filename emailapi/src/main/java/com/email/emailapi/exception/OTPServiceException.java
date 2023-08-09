package com.email.emailapi.exception;

public class OTPServiceException extends RuntimeException {

    public OTPServiceException(String errorMessage) {
        super(errorMessage);
    }


    public OTPServiceException(String errorMessage, Throwable throwable) {
        super(errorMessage, throwable);
    }

}
