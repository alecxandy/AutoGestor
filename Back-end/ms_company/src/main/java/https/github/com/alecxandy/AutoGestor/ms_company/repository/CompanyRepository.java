package https.github.com.alecxandy.AutoGestor.ms_company.repository;

import https.github.com.alecxandy.AutoGestor.ms_company.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
