package org.example.dao;

import org.example.model.Course;
import org.example.model.Instructor;

import java.util.List;

public interface InstructorDao {
    void saveInstructor(Instructor instructor);
    void updateInstructor(Long id,Instructor instructor);
    Instructor getInstructorById(Long id);
    List<Instructor> getInstructorByCourseId(Long id); //тиешелуу курстун инструкторлорун чыгарып беруу
    void deleteInstructorById(Long id); //инструктор очкондо, инструкторго тиешелуу курс очпошу керек
    void assignedInstructorToCourse(Long courseId,Long instructorId); //инструкторду курска кошуп коюу(назначить)).

}
