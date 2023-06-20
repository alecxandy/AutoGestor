package https.github.com.alecxandy.AutoGestorGURU.msprofessor.controller;

import https.github.com.alecxandy.AutoGestorGURU.msprofessor.model.Teacher;
import https.github.com.alecxandy.AutoGestorGURU.msprofessor.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }


    @GetMapping
    public String start(){
        return "OK";
    }

    @PostMapping
    public ResponseEntity<Teacher> save(@RequestBody Teacher teacher) {
        return ResponseEntity.status(HttpStatus.CREATED).body(teacherService.save(teacher));
    }

  /*  @GetMapping
    public ResponseEntity<List<Teacher>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.listAll());
    }*/

}
