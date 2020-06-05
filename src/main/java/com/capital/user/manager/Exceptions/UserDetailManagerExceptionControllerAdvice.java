package com.capital.user.manager.Exceptions;

import com.capital.salt.exception.ApiException;
import com.capital.salt.exception.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class UserDetailManagerExceptionControllerAdvice {

    @ExceptionHandler(ApiException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
    public @ResponseBody
    ExceptionResponse handleResourceNotFound(final ApiException exception,
                                             final HttpServletRequest request) {
        ExceptionResponse error = new ExceptionResponse();
        error.setErrorMessage(exception.getMessage());
        error.setRequestedURI(request.getRequestURI());
        error.setHttpStatus(HttpStatus.NOT_FOUND);
        error.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
        return error;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ExceptionResponse handleException(final Exception exception,
                                                           final HttpServletRequest request) {

        ExceptionResponse error = new ExceptionResponse();
        error.setErrorMessage(exception.getMessage());
        error.setRequestedURI(request.getRequestURI());
        error.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        error.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return error;
    }
}
