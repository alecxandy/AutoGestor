package https.github.com.alecxandy.AutoGestorGURU.msprofessor.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_professor")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty(namespace = "nome")
    @NotBlank(message = "value cannot be null")
    private String name;

    @CPF(message = "invalid cpf")
    private String cpf;

    @Email(message = "invalid email")
    private String email;

    @JsonProperty(namespace = "dataNascimento")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date birthDate;

}
