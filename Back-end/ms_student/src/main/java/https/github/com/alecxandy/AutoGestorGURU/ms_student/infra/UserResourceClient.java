package https.github.com.alecxandy.AutoGestorGURU.ms_student.infra;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "msuser", path = "/user")
public interface UserResourceClient {


}
