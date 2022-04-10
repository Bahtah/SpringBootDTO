package ru.surantaev.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.surantaev.entity.Group;
import ru.surantaev.entity.Student;
import ru.surantaev.service.GroupService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/group")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @GetMapping
    public List<Group> getAll() {
        return groupService.findAll();
    }

    @GetMapping("{id}")
    public Optional<Group> findById(@PathVariable Long id) {
        return groupService.findById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Group> save(@RequestBody Group group){

        if (group.getId() != null && group.getId() != 0) {
            return new ResponseEntity("параметр: ID ДОЛЖЕН быть нулевым", HttpStatus.NOT_ACCEPTABLE);
        }
        if (group.getGroupName() == null || group.getGroupName().trim().length() == 0) {
            return new ResponseEntity("назначенный параметр: name", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(groupService.saveGroup(group));
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Group group) {

        if (group.getId() == null && group.getId() == 0) {
            return new ResponseEntity("параметр: ID не ДОЛЖЕН быть нулевым", HttpStatus.NOT_ACCEPTABLE);
        }
        if (group.getGroupName() == null || group.getGroupName().trim().length() == 0) {
            return new ResponseEntity("назначенный параметр: name", HttpStatus.NOT_ACCEPTABLE);
        }
        groupService.updateGroup(group);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable ("id") Long id) {
        try {
            groupService.delete(id);
        }catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return new ResponseEntity("id " + id + " не найден", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public List<Student> getByName(@PathVariable String name) {
        List<Student> students = groupService.getByName(name);
        return students;
    }

}
