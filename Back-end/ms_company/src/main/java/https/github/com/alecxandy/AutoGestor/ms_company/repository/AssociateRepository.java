package https.github.com.alecxandy.AutoGestor.ms_company.repository;

import https.github.com.alecxandy.AutoGestor.ms_company.model.Associate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssociateRepository extends JpaRepository<Associate, Long> {
    Optional<Associate> findByCpf(String cnpj);
}
