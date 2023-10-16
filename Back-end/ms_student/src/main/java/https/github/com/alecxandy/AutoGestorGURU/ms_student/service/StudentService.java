package https.github.com.alecxandy.AutoGestorGURU.ms_student.service;

import https.github.com.alecxandy.AutoGestorGURU.ms_student.exception.IdentifierNotFoundException;
import https.github.com.alecxandy.AutoGestorGURU.ms_student.model.entity.Student;
import https.github.com.alecxandy.AutoGestorGURU.ms_student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Transactional
    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new IdentifierNotFoundException());
    }

    @Transactional
    public Student update(Student student) {
        return studentRepository.findById(student.getId()).map(e -> {
            studentRepository.save(student);
            return e;
        }).orElseThrow(() -> new IdentifierNotFoundException());
    }

    @Transactional
    public void deleteById(Long id) {
        studentRepository.findById(id).map(e -> {
            studentRepository.deleteById(id);
            return e;
        }).orElseThrow(() -> new IdentifierNotFoundException());
    }

    @Transactional
    public Student findByCpf(String cpf) {
        return studentRepository.findByCpf(cpf).orElseThrow(() -> new IdentifierNotFoundException());
    }


}
