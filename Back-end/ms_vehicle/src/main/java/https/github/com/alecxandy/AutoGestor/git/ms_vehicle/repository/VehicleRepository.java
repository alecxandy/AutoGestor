package https.github.com.alecxandy.AutoGestor.git.ms_vehicle.repository;

import https.github.com.alecxandy.AutoGestor.git.ms_vehicle.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
