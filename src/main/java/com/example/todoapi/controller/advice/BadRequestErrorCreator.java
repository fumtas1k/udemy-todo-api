package com.example.todoapi.controller.advice;

import com.example.todoapi.model.BadRequestError;
import com.example.todoapi.model.InvalidParam;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.stream.Collectors;

public class BadRequestErrorCreator {

  public static BadRequestError from(MethodArgumentNotValidException ex) {
    var invalidParams = createInvalidParamList(ex);
    var error = new BadRequestError();
    error.setInvalidParams(invalidParams);

    return error;
  }

  private static List<InvalidParam> createInvalidParamList(MethodArgumentNotValidException ex) {
    return ex.getFieldErrors().stream()
        .map(BadRequestErrorCreator::createInvalidParam)
        .collect(Collectors.toList());
  }

  private static InvalidParam createInvalidParam(FieldError fieldError) {
    var invalidParam = new InvalidParam();
    invalidParam.setName(fieldError.getField());
    invalidParam.setReason(fieldError.getDefaultMessage());
    return invalidParam;
  }
}
