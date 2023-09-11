package https.github.com.alecxandy.AutoGestorGURU.ms_user.repository;

import https.github.com.alecxandy.AutoGestorGURU.ms_user.model.ProfilePhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoUserRepository extends JpaRepository<ProfilePhoto, Long> {
}
