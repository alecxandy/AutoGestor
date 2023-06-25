package https.github.com.alecxandy.AutoGestorGURU.msprofessor.controller;

import https.github.com.alecxandy.AutoGestorGURU.msprofessor.model.Teacher;
import https.github.com.alecxandy.AutoGestorGURU.msprofessor.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }


    @PostMapping
    public ResponseEntity<Teacher> save(@RequestBody Teacher teacher) {
        return ResponseEntity.status(HttpStatus.CREATED).body(teacherService.save(teacher));
    }

    @GetMapping
    public ResponseEntity<List<Teacher>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "id") Long id) {
        teacherService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teacher> update(@RequestBody Teacher teacher, @PathVariable(name = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.update(teacher, id));
    }

    @GetMapping("search/{name}")
    public ResponseEntity<List<Teacher>> findByNameContaining(@PathVariable(name = "name") String name) {
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.findByNameContaining(name));
    }

}
