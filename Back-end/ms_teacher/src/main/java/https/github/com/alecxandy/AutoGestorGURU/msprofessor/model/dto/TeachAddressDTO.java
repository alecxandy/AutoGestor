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


    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
