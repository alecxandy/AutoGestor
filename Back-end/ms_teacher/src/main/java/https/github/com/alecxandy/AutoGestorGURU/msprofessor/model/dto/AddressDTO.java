package https.github.com.alecxandy.AutoGestorGURU.msprofessor.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    private Long id;
    private String country;
    private String state;
    private String city;
    private String district;
    private String road;
    private String zipCode;
}
