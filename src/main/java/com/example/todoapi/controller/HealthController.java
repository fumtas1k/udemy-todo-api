package com.example.todoapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@RestController
public class HealthController implements HealthApi {
  @Override
  public Optional<NativeWebRequest> getRequest() {
    return HealthApi.super.getRequest();
  }

  @Override
  public ResponseEntity<Void> healthGet() {
    return ResponseEntity.ok().build();
  }
}
