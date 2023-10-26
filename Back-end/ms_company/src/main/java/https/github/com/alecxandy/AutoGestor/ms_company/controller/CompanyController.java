package https.github.com.alecxandy.AutoGestor.ms_company.controller;

import https.github.com.alecxandy.AutoGestor.ms_company.model.Company;
import https.github.com.alecxandy.AutoGestor.ms_company.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping
    public ResponseEntity<Company> save(@RequestBody @Valid Company company) {
        return ResponseEntity.status(HttpStatus.CREATED).body(companyService.save(company));
    }


}
