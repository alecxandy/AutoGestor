package https.github.com.alecxandy.AutoGestorGURU.msprofessor.controller;

import https.github.com.alecxandy.AutoGestorGURU.msprofessor.model.entity.Teacher;
import https.github.com.alecxandy.AutoGestorGURU.msprofessor.service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping
    public ResponseEntity<Teacher> save(@RequestBody @Valid Teacher teacher) {
        return ResponseEntity.status(HttpStatus.CREATED).body(teacherService.save(teacher));
    }

    @GetMapping
    public ResponseEntity<Page<Teacher>> listAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "id") Long id) {
        teacherService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("\n" +
                "successfully deleted");
    }

    @PutMapping
    public ResponseEntity<Teacher> update(@RequestBody @Valid Teacher teacher) {
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.update(teacher));
    }

    @GetMapping("/search")
    public ResponseEntity<Teacher> findByCpf(@RequestParam(name = "cpf", required = true) String cpf) {
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.findByCpf(cpf));
    }


}
