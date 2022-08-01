package org.example.dao;

import org.example.model.Task;

import java.util.List;

public interface TaskDao {
    void saveTask(Long id, Task task);
    Task updateTask(Long id, Task task);
    List<Task> getAllTaskByLessonId(Long id);
    void deleteTaskById(Long id);

    // Бардык маанилер консольго так жана ирети менен чыгуусу керек
}
