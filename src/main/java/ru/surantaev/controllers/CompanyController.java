package ru.surantaev.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/save")
    public ResponseEntity<Company> saveCompany(@RequestBody Company company){
        try{
            return new ResponseEntity<>(companyService.saveCompany(company),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("{id}")
    public Company update(@PathVariable  Long id, @RequestBody Company company) {
        Company company1 = companyService.findById(id).get();
        companyService.saveCompany(company1);
        return company1;
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id) {
        companyService.delete(id);
        return "Компания с ID = " + id + " успешно удалён";
    }

}
