package https.github.com.alecxandy.AutoGestorGURU.msprofessor.infra;


import https.github.com.alecxandy.AutoGestorGURU.msprofessor.model.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "msuser", path = "/user")
public interface UserResourceClient {

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id);


}
