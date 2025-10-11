package com.chris.cmarket_order_service.Common.Handler;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.chris.cmarket_order_service.Common.Constant.CmarketLoadOrderConstant;
import com.chris.cmarket_order_service.Common.Response.APIResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(CmarketLoadOrderConstant.DEFAULT_PRIORITY)
public class ValidationHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIResponse<Map<String, List<String>>>> handleValidationErrors(
            MethodArgumentNotValidException ex) {

        Map<String, List<String>> errors = ex.getBindingResult().getFieldErrors()
                .stream()
                .collect(Collectors.groupingBy(
                        FieldError::getField,
                        Collectors.mapping(DefaultMessageSourceResolvable::getDefaultMessage, Collectors.toList())));
        APIResponse<Map<String, List<String>>> response = APIResponse.failed(errors);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<APIResponse<String>> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        APIResponse<String> response = APIResponse.failed("Request body is missing or malformed");

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
