package https.github.com.alecxandy.AutoGestor.git.ms_vehicle.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)//retorna apenas json não nullos
public class Error {
    private LocalDateTime timestamp;
    private String UserMessage;
    private String type;
    private String title;
    private HttpStatus status;
    private String details;
    private String instance;
    private List<String> errosList;


}
