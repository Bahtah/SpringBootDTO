package ru.surantaev.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.surantaev.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}