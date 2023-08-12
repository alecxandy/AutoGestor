package https.github.com.alecxandy.AutoGestorGURU.ms_student.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentResponseDTO {
    private Long id;
    private AddressDTO addressDTO;
    private UserDto userDto;
    private String name;
    private String cpf;
    private String rg;
    private String renach;
    private LocalDate dt_renach;

}
