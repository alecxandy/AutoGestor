package https.github.com.alecxandy.AutoGestor.ms_company.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import https.github.com.alecxandy.AutoGestor.ms_company.model.Associate;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import java.util.List;

@Getter
@Setter
public class CompanyDTO {

    private Long id;

    private String corporateReason;

    private String cnpj;

    private String fantasyName;

    private String phoneNumber;

    private List<Integer> associateList;


}
