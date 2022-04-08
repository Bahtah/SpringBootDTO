package ru.surantaev.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "company", schema = "spring_pov", catalog = "postgres")
public class Company {

    @Id
    @SequenceGenerator(name = "company_sq", sequenceName = "company_sequence", allocationSize = 1, schema = "spring_pov")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_sq")
    private Long id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "located_country")
    private String locatedCountry;

    //Связь с таблицой Course
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Course> course;
}
