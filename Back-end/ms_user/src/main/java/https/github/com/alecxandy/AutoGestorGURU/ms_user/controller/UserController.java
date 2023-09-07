package https.github.com.alecxandy.AutoGestorGURU.ms_user.controller;

import https.github.com.alecxandy.AutoGestorGURU.ms_user.model.User;
import https.github.com.alecxandy.AutoGestorGURU.ms_user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> save(@RequestBody @Valid User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @GetMapping
    public ResponseEntity<Page<User>> listAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("\n" +
                "successfully deleted");
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody @Valid User user) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.update(user));
    }

    @GetMapping("/search")
    public ResponseEntity<User> findByCpf(@RequestParam(name = "cpf", required = true) String cpf) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findByCpf(cpf));
    }

}
