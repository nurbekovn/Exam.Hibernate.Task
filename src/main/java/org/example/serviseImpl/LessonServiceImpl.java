package org.example.serviseImpl;

import org.example.dao.LessonDao;
import org.example.daoImpl.LessonDaoImpl;
import org.example.model.Lesson;

public class LessonServiceImpl  implements LessonDao {
    LessonDao lessonDao = new LessonDaoImpl();

    @Override
    public void saveLesson(Long id,Lesson lesson) {
        lessonDao.saveLesson(id, lesson);
    }

    @Override
    public void updateLesson(Long id, Lesson lesson) {
        lessonDao.updateLesson(id,lesson);
    }

    @Override
    public Lesson getLessonById(Long id) {
        return lessonDao.getLessonById(id);
    }

    @Override
    public void getLessonByCourseId(Long id) {
         lessonDao.getLessonByCourseId(id);
    }
}
