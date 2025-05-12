package com.projects.fueltracker.exception;

import com.projects.fueltracker.model.responseWrapper.ApiResponse;
import com.projects.fueltracker.model.responseWrapper.ResponseUtil;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BunkBrandNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> bunkBrandNotFoundExceptionHandler(BunkBrandNotFoundException e) {
        ApiResponse<Object> apiResponse = ResponseUtil.error(404, e.getMessage(), null);
        return new ResponseEntity<>(apiResponse, HttpStatusCode.valueOf(apiResponse.getStatus()));
    }

    @ExceptionHandler(BunkBrandAlreadyExistsException.class)
    public ResponseEntity<ApiResponse<Object>> bunkBrandAlreadyExistsExceptionHandler(BunkBrandAlreadyExistsException e) {
        ApiResponse<Object> apiResponse = ResponseUtil.error(409, e.getMessage(), null);
        return new ResponseEntity<>(apiResponse, HttpStatusCode.valueOf(apiResponse.getStatus()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Object>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        Map<String, String> errorsMap = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errorsMap.put(fieldName, errorMessage);
        });
        ApiResponse<Object>  apiResponse = ResponseUtil.error(422, "Unprocessable Entity", errorsMap);
        return new ResponseEntity<>(apiResponse, HttpStatusCode.valueOf(apiResponse.getStatus()));
    }
}
