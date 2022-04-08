package ru.surantaev.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.surantaev.entity.Company;
import ru.surantaev.service.CompanyService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping
    public List<Company> getAll() {
        return companyService.findAll();
    }

    @GetMapping("{id}")
    public Optional<Company> findById(@PathVariable Long id) {
        return companyService.findById(id);
    }

}
