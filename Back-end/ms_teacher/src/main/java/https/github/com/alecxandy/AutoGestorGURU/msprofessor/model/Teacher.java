package https.github.com.alecxandy.AutoGestorGURU.msprofessor.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_professor")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "value cannot be null")
    private String name;

    @CPF(message = "invalid cpf")
    private String cpf;

    @Email(message = "invalid email")
    private String email;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date birthDate;
}
