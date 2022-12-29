package com.example.todoapi.controller.task;

import com.example.todoapi.controller.TasksApi;
import com.example.todoapi.model.PageDTO;
import com.example.todoapi.model.TaskDTO;
import com.example.todoapi.model.TaskForm;
import com.example.todoapi.model.TaskListDTO;
import com.example.todoapi.service.task.TaskEntity;
import com.example.todoapi.service.task.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.net.URI;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class TaskController implements TasksApi {

  private final TaskService taskService;

  @Override
  public ResponseEntity<TaskDTO> showTask(Long taskId) {
    var entity = taskService.find(taskId);
    var body = toTaskDTO(entity);
    return ResponseEntity.ok(body);
  }

  @Override
  public ResponseEntity<TaskDTO> createTask(TaskForm form) {
    var entity = taskService.create(form.getTitle());

    var dto = toTaskDTO(entity);

    return ResponseEntity.created(URI.create("/tasks/" + dto.getId())).body(dto);
  }

  @Override
  public ResponseEntity<TaskListDTO> listTasks(Integer limit, Long offset) {
    var entityList = taskService.find(limit, offset);
    var dto = new TaskListDTO();

    dto.setResults(entityList.stream().map(this::toTaskDTO).collect(Collectors.toList()));
    var pageDto = new PageDTO();
    pageDto.setLimit(limit);
    pageDto.setOffset(offset);
    pageDto.setSize(dto.getResults().size());
    dto.setPage(pageDto);
    return ResponseEntity.ok(dto);
  }

  @Override
  public ResponseEntity<TaskDTO> editTask(Long taskId, TaskForm form) {
    var entity = taskService.update(taskId, form.getTitle());
    var dto = toTaskDTO(entity);
    return ResponseEntity.ok(dto);
  }

  private TaskDTO toTaskDTO(TaskEntity taskEntity) {
    var taskDTO = new TaskDTO();
    taskDTO.setId(taskEntity.getId());
    taskDTO.setTitle(taskEntity.getTitle());
    return taskDTO;
  }
}
