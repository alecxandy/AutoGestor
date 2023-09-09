package https.github.com.alecxandy.AutoGestorGURU.ms_user.repository;

import https.github.com.alecxandy.AutoGestorGURU.ms_user.model.FotoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoUserRepository extends JpaRepository<FotoUser, Long> {
}
