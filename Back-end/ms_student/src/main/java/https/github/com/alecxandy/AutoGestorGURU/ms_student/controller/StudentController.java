package https.github.com.alecxandy.AutoGestorGURU.ms_student.controller;

import https.github.com.alecxandy.AutoGestorGURU.ms_student.model.entity.Student;
import https.github.com.alecxandy.AutoGestorGURU.ms_student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;


    @GetMapping
    public String test() {
        return "Test aplicado com sucesso";
    }


}
