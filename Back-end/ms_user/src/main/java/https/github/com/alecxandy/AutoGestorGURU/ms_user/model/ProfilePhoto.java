package https.github.com.alecxandy.AutoGestorGURU.ms_user.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class ProfilePhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String contentType;
    private Long tamanho;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
