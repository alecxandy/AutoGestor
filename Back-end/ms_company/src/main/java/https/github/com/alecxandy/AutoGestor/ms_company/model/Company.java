package https.github.com.alecxandy.AutoGestor.ms_company.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tb_company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @JsonProperty(namespace = "RazaoSocial")
    private String corporateReason;

    @CNPJ
    @NotBlank
    private String cnpj;

    @NotBlank
    @JsonProperty(namespace = "nomeFantasia")
    private String fantasyName;

    @JsonProperty(namespace = "numeroDeTelefone")
    private String phoneNumber;

    @ManyToMany
    @JoinTable(name = "company_has_associate",
            joinColumns = {@JoinColumn(name = "company_id")},
            inverseJoinColumns = {@JoinColumn(name = "associate_id")})
    private List<Associate> associateList;

}
