package https.github.com.alecxandy.AutoGestorGURU.msprofessor.controller;

import https.github.com.alecxandy.AutoGestorGURU.msprofessor.model.dto.TeachAddressDTO;
import https.github.com.alecxandy.AutoGestorGURU.msprofessor.model.dto.TeacherAddressResponseDTO;
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
    public ResponseEntity<TeacherAddressResponseDTO> save(@RequestBody TeachAddressDTO teachAddressDTO) {
        System.out.println(teachAddressDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(teacherService.save(teachAddressDTO));
    }

    @GetMapping
    public ResponseEntity<List<TeacherAddressResponseDTO>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherAddressResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "id") Long id) {
        teacherService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping
    public ResponseEntity<TeacherAddressResponseDTO> update(@RequestBody TeachAddressDTO teachAddressDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.update(teachAddressDTO));
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<TeacherAddressResponseDTO>> findByNameContaining(@PathVariable(name = "name") String name) {
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.findByNameContaining(name));
    }


}
