package com.example.demo.exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.springframework.http.HttpStatus.BAD_REQUEST;


@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class UserControllerAdvice {
    private final MessageSource messageSource;

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotAuthenticatedException.class)
    public final ResponseEntity<Object> handleUserNotAuthenticatedException(UserNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorData> methodArgumentNotValidException(MethodArgumentNotValidException ex, Locale locale) {
        BindingResult result = ex.getBindingResult();

        List<FieldError> fieldErrors = result.getFieldErrors();
        return new ResponseEntity<>(processFieldErrorDetails(fieldErrors, locale), BAD_REQUEST);
    }

    private ValidationErrorData processFieldErrorDetails(List<FieldError> fieldErrors, Locale locale) {
        return ValidationErrorData.builder()
                .message("Invalid Request Body!")
                .status(BAD_REQUEST.value())
                .fieldErrors(getFieldErrorsList(fieldErrors, locale))
                .build();
    }

    private List<ValidationErrorData.ErrorDetail> getFieldErrorsList(List<FieldError> fieldErrors, Locale locale) {
        //JAVA 7
        List<ValidationErrorData.ErrorDetail> returnList = new ArrayList<>();
        for (FieldError fieldError : fieldErrors) {
            returnList.add(ValidationErrorData.ErrorDetail.builder()
                    .fieldName(fieldError.getField())
                    .message(fieldError.getDefaultMessage())
                    .build());
        }
        return returnList;
        // JAVA 8
        /*return fieldErrors.stream().map(fieldError -> ValidationErrorData.ErrorDetail.builder()
                .fieldName(fieldError.getField())
                .message(fieldError.getDefaultMessage())
                .build()).collect(Collectors.toList());*/
    }

}
