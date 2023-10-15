package https.github.com.alecxandy.AutoGestorGURU.ms_student.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long address_id;
    private Long user_id;
    private String name;
    private String cpf;
    private String rg;
    private String renach;
    private LocalDate dt_renach;
    private String status;
    private String category;
}
