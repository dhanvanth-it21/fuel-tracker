package com.projects.fueltracker.exception;

import com.projects.fueltracker.model.responseWrapper.ApiResponse;
import com.projects.fueltracker.model.responseWrapper.ResponseUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

import java.util.Map;

@Log4j2
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BunkBrandNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> bunkBrandNotFoundExceptionHandler(BunkBrandNotFoundException e) {
        ApiResponse<Object> apiResponse = ResponseUtil.error(404, e.getMessage(), null);
        log.error(apiResponse.getMessage());
        return new ResponseEntity<>(apiResponse, HttpStatusCode.valueOf(apiResponse.getStatus()));
    }

    @ExceptionHandler(BunkBrandAlreadyExistsException.class)
    public ResponseEntity<ApiResponse<Object>> bunkBrandAlreadyExistsExceptionHandler(BunkBrandAlreadyExistsException e) {
        ApiResponse<Object> apiResponse = ResponseUtil.error(409, e.getMessage(), null);
        log.warn(apiResponse.getMessage());
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
        log.error("Validation fail in data found in request, check these : {}", apiResponse.getData().toString());
        return new ResponseEntity<>(apiResponse, HttpStatusCode.valueOf(apiResponse.getStatus()));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> resourceNotFoundExceptionHandler(ResourceNotFoundException e) {
        ApiResponse<Object> apiResponse = ResponseUtil.error(404, e.getMessage(), null);
        log.error(apiResponse.getMessage());
        return new ResponseEntity<>(apiResponse, HttpStatusCode.valueOf(apiResponse.getStatus()));
    }
}
