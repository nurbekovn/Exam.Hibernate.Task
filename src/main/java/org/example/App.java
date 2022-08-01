package org.example;

import antlr.StringUtils;
import org.example.config.Config;
import org.example.dao.CourseDao;
import org.example.dao.InstructorDao;
import org.example.dao.LessonDao;
import org.example.daoImpl.InstructorDaoImpl;
import org.example.daoImpl.LessonDaoImpl;
import org.example.model.Course;
import org.example.model.Instructor;
import org.example.model.Lesson;
import org.example.model.Task;
import org.example.serviseImpl.CourseServiceImpl;
import org.example.serviseImpl.LessonServiceImpl;
import org.example.serviseImpl.TaskImpl;
import org.hibernate.HibernateException;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//        Config.getSession();
        CourseDao courseDao = new CourseServiceImpl();
        InstructorDao instructorDao = new InstructorDaoImpl();
        LessonDao lesson = new LessonServiceImpl();

        Scanner scanner = new Scanner(System.in);
        TaskImpl task = new TaskImpl();

        System.out.println("Press 1-20");
        while (true) {
        int comNum = scanner.nextInt();
            switch (comNum) {
                case 1:
                    courseDao.saveCourse(new Course("Lg ", (short) 4, LocalDate.ofYearDay(2021, 15),
                            "www.java.com", "Learn Java and create your code !"));
                    break;
                case 2:
                    courseDao.deleteCourseById(scanner.nextLong());
                    break;
                case 3:
                    System.out.println(courseDao.getCourseByName("Lg".trim()));
                    break;
                case 4:
                    System.out.println(courseDao.getCourseById(scanner.nextLong()));
                    break;
                case 5:
                    System.out.println(courseDao.getAllCourse());
                    break;
                case 6:
                    courseDao.updateCourse(scanner.nextLong(), new Course());
                    break;
                case 7:
                    instructorDao.saveInstructor(new Instructor());
                    break;
                case 8:
                    instructorDao.deleteInstructorById(scanner.nextLong());
                    break;
                case 9:
                    instructorDao.getInstructorByCourseId(scanner.nextLong());
                    break;
                case 10:
                    instructorDao.updateInstructor(scanner.nextLong(), new Instructor());
                    break;
                case 11:
                    instructorDao.assignedInstructorToCourse(scanner.nextLong(),scanner.nextLong());
                    break;
                case 12:
                    instructorDao.getInstructorById(scanner.nextLong());
                    break;
                case 13:
                    lesson.saveLesson(scanner.nextLong(), new Lesson());
                    break;
                case 14:
                    lesson.getLessonById(scanner.nextLong());
                    break;
                case 15:
                    lesson.getLessonByCourseId(scanner.nextLong());
                    break;
                case 16:
                    lesson.updateLesson(scanner.nextLong(), new Lesson());
                    break;
                case 17:
                    task.saveTask(scanner.nextLong(), new Task());
                    break;
                case 18:
                    task.deleteTaskById(scanner.nextLong());
                    break;
                case 19:
                    task.updateTask(scanner.nextLong(), new Task());
                    break;
                case 20:
                    System.out.println(task.getAllTaskByLessonId(scanner.nextLong()));
                    break;
                default:
                    System.out.println("Error default ");
            }
        }
    }
}

//        task.saveTask(1L,new Task("Collection",
//                LocalDate.now(),"Task about while loop"));

//        task.deleteTaskById(7L);

//        System.out.println(task.getAllTaskByLessonId(1L));
//        task.getAllTaskByLessonId(1L).forEach(System.out::println);
//        task.deleteTaskById(3L);

//        List<Task> tasks = new LinkedList<>(Arrays.asList(
//                new Task("Loops",LocalDate.now(),"Task about while loop"),
//                new Task("Condition Operations",LocalDate.ofYearDay(2021,20),"Task about if-else")
//        ));

//        lesson.saveLesson(1L,new Lesson("Hibernate","hibernate.click.me"));
//        System.out.println(lesson.getLessonById(4L));
//        lesson.updateLesson(4L,new Lesson("NewLesson","Added"));
//        lesson.getLessonByCourseId(1L);

//        courseDao.saveCourse(new Course("ghj 7 ",(short) 2,LocalDate.ofYearDay(2021,19),
//                "swift.png","swift task !!!"));
//        courseDao.updateCourse(1L,new Course("SQL",(short) 2,LocalDate.now(),
//                "image","Sql is a language"));
//        System.out.println(courseDao.getCourseById(18L));
//        courseDao.getAllCourse().forEach(System.out::println);
//        courseDao.deleteCourseById(4L);

//        System.out.println(courseDao.getCourseByName("SQL"));
//        System.out.println(courseDao.getCourseByName("SQL"));
//        courseDao.deleteCourseById(18L);

//        instructorDao.deleteInstructorById(9L);
//        System.out.println(instructorDao.getInstructorByCourseId(1L));
//        instructorDao.getInstructorByCourseId(1L).forEach(System.out::println);
//        System.out.println(instructorDao.getInstructorByCourseId(1L));
//        instructorDao.assignedInstructorToCourse(20L,7L);
//        instructorDao.assignedInstructorToCourse(19L,9L);
//        instructorDao.updateInstructor(3L,new Instructor("Nurisa","Mamiraimova",
//                "nurisa@gmail.com",705230403));
//        instructorDao.assignedInstructorToCourse(1L,1L);
//        instructorDao.saveInstructor(new Instructor("Zamir.","Sabyrjanov","sarjanov@gmail.com",
//                705230452));

//        System.out.println(instructorDao.getInstructorById(5L));
//
//        Task task = new Task();
//        task.saveTask(new Task("Loops",LocalDate.now(),"Task about while loop"));
//        task.updateTask(1L,new Task("JS",LocalDate.now(),"default have a JDBC"));
//        task.getAllTaskByLessonId().forEach(System.out::println);
//        Lesson lesson = new Lesson();
//        lesson.saveLesson(new Lesson("JDBC","jdbc.click.me",tasks,course));

