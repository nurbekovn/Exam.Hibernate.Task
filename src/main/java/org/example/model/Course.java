package org.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String course_name;
    private short duration;
    private LocalDate createAt;
    private String imageLink;
    private String description;
    // continue  PERSIST
    //MERGE
    //REMOVE
    //REFRESH
    //DETACH
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},
            mappedBy = "courses", fetch = FetchType.EAGER)

//    @JoinTable(name = "instructor_course",joinColumns =
//    @JoinColumn(name = "course_id"),inverseJoinColumns =
//    @JoinColumn(name = "instructor_id"))

    private List<Instructor> instructor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course", fetch = FetchType.LAZY)
    private List<Lesson> lesson;

    public Course(String course_name, short duration, LocalDate createAt, String imageLink, String description) {
        this.course_name = course_name;
        this.duration = duration;
        this.createAt = createAt;
        this.imageLink = imageLink;
        this.description = description;
    }

    public void addInstructor(Instructor instructor) {
        this.instructor.add(instructor);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", course_name='" + course_name + '\'' +
                ", duration=" + duration +
                ", createAt=" + createAt +
                ", imageLink='" + imageLink + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
