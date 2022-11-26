package com.example.todoapi.controller.task;

import com.example.todoapi.controller.TasksApi;
import com.example.todoapi.model.TaskDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class TaskController implements TasksApi {

  @Override
  public ResponseEntity<TaskDTO> showTask() {
    var body = new TaskDTO();
    body.setId(1L);
    body.setTitle("Test");
    return ResponseEntity.ok(body);
  }
}
