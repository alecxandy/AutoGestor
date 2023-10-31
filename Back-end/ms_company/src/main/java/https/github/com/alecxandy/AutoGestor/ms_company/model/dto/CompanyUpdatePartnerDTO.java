package https.github.com.alecxandy.AutoGestor.ms_company.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CompanyUpdatePartnerDTO {

    private Long companyId;
    private List<Integer> integerList;
}
