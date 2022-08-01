package org.example.daoImpl;

import org.example.config.Config;
import org.example.dao.TaskDao;
import org.example.model.Lesson;
import org.example.model.Task;

import javax.persistence.EntityManager;
import java.util.List;

public class TaskDaoImpl implements TaskDao {

    @Override
    public void saveTask(Long id, Task task) {
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class, id);
        lesson.addTask(task);
        task.setLesson(lesson);
        entityManager.persist(task);
        entityManager.getTransaction().commit();
        entityManager.close();

        // worked by task_id = null ;
    }

    @Override
    public Task updateTask(Long id, Task task) {
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
        Task task1 = entityManager.find(Task.class, id);
        task1.setName(task.getName());
        entityManager.getTransaction().commit();
        entityManager.close();
        return task;
        // worked

    }

    @Override
    public List<Task> getAllTaskByLessonId(Long id) {
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class, id);
        List<Task> taskList = lesson.getTasks();
        entityManager.getTransaction().commit();
        entityManager.close();
        return taskList;
    }

    @Override
    public void deleteTaskById(Long id) {
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
        Task task = entityManager.find(Task.class, id);
        task.setLesson(null);
        entityManager.remove(task);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}

//        for (Lesson le : (List<Lesson>)task.getLesson()) {
//            le.setCourse(null);
//        }

//        Lesson lesson = new Lesson();
//        task.getLesson();
//        lesson.setCourse(null);

//        for (Lesson l:task.()) {
//            l.setCourse(null);
//        }