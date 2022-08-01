package org.example.daoImpl;

import org.example.config.Config;
import org.example.dao.LessonDao;
import org.example.model.Course;
import org.example.model.Lesson;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import java.util.List;

public class LessonDaoImpl implements LessonDao {
    @Override
    // done
    public void saveLesson(Long id, Lesson lesson) {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            Course course = entityManager.find(Course.class, id);
            lesson.setCourse(course);
            entityManager.persist(lesson);
//            entityManager.persist(null);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("Successfully saved a new lesson");
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            System.out.println("exception");
        }
    }

    @Override
    // done
    public void updateLesson(Long id, Lesson lesson) {
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
        Lesson lesson1 = entityManager.find(Lesson.class,id);
        lesson1.setName(lesson.getName());
        lesson1.setVideoLink(lesson.getVideoLink());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    // done
    public Lesson getLessonById(Long id) {
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class,id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return lesson;
    }

    @Override
    // done
    public void getLessonByCourseId(Long id) {
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
//        Course course1 = entityManager.createQuery("select c from Course " +
//                "c where c.id =: id",Course.class).setParameter("id",id).getSingleResult();
        Course course = entityManager.find(Course.class,id);
        List<Lesson> lessons = course.getLesson();
        entityManager.getTransaction().commit();
        System.out.println(lessons);
        System.out.println("Successfully");
        entityManager.close();

    }
}

