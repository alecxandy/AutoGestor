package https.github.com.alecxandy.AutoGestor.ms_company.controller;

import https.github.com.alecxandy.AutoGestor.ms_company.model.Associate;
import https.github.com.alecxandy.AutoGestor.ms_company.service.AssociateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AssociateController {


    @Autowired
    private AssociateService associateService;

    @PostMapping
    public ResponseEntity<Associate> save(@RequestBody @Valid Associate associate) {
        return ResponseEntity.status(HttpStatus.CREATED).body(associateService.save(associate));
    }

    @GetMapping
    public ResponseEntity<Page<Associate>> listAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(associateService.findAll(pageable));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Associate> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(associateService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "id") Long id) {
        associateService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("\n" +
                "successfully deleted");
    }

    @PutMapping
    public ResponseEntity<Associate> update(@RequestBody @Valid Associate associate) {
        return ResponseEntity.status(HttpStatus.OK).body(associateService.update(associate));
    }

    @GetMapping("/search")
    public ResponseEntity<Associate> findByCnpj(@RequestParam(name = "cnpj", required = true) String cnpj) {
        return ResponseEntity.status(HttpStatus.OK).body(associateService.findByCnpj(cnpj));
    }


}
