package https.github.com.alecxandy.AutoGestorGURU.ms_user.service;

import https.github.com.alecxandy.AutoGestorGURU.ms_user.model.ProfilePhoto;
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
    public ProfilePhoto save(ProfilePhoto profilePhotoInput) {
        return fotoUserRepository.save(profilePhotoInput);
    }

    @Transactional
    public List<ProfilePhoto> findAll() {
        return fotoUserRepository.findAll();
    }


}
