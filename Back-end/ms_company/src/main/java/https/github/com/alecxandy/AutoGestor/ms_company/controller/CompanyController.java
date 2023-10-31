package https.github.com.alecxandy.AutoGestor.ms_company.controller;

import https.github.com.alecxandy.AutoGestor.ms_company.model.Company;
import https.github.com.alecxandy.AutoGestor.ms_company.model.dto.CompanyDTO;
import https.github.com.alecxandy.AutoGestor.ms_company.model.dto.CompanyUpdatePartnerDTO;
import https.github.com.alecxandy.AutoGestor.ms_company.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping
    public ResponseEntity<Company> save(@RequestBody @Valid CompanyDTO companyDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(companyService.save(companyDTO));
    }

    @GetMapping
    public ResponseEntity<Page<Company>> listAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(companyService.findAll(pageable));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Company> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(companyService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "id") Long id) {
        companyService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("\n" +
                "successfully deleted");
    }

    @PutMapping
    public ResponseEntity<Company> update(@RequestBody @Valid CompanyDTO companyDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(companyService.update(companyDTO));
    }

    @GetMapping("/search")
    public ResponseEntity<Company> findByCnpj(@RequestParam(name = "cnpj", required = true) String cnpj) {
        return ResponseEntity.status(HttpStatus.OK).body(companyService.findByCnpj(cnpj));
    }

    @PatchMapping
    public ResponseEntity<Company> updatePartner(@RequestBody @Valid CompanyUpdatePartnerDTO companyUpdatePartnerDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(companyService.updatePartner(companyUpdatePartnerDTO));
    }

}
