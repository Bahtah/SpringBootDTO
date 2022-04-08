package ru.surantaev.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.surantaev.dto.CompanyRequest;
import ru.surantaev.dto.CompanyResponce;
import ru.surantaev.service.CompanyService;

import java.util.List;

@RestController
@RequestMapping("api/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping
    public CompanyResponce create(@RequestBody CompanyRequest companyRequest) {
        return companyService.create(companyRequest);
    }

    @PutMapping("{id}")
    public CompanyResponce update(@PathVariable Long id, @RequestBody CompanyRequest companyRequest) {
        return companyService.update(id, companyRequest);
    }

    @GetMapping("{id}")
    public CompanyResponce getById(@PathVariable Long id) {
        return companyService.findById(id);
    }

    @DeleteMapping("{id}")
    public CompanyResponce delete(@PathVariable Long id) {
        return companyService.delete(id);
    }

    @GetMapping
    public List<CompanyResponce> getAllCompany() {
        return companyService.getAllCompany();
    }

}
