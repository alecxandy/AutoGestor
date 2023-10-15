package https.github.com.alecxandy.AutoGestorGURU.ms_user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty("nome")
    @NotBlank(message = "Please fill in the 'name' field correctly")
    private String name;

    @NotBlank(message = "Please fill in the 'CPF' field correctly")
    @CPF(message = "CPF invalid")
    private String cpf;

    @JsonIgnore
    @JsonProperty("senha")
    @NotBlank(message = "Please fill in the 'password' field correctly")
    private String password;


}
