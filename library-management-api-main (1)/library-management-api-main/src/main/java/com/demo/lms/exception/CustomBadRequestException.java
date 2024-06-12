package com.demo.lms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author sankar patra
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomBadRequestException extends RuntimeException {

    public CustomBadRequestException(String message) {
        super(message);
    }

    public CustomBadRequestException(String message, Exception exception) {
        super(message, exception);
    }

    public CustomBadRequestException(Exception exception) {
        super(exception);
    }
}
