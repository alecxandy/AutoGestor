package https.github.com.alecxandy.AutoGestorGURU.msprofessor.repository;

import https.github.com.alecxandy.AutoGestorGURU.msprofessor.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
