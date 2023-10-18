package https.github.com.alecxandy.AutoGestor.ms_company.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_associate")
public class Associate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty(namespace = "nome")
    @NotBlank
    private String name;

    @CPF(message = "CPF invalid")
    private String cpf;

    @JsonProperty(namespace = "DataNascimento")
    @NotBlank(message = "Please fill in the 'Data de nascimento' field correctly")
    private Date DateOfBirth;



}
