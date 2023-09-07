package https.github.com.alecxandy.AutoGestorGURU.ms_student.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long id;
    private String name;
    private String cpf;
    private String password;

}
