package https.github.com.alecxandy.AutoGestorGURU.ms_student.controller;

import https.github.com.alecxandy.AutoGestorGURU.ms_student.model.entity.Student;
import https.github.com.alecxandy.AutoGestorGURU.ms_student.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> save(@RequestBody @Valid Student student) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(student));
    }

    @GetMapping
    public ResponseEntity<Page<Student>> listAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "id") Long id) {
        studentService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("\n" +
                "successfully deleted");
    }

    @PutMapping
    public ResponseEntity<Student> update(@RequestBody @Valid Student student) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.update(student));
    }

    @GetMapping("/search")
    public ResponseEntity<Student> findByCpf(@RequestParam(name = "cpf", required = true) String cpf) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findByCpf(cpf));
    }


}
