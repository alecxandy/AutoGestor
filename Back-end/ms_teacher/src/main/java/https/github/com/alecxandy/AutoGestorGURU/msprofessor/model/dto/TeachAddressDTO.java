package https.github.com.alecxandy.AutoGestorGURU.msprofessor.model.dto;

import https.github.com.alecxandy.AutoGestorGURU.msprofessor.model.entity.Teacher;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeachAddressDTO {
    private AddressDTO addressDTO;
    private Teacher teacher;
}
