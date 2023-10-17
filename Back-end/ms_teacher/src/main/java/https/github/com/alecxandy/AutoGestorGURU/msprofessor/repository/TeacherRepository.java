package https.github.com.alecxandy.AutoGestorGURU.msprofessor.repository;

import https.github.com.alecxandy.AutoGestorGURU.msprofessor.model.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findByNameContaining(String name);
    Optional<Teacher> findByCpf(String cpf);
}
