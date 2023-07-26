package https.github.com.alecxandy.AutoGestorGURU.msprofessor.infra;

import https.github.com.alecxandy.AutoGestorGURU.msprofessor.model.dto.AddressDTO;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient(value = "msaddress", path = "/address")
public interface AddressResourceClient {

    @PostMapping
    ResponseEntity<Long> save(@RequestBody @Valid AddressDTO addressDTO);

    @GetMapping("/{id}")
    public ResponseEntity<Optional<AddressDTO>> findById(@PathVariable Long id);

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "id") Long id);

    @PutMapping
    public ResponseEntity<AddressDTO> update(@RequestBody AddressDTO addressDTO);

}
