package https.github.com.alecxandy.AutoGestor.git.ms_vehicle.controller;

import https.github.com.alecxandy.AutoGestor.git.ms_vehicle.model.Vehicle;
import https.github.com.alecxandy.AutoGestor.git.ms_vehicle.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {


    @Autowired
    private VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<Vehicle> save(@RequestBody @Valid Vehicle vehicle) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.save(vehicle));
    }

    @GetMapping
    public ResponseEntity<Page<Vehicle>> listAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.listAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "id") Long id) {
        vehicleService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("\n" +
                "successfully deleted");
    }

    @PutMapping
    public ResponseEntity<Vehicle> update(@RequestBody @Valid Vehicle vehicle) {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.update(vehicle));
    }


}
