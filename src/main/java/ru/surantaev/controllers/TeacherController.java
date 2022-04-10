package ru.surantaev.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.surantaev.entity.Teacher;
import ru.surantaev.service.TeacherService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping
    public List<Teacher> getAll() {
        return teacherService.findAll();
    }

    @GetMapping("{id}")
    public Optional<Teacher> findById(@PathVariable Long id) {
        return teacherService.findById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Teacher> save(@RequestBody Teacher teacher){

        if (teacher.getId() != null && teacher.getId() != 0) {
            return new ResponseEntity("параметр: ID ДОЛЖЕН быть нулевым", HttpStatus.NOT_ACCEPTABLE);
        }
        if (teacher.getFirstName() == null || teacher.getFirstName().trim().length() == 0) {
            return new ResponseEntity("назначенный параметр: name", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(teacherService.saveTeacher(teacher));
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Teacher teacher) {

        if (teacher.getId() == null && teacher.getId() == 0) {
            return new ResponseEntity("параметр: ID не ДОЛЖЕН быть нулевым", HttpStatus.NOT_ACCEPTABLE);
        }
        if (teacher.getFirstName() == null || teacher.getFirstName().trim().length() == 0) {
            return new ResponseEntity("назначенный параметр: name", HttpStatus.NOT_ACCEPTABLE);
        }
        teacherService.updateTeacher(teacher);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable ("id") Long id) {
        try {
            teacherService.delete(id);
        }catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return new ResponseEntity("id " + id + " не найден", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

}
