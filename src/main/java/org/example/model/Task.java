package org.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.config.Config;
import org.example.dao.TaskDao;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tasks")
@Setter
@Getter
@NoArgsConstructor

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private LocalDate deadLine;
    @Column(length = 7777)
    private String task;

    public Task(String name, LocalDate deadLine, String task) {
        this.name = name;
        this.deadLine = deadLine;
        this.task = task;
    }

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,
    CascadeType.DETACH,CascadeType.REFRESH})
    public Lesson lesson;



//    public void method(Lesson lesson) {
//        Lesson lesson1 = new Lesson();
//        lesson1=lesson;
//        System.out.println(lesson1);
//    }

//  public void addCourse(Course c) {
//        if (courses ==null) {
//            courses = new ArrayList<>();
//        }
//        this.courses.add(c);

//    public void addTask(Task t) {
//        if (task == null) {
//            task = "null";
//        }
//
//    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", deadLine=" + deadLine +
                ", task='" + task + '\'' +
                '}';
    }
}
