package ru.surantaev.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.surantaev.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}