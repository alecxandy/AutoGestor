package https.github.com.alecxandy.AutoGestor.ms_company.service;

import https.github.com.alecxandy.AutoGestor.ms_company.exception.IdentifierNotFoundException;
import https.github.com.alecxandy.AutoGestor.ms_company.model.Associate;
import https.github.com.alecxandy.AutoGestor.ms_company.model.Company;
import https.github.com.alecxandy.AutoGestor.ms_company.repository.AssociateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AssociateService {

    @Autowired
    private AssociateRepository associateRepository;

    public Associate save(Associate associate) {
        return associateRepository.save(associate);
    }

    @Transactional
    public Page<Associate> findAll(Pageable pageable) {
        return associateRepository.findAll(pageable);
    }

    @Transactional
    public Associate findById(Long id) {
        return associateRepository.findById(id).orElseThrow(() -> new IdentifierNotFoundException());
    }

    @Transactional
    public Associate update(Associate associate) {
        return associateRepository.findById(associate.getId()).map(u -> {
            associateRepository.save(associate);
            return u;
        }).orElseThrow(() -> new IdentifierNotFoundException());
    }

    @Transactional
    public void deleteById(Long id) {
        associateRepository.findById(id).map(user -> {
            associateRepository.deleteById(id);
            return user;
        }).orElseThrow(() -> new IdentifierNotFoundException());
    }

    @Transactional
    public Associate findByCnpj(String cpf) {
        return associateRepository.findByCpf(cpf).orElseThrow(() -> new IdentifierNotFoundException());
    }


}
