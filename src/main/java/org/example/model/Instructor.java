package org.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructors")
@Setter
@Getter
@NoArgsConstructor

public class Instructor  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name",length = 55)
    private String firstName;
    @Column(name = "last_name",length = 55)
    private String lastName;
    private String email;
    @Column(name = "phone_number",length = 55 , unique = true)
    private int phoneNumber;

    // ?? In method deleteInstructorById() we must fetchType=FetchType.LAZY;
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.LAZY)
    @JoinTable
    private List<Course> courses = new ArrayList<>();

    public Instructor(String firstName, String lastName, String email, int phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void  addCourse(Course c) {
        if (courses ==null) {
            courses = new ArrayList<>();
        }
        this.courses.add(c);

//        c.setInstructor(this);

    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
