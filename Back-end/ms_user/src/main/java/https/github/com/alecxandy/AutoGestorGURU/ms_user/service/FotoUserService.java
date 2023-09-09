package https.github.com.alecxandy.AutoGestorGURU.ms_user.service;

import https.github.com.alecxandy.AutoGestorGURU.ms_user.model.FotoUser;
import https.github.com.alecxandy.AutoGestorGURU.ms_user.repository.FotoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FotoUserService {

    @Autowired
    private FotoUserRepository fotoUserRepository;

    @Transactional
    public FotoUser save(FotoUser fotoUserInput) {
        return fotoUserRepository.save(fotoUserInput);
    }

    @Transactional
    public List<FotoUser> findAll() {
        return fotoUserRepository.findAll();
    }


}
