package https.github.com.alecxandy.AutoGestor.ms_company.repository;

import https.github.com.alecxandy.AutoGestor.ms_company.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByCnpj(String cpf);
}
