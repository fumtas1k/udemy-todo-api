package com.example.todoapi.repository.task;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface TaskRepository {

  @Select("select id, title, created_at, updated_at from tasks where id=#{taskId}")
  Optional<TaskRecord> select(Long taskId);
}
