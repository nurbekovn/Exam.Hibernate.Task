package org.example.daoImpl;

import org.example.config.Config;
import org.example.dao.InstructorDao;
import org.example.model.Course;
import org.example.model.Instructor;

import javax.persistence.EntityManager;
import java.util.List;

public class InstructorDaoImpl implements InstructorDao {
    @Override
    // done
    public void saveInstructor(Instructor instructor) {
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(instructor);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    // done
    public void updateInstructor(Long id, Instructor instructor) {
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
        Instructor instructor1 = entityManager.find(Instructor.class, id);
        instructor1.setEmail(instructor.getEmail());
        instructor1.setFirstName(instructor.getFirstName());
        instructor1.setLastName(instructor.getLastName());
        instructor1.setPhoneNumber(instructor.getPhoneNumber());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    // done
    public Instructor getInstructorById(Long id) {
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
        Instructor instructor = entityManager.find(Instructor.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return instructor;
    }

    @Override
    // done
    public List<Instructor> getInstructorByCourseId(Long id) {
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class,id);
        List<Instructor> instructors = course.getInstructor();
        entityManager.getTransaction().commit();
        entityManager.close();
        return instructors;
    }

//        Instructor instructor = (Instructor) entityManager.createQuery
//                        ("select Instructor from Instructor where Instructor .id =:Id",
//                                Instructor.class).setParameter("Id", id)
//                .getSingleResult();

    @Override
    //done
    public void deleteInstructorById(Long id) {
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
        Instructor instructor = entityManager.find(Instructor.class, id);
        entityManager.remove(instructor);
        entityManager.getTransaction().commit();
        System.out.println("Successfully deleted Instructor By Id ");
        entityManager.close();
    }

    @Override
    // done
    public void assignedInstructorToCourse(Long courseId, Long instructorId) {
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, courseId);
        Instructor instructor = entityManager.find(Instructor.class, instructorId);
        course.addInstructor(instructor);
        instructor.addCourse(course);
        entityManager.persist(course);
        entityManager.persist(instructor);
        entityManager.getTransaction().commit();
        System.out.println("Successfully assigned Instructor to Course");
        entityManager.close();
    }
}
