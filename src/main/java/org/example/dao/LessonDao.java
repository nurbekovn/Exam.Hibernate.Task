package org.example.dao;

import org.example.model.Lesson;

public interface LessonDao {
    void saveLesson(Long id, Lesson lesson);  //Lesson сакталып жатканда
    // кандайдыр бир курска сакталуусу керек
    void updateLesson(Long id, Lesson lesson);
    Lesson getLessonById(Long id);
    void getLessonByCourseId(Long id);
    // курска тиешелуу сабактарды чыгаруу;

}
