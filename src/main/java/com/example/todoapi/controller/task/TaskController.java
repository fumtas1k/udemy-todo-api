package com.example.todoapi.controller.task;

import com.example.todoapi.controller.TasksApi;
import com.example.todoapi.model.TaskDTO;
import com.example.todoapi.service.task.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class TaskController implements TasksApi {

  private final TaskService taskService;

  @Override
  public ResponseEntity<TaskDTO> showTask(Long taskId) {
    var entity = taskService.find(taskId);
    var body = new TaskDTO();
    body.setId(entity.getId());
    body.setTitle(entity.getTitle());
    return ResponseEntity.ok(body);
  }
}
