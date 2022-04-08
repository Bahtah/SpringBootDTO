package ru.surantaev.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "teacher_base", schema = "spring_pov", catalog = "postgres")
public class Teacher {

    @Id
    @SequenceGenerator(name = "teacher_id", sequenceName = "teacher_sequence", allocationSize = 1, schema = "spring_pov")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_id")
    private int id;

    @Column(name = "teacher_fName")
    private String firstName;

    @Column(name = "teacher_lName")
    private String lastName;

    @Column(name = "teacher_email", unique = true)
    private String email;

    //Связь с таблицой Course
    @OneToOne(mappedBy = "teacher", cascade = CascadeType.ALL)
    private Course course;

    public Teacher(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
