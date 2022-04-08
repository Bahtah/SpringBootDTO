package ru.surantaev.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.lang.annotation.RequiredTypes;
import ru.surantaev.enam.StudyFormat;

import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity
@Table(name = "student_base", schema = "spring_pov", catalog = "postgres")
public class Student {

    @Id
    @SequenceGenerator(name = "student_id", sequenceName = "student_sequence", allocationSize = 1, schema = "spring_pov")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id")
    private int id;

    @Column(name = "student_fName")
    private String firstName;

    @Column(name = "student_lName")
    private String lastName;

    @Column(name = "student_email", unique = true)
    private String email;

    @Column(name = "study_format")
    @Enumerated(EnumType.STRING)
    private StudyFormat studyFormat;

    //Связь с таблицой Group
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    private Group group;
}
