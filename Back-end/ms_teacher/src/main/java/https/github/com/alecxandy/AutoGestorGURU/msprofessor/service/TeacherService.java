package https.github.com.alecxandy.AutoGestorGURU.msprofessor.service;

import https.github.com.alecxandy.AutoGestorGURU.msprofessor.exception.IdentifierNotFoundException;
import https.github.com.alecxandy.AutoGestorGURU.msprofessor.model.Teacher;
import https.github.com.alecxandy.AutoGestorGURU.msprofessor.repository.TeacherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ModelMapper modelMapper;

    public TeacherService(TeacherRepository teacherRepository, ModelMapper modelMapper) {
        this.teacherRepository = teacherRepository;
        this.modelMapper = modelMapper;
    }

    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public List<Teacher> listAll() {
        return teacherRepository.findAll();
    }

    public Teacher findById(Long id) {
        return teacherRepository.findById(id).orElseThrow(() -> new IdentifierNotFoundException());
    }

    public void deleteById(Long id) {
        teacherRepository.findById(id).map(teacher -> {
            teacherRepository.deleteById(id);
            return teacher;
        }).orElseThrow(() -> new IdentifierNotFoundException());
    }

    public Teacher update(Teacher teacher, Long id) {
        return teacherRepository.findById(id).map(t -> {
            t.setId(id);
            t.setBirthDate(teacher.getBirthDate());
            t.setEmail(teacher.getEmail());
            t.setCpf(teacher.getCpf());
            t.setName(teacher.getName());
            teacherRepository.save(t);
            return t;
        }).orElseThrow(() -> new IdentifierNotFoundException());
    }

    public List<Teacher> findByNameContaining(String name) {
        return teacherRepository.findByNameContaining(name);
    }

}
