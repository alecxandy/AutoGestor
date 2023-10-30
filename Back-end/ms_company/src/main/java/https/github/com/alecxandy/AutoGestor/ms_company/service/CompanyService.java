package https.github.com.alecxandy.AutoGestor.ms_company.service;

import https.github.com.alecxandy.AutoGestor.ms_company.exception.IdentifierNotFoundException;
import https.github.com.alecxandy.AutoGestor.ms_company.model.Associate;
import https.github.com.alecxandy.AutoGestor.ms_company.model.Company;
import https.github.com.alecxandy.AutoGestor.ms_company.model.dto.CompanyDTO;
import https.github.com.alecxandy.AutoGestor.ms_company.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private AssociateService associateService;


    public Company save(CompanyDTO companyDTO) {
        Company company = new Company();
        company.setCnpj(companyDTO.getCnpj());
        company.setCorporateReason(companyDTO.getCorporateReason());
        company.setPhoneNumber(companyDTO.getPhoneNumber());
        company.setFantasyName(companyDTO.getFantasyName());
        company.setAssociateList(convertToList(companyDTO.getAssociateList()));
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
    public Company findByCnpj(String cnpj) {
        return companyRepository.findByCnpj(cnpj).orElseThrow(() -> new IdentifierNotFoundException());
    }

    @Transactional
    public List<Associate> convertToList(List<Integer> list) {
        List<Associate> associateList = new ArrayList<>();
        for (Integer i : list) {
            associateList.add(associateService.findById(i.longValue()));
        }
        return associateList;
    }


}
