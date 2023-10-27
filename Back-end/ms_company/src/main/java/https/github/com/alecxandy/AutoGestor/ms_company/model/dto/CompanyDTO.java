package https.github.com.alecxandy.AutoGestor.ms_company.model.dto;

import lombok.Getter;
import lombok.Setter;

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
