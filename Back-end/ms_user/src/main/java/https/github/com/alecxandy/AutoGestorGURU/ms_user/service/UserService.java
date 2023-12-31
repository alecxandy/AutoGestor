package https.github.com.alecxandy.AutoGestorGURU.ms_user.service;

import https.github.com.alecxandy.AutoGestorGURU.ms_user.exception.IdentifierNotFoundException;
import https.github.com.alecxandy.AutoGestorGURU.ms_user.model.User;
import https.github.com.alecxandy.AutoGestorGURU.ms_user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Transactional
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IdentifierNotFoundException());
    }

    @Transactional
    public User update(User user) {
        return userRepository.findById(user.getId()).map(u -> {
            userRepository.save(user);
            return u;
        }).orElseThrow(() -> new IdentifierNotFoundException());
    }

    @Transactional
    public void deleteById(Long id) {
        userRepository.findById(id).map(user -> {
            userRepository.deleteById(id);
            return user;
        }).orElseThrow(() -> new IdentifierNotFoundException());
    }

    @Transactional
    public User findByCpf(String cpf) {
        return userRepository.findByCpf(cpf).orElseThrow(() -> new IdentifierNotFoundException());
    }


}
