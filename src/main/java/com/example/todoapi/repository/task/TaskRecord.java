package com.example.todoapi.repository.task;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class TaskRecord {

  private Long id;
  private String title;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
