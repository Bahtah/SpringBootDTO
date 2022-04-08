package ru.surantaev.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.surantaev.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}