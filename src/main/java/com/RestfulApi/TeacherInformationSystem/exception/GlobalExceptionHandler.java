package com.RestfulApi.TeacherInformationSystem.exception;

import com.RestfulApi.TeacherInformationSystem.response.CustomResponse;
import com.RestfulApi.TeacherInformationSystem.util.ApiResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public CustomResponse<?> handleRuntimeException(RuntimeException ex) {
        return ApiResponseUtil.error(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CustomResponse<?> handleValidationException(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .findFirst().orElse("Validation error");
        return ApiResponseUtil.error(message, HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(Exception.class)
    public CustomResponse<?> handleGenericException(Exception ex) {
        return ApiResponseUtil.error("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    @ExceptionHandler(ManagerNotFoundException.class)
    public CustomResponse<?> handleManagerNotFound(ManagerNotFoundException ex) {
        return ApiResponseUtil.error(ex.getMessage(), HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(DuplicateEmailException.class)
    public CustomResponse<?> handleDuplicateEmail(DuplicateEmailException ex) {
        return ApiResponseUtil.error(ex.getMessage(), HttpStatus.CONFLICT.value());
    }

    @ExceptionHandler(TeacherNotFoundException.class)
    public CustomResponse<?> handleTeacherNotFound(TeacherNotFoundException ex) {
        return ApiResponseUtil.error(ex.getMessage(), HttpStatus.NOT_FOUND.value());
    }
}
