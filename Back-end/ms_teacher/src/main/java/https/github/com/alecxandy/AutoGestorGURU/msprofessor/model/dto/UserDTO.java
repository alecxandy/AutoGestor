package https.github.com.alecxandy.AutoGestorGURU.msprofessor.model.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_user")
public class UserDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Please fill in the 'name' field correctly")
    private String name;

    @NotBlank(message = "Please fill in the 'CPF' field correctly")
    @CPF(message = "CPF invalid")
    private String cpf;

}
