package org.javaspringcourse.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TooManyRequestsExceptionHandler {

    @ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
    @ExceptionHandler(TooManyRequestsException.class)
    public ErrorResponse handle(TooManyRequestsException e) {
        return new ErrorResponse(e.getMessage());
    }
}
