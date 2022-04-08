package ru.surantaev.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import ru.surantaev.entity.Course;

import java.util.List;

@Setter
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CompanyResponce {

    private String id;
    private String company_name;
    private String located_country;
    private List<Course> course;
}
