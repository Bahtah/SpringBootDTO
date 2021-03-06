package ru.surantaev.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "group_base", schema = "spring_pov", catalog = "postgres")
public class Group {

    @Id
    @SequenceGenerator(name = "group_sq", sequenceName = "group_sequence", allocationSize = 1, schema = "spring_pov")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_sq")
    private Long id;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "date_of_start")
    private LocalDate dateOfStart;

    @Column(name = "date_of_finish")
    private LocalDate dateOfFinish;

    //Связь с таблицой Course
    //@JsonBackReference
    @JsonIgnore
    @ManyToMany(mappedBy = "groups", fetch = FetchType.LAZY)
    private List<Course> courses;

    //Связь с таблицой Student
    //@JsonManagedReference
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Student> students;
}
