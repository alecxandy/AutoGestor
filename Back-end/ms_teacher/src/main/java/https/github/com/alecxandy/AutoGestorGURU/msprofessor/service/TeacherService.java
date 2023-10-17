package https.github.com.alecxandy.AutoGestorGURU.msprofessor.service;

import https.github.com.alecxandy.AutoGestorGURU.msprofessor.exception.IdentifierNotFoundException;
import https.github.com.alecxandy.AutoGestorGURU.msprofessor.model.entity.Teacher;
import https.github.com.alecxandy.AutoGestorGURU.msprofessor.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;


    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Transactional
    public Page<Teacher> findAll(Pageable pageable) {
        return teacherRepository.findAll(pageable);
    }

    @Transactional
    public Teacher findById(Long id) {
        return teacherRepository.findById(id).orElseThrow(() -> new IdentifierNotFoundException());
    }

    @Transactional
    public Teacher update(Teacher teacher) {
        return teacherRepository.findById(teacher.getId()).map(t -> {
            teacherRepository.save(teacher);
            return t;
        }).orElseThrow(() -> new IdentifierNotFoundException());
    }

    @Transactional
    public void deleteById(Long id) {
        teacherRepository.findById(id).map(t -> {
            teacherRepository.deleteById(id);
            return t;
        }).orElseThrow(() -> new IdentifierNotFoundException());
    }

    @Transactional
    public Teacher findByCpf(String cpf) {
        return teacherRepository.findByCpf(cpf).orElseThrow(() -> new IdentifierNotFoundException());
    }


}
