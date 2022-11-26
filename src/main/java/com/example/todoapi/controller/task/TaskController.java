package com.example.todoapi.controller.task;

import com.example.todoapi.controller.TasksApi;
import com.example.todoapi.model.TaskDTO;
import com.example.todoapi.model.TaskForm;
import com.example.todoapi.service.task.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.net.URI;

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

  @Override
  public ResponseEntity<TaskDTO> createTask(TaskForm form) {
    var entity = taskService.create(form.getTitle());

    var dto = new TaskDTO();
    dto.setId(entity.getId());
    dto.setTitle(entity.getTitle());

    return ResponseEntity.created(URI.create("/tasks/" + dto.getId())).body(dto);
  }
}
