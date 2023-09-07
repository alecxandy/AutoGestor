package https.github.com.alecxandy.AutoGestorGURU.msprofessor.model.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
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
