package com.ad.exception;


public class InvalidTokenException extends BaseException {
    public InvalidTokenException(int resultCode, String message) {
        super(resultCode, message);
    }
}
