package ru.surantaev.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "course_base", schema = "spring_pov", catalog = "postgres")
public class Course {

    @Id
    @SequenceGenerator(name = "course_sq", sequenceName = "course_sequence", allocationSize = 1, schema = "spring_pov")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_sq")
    private Long id;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_duration")
    private int duration;

    //Связь с таблицой Company
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private Company company;

    //Связь с таблицой Group
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(schema = "spring_pov",
            name = "course_group",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private List<Group> groups;

    //Связь с таблицой Teacher
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
}
