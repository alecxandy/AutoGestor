package https.github.com.alecxandy.AutoGestorGURU.msprofessor.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherAddressResponseDTO {

    private Long id;
    private String name;
    private String cpf;
    private String email;
    private Date birthDate;
    private AddressDTO addressDTO;
}
