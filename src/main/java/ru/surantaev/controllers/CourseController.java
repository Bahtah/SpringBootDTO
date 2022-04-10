package ru.surantaev.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.surantaev.entity.Course;
import ru.surantaev.service.CourseService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public List<Course> getAll() {
        return courseService.findAll();
    }

    @GetMapping("{id}")
    public Optional<Course> findById(@PathVariable Long id) {
        return courseService.findById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Course> save(@RequestBody Course course){

        if (course.getId() != null && course.getId() != 0) {
            return new ResponseEntity("параметр: ID ДОЛЖЕН быть нулевым", HttpStatus.NOT_ACCEPTABLE);
        }
        if (course.getCourseName() == null || course.getCourseName().trim().length() == 0) {
            return new ResponseEntity("назначенный параметр: name", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(courseService.saveCourse(course));
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Course course) {

        if (course.getId() == null && course.getId() == 0) {
            return new ResponseEntity("параметр: ID не ДОЛЖЕН быть нулевым", HttpStatus.NOT_ACCEPTABLE);
        }
        if (course.getCourseName() == null || course.getCourseName().trim().length() == 0) {
            return new ResponseEntity("назначенный параметр: name", HttpStatus.NOT_ACCEPTABLE);
        }
        courseService.updateCourse(course);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable ("id") Long id) {
        try {
            courseService.delete(id);
        }catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return new ResponseEntity("id " + id + " не найден", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

}
