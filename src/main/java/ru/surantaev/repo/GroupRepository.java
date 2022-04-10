package ru.surantaev.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.surantaev.entity.Group;
import ru.surantaev.entity.Student;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {

    List<Student> findAllByStudentsContains(String name);
}