package ru.surantaev.mapper;

import org.springframework.stereotype.Component;
import ru.surantaev.dto.CompanyResponce;
import ru.surantaev.entity.Company;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyViewMapper {

    public CompanyResponce viewCompany(Company company) {
        if (company == null) {
            return null;
        }
        CompanyResponce responce = new CompanyResponce();
        if (company.getId() != null) {
            responce.setId(String.valueOf(company.getId()));
        }
        responce.setCompany_name(company.getCompanyName());
        responce.setLocated_country(company.getLocatedCountry());
        responce.setCourse(company.getCourse());
        return responce;
    }

    public List<CompanyResponce> view(List<Company> company) {
        List<CompanyResponce> responces = new ArrayList<>();
        for (Company c : company) {
            responces.add(viewCompany(c));
        }
        return responces;
    }
}
