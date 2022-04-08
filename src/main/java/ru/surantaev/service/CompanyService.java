package ru.surantaev.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.surantaev.dto.CompanyRequest;
import ru.surantaev.dto.CompanyResponce;
import ru.surantaev.entity.Company;
import ru.surantaev.mapper.CompanyEditMapper;
import ru.surantaev.mapper.CompanyViewMapper;
import ru.surantaev.repo.CompanyRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyEditMapper companyEditMapper;
    private final CompanyViewMapper companyViewMapper;
    private final CompanyRepository companyRepository;

    public CompanyResponce create(CompanyRequest request) {
        Company company = companyEditMapper.create(request);
        companyRepository.save(company);
        return companyViewMapper.viewCompany(company);
    }

    public CompanyResponce update(Long id, CompanyRequest request) {
        Company company = companyRepository.findById(id).get();
        companyEditMapper.update(company, request);
        return companyViewMapper.viewCompany(company);
    }

    public CompanyResponce findById(Long id) {
        Company company = companyRepository.findById(id).get();
        return companyViewMapper.viewCompany(company);
    }

    public CompanyResponce delete(Long id) {
        Company company = companyRepository.getById(id);
        companyRepository.deleteById(id);
        return companyViewMapper.viewCompany(company);
    }

    public List<CompanyResponce> getAllCompany() {
        return companyViewMapper.view(companyRepository.findAll());
    }
}
