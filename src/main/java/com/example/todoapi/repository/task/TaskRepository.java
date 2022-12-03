package com.example.todoapi.repository.task;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TaskRepository {

  @Select("select id, title, created_at, updated_at from tasks where id=#{taskId}")
  Optional<TaskRecord> select(Long taskId);

  @Select("select id, title, created_at, updated_at from tasks limit #{limit} offset #{offset}")
  List<TaskRecord> selectList(int limit, long offset);

  @Options(useGeneratedKeys = true, keyProperty = "id")
  @Insert("insert into tasks (title) values (#{title})")
  void insert(TaskRecord record);
}
