package https.github.com.alecxandy.AutoGestorGURU.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaApplication.class, args);
	}

	//comando gerar buid da aplicação
	// ./mvnw clean package -DskipTests
	// cd target
	// java -jar .\eureka-0.0.1- SNAPSHOT.jar



}
