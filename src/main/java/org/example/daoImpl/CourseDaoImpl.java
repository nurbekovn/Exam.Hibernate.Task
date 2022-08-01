package org.example.daoImpl;

import org.example.config.Config;
import org.example.dao.CourseDao;
import org.example.model.Course;
import org.example.model.Instructor;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CourseDaoImpl implements CourseDao {

    @Override
    // done
    public void saveCourse(Course course) {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(course);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("Successfully added");
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            System.out.println("Oops , exception saveCourse");
        }
    }


    @Override
    // done
    public Course getCourseById(Long id) {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            Course course = entityManager.find(Course.class,id);
            TypedQuery<Course> query = (TypedQuery<Course>) entityManager.createQuery("select c from Course c where c.id= : id")
                    .setParameter("id", id);
            List<Course> courses = query.getResultList();
            entityManager.getTransaction().commit();
            System.out.println("Successfully working method getCourseById");
            entityManager.close();
            return course;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    @Override
    //  done
    public List<Course> getAllCourse() {
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Course> query = entityManager.createQuery("SELECT c " +
                "from Course c order by c.createAt  ", Course.class);
        List<Course> courses = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return courses;
    }

    @Override
    //  done
    public Course updateCourse(Long id, Course course) {
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
        Course course1 = entityManager.find(Course.class, id);
        course1.setCourse_name(course.getCourse_name());
        course1.setCreateAt(course.getCreateAt());
        course1.setDescription(course.getDescription());
        course1.setImageLink(course.getImageLink());
        entityManager.getTransaction().commit();
        entityManager.close();
        return course;

    }

    @Override
    //  done
    public void deleteCourseById(Long id) {
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class,id);
        for (Instructor i: course.getInstructor()) {
            i.setCourses(null);
        }
        entityManager.remove(course);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    // done
    public Course getCourseByName(String name) {
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
        Course course = entityManager.createQuery("select c from Course " +
                "c where c.course_name =: course_name",Course.class)
                .setParameter("course_name",name)
                .getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return course;
    }
}

//        Course newCall = null;
//        List results = entityManager.getResultList();
//        if (!results.isEmpty())
//            newCall = (T03CallsLog) results.get(0);
//        else
//            // is it a problem? -> log.