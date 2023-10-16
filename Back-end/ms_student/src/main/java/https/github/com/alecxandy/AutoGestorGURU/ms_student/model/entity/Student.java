package https.github.com.alecxandy.AutoGestorGURU.ms_student.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty("nome")
    @NotBlank(message = "Please fill in the 'name' field correctly")
    private String name;

    @CPF(message = "Please fill in the 'CPF' field correctly")
    private String cpf;

    @NotBlank(message = "Please fill in the 'RG' field correctly")
    private String rg;

    @NotBlank(message = "Please fill in the 'Renach' field correctly")
    private String renach;

    @JsonProperty("data do renach")
    private LocalDate dt_renach;

    private String status;

    @JsonProperty("categoria")
    @NotBlank(message = "Please fill in the 'Category' field correctly")
    private String category;
}
