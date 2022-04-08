package ru.surantaev.mapper;

import org.springframework.stereotype.Component;
import ru.surantaev.dto.CompanyRequest;
import ru.surantaev.entity.Company;

@Component
public class CompanyEditMapper {

    public Company create(CompanyRequest companyRequest) {
        if (companyRequest == null) {
            return null;
        }
        Company company = new Company();
        company.setCompanyName(companyRequest.getCompany_name());
        company.setLocatedCountry(companyRequest.getLocated_country());
        return company;
    }

    public void update(Company company, CompanyRequest companyRequest) {
        company.setCompanyName(companyRequest.getCompany_name());
        company.setLocatedCountry(companyRequest.getLocated_country());
    }
}
