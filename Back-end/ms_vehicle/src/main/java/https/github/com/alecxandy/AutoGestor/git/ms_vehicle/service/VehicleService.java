package https.github.com.alecxandy.AutoGestor.git.ms_vehicle.service;

import https.github.com.alecxandy.AutoGestor.git.ms_vehicle.exception.IdentifierNotFoundException;
import https.github.com.alecxandy.AutoGestor.git.ms_vehicle.model.Vehicle;
import https.github.com.alecxandy.AutoGestor.git.ms_vehicle.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Transactional
    public Vehicle save(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Transactional
    public Page<Vehicle> listAll(Pageable pageable) {
        return vehicleRepository.findAll(pageable);
    }

    @Transactional
    public Vehicle findById(Long id) {
        return vehicleRepository.findById(id).orElseThrow(() -> new IdentifierNotFoundException());
    }

    @Transactional
    public Vehicle update(Vehicle vehicle) {
        return vehicleRepository.findById(vehicle.getId()).map(v -> {
            vehicleRepository.save(vehicle);
            return v;
        }).orElseThrow(() -> new IdentifierNotFoundException());
    }

    @Transactional
    public void deleteById(Long id) {
        vehicleRepository.findById(id).map(v -> {
            vehicleRepository.deleteById(id);
            return v;
        }).orElseThrow(() -> new IdentifierNotFoundException());
    }


}
