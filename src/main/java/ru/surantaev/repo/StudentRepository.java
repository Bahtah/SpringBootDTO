package ru.surantaev.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.surantaev.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}