package https.github.com.alecxandy.AutoGestorGURU.ms_user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
@Entity
public class FotoUser {

    @Id
    private Long id;

    private String descricao;

    private String contentType;

    private Long tamanho;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private MultipartFile multipartFile;

}
