package https.github.com.alecxandy.AutoGestorGURU.ms_student.service;

import https.github.com.alecxandy.AutoGestorGURU.ms_student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


}
