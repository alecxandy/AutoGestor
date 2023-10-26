package https.github.com.alecxandy.AutoGestor.ms_company.service;

import https.github.com.alecxandy.AutoGestor.ms_company.exception.IdentifierNotFoundException;
import https.github.com.alecxandy.AutoGestor.ms_company.model.Company;
import https.github.com.alecxandy.AutoGestor.ms_company.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Transactional
    public Page<Company> findAll(Pageable pageable) {
        return companyRepository.findAll(pageable);
    }

    @Transactional
    public Company findById(Long id) {
        return companyRepository.findById(id).orElseThrow(() -> new IdentifierNotFoundException());
    }

    @Transactional
    public Company update(Company company) {
        return companyRepository.findById(company.getId()).map(u -> {
            companyRepository.save(company);
            return u;
        }).orElseThrow(() -> new IdentifierNotFoundException());
    }

    @Transactional
    public void deleteById(Long id) {
        companyRepository.findById(id).map(user -> {
            companyRepository.deleteById(id);
            return user;
        }).orElseThrow(() -> new IdentifierNotFoundException());
    }

    @Transactional
    public Company findByCpf(String cpf) {
        return companyRepository.findByCnpj(cpf).orElseThrow(() -> new IdentifierNotFoundException());
    }


}
