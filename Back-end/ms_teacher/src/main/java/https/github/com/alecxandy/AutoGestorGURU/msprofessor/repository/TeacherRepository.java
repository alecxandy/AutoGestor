package https.github.com.alecxandy.AutoGestorGURU.msprofessor.repository;

import https.github.com.alecxandy.AutoGestorGURU.msprofessor.model.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findByNameContaining(String name);
}
