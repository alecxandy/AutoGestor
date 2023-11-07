package https.github.com.alecxandy.AutoGestor.git.ms_vehicle.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_Vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty("modelo")
    private String model;

    @JsonProperty("AnoManutencao")
    private int yearOfManufacture;

    @JsonProperty("disponibilidade")
    private String availability;

}
