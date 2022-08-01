package org.example.serviseImpl;

import org.example.dao.InstructorDao;
import org.example.daoImpl.InstructorDaoImpl;
import org.example.model.Course;
import org.example.model.Instructor;

import java.util.List;

public class InstructorServiceImpl implements InstructorDao {
    InstructorDao instructorDao = new InstructorDaoImpl();

    @Override
    public void saveInstructor(Instructor instructor) {
        instructorDao.saveInstructor(instructor);
    }

    @Override
    public void updateInstructor(Long id,Instructor instructor) {
        instructorDao.updateInstructor(id,instructor);
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorDao.getInstructorById(id);
    }

    @Override
    public List<Instructor> getInstructorByCourseId(Long id) {
        return instructorDao.getInstructorByCourseId(id);
    }

    @Override
    public void deleteInstructorById(Long id) {
        instructorDao.deleteInstructorById(id);
    }

    @Override
    public void assignedInstructorToCourse(Long courseId, Long instructorId) {
        instructorDao.assignedInstructorToCourse(courseId,instructorId);
    }
}
