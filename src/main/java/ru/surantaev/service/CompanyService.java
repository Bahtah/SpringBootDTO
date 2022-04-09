package ru.surantaev.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.surantaev.entity.Company;
import ru.surantaev.repo.CompanyRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }

    public void save(Company company) {
        companyRepository.save(company);
    }

    public void delete(Long id) {
        companyRepository.deleteById(id);
    }
}
