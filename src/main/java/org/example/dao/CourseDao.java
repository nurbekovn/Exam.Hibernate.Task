package org.example.dao;

import org.example.model.Course;

import java.util.List;

public interface CourseDao {

    void saveCourse(Course course); //деген метод тузуп, кошулганы тууралуу message кайтаруу керек.

    Course getCourseById(Long id);
    List<Course> getAllCourse(); // датасы боюнча сорттоп чыгаруу group by localDate
    Course updateCourse(Long id,Course course);
    void deleteCourseById(Long id); //курсту очургондо, курска assign болгон инструктор
    // очпошу керек, курстун ичиндеги сабактар очуш керек)
    Course getCourseByName(String name);

}
