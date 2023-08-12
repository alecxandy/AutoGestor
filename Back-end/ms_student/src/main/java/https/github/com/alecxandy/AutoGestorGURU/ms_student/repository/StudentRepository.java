package https.github.com.alecxandy.AutoGestorGURU.ms_student.repository;

import https.github.com.alecxandy.AutoGestorGURU.ms_student.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
