package org.example.serviseImpl;

import org.example.dao.TaskDao;
import org.example.daoImpl.TaskDaoImpl;
import org.example.model.Task;

import java.util.List;

public class TaskImpl implements TaskDao {
    TaskDao taskDao = new TaskDaoImpl();

    @Override
    public void saveTask(Long id , Task task) {
        taskDao.saveTask(id , task);
    }

    @Override
    public Task updateTask(Long id, Task task) {
        return taskDao.updateTask(id,task);
    }

    @Override
    public List<Task> getAllTaskByLessonId(Long id) {
        return taskDao.getAllTaskByLessonId(id);
    }

    @Override
    public void deleteTaskById(Long id) {
        taskDao.deleteTaskById(id);
    }
}
