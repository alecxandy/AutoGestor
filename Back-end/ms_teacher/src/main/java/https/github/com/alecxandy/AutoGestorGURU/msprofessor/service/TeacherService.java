package https.github.com.alecxandy.AutoGestorGURU.msprofessor.service;

import https.github.com.alecxandy.AutoGestorGURU.msprofessor.model.Teacher;
import https.github.com.alecxandy.AutoGestorGURU.msprofessor.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher save(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    public List<Teacher> listAll(){
        return teacherRepository.findAll();
    }

}
