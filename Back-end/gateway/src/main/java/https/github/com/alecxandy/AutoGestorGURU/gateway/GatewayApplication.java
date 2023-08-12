package https.github.com.alecxandy.AutoGestorGURU.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/teacher/**").uri("lb://msteacher"))
				.route(p -> p.path("/address/**").uri("lb://msaddress"))
				.route(p -> p.path("/student/**").uri("lb://msstudent"))
				.route(p -> p.path("/user/**").uri("lb://msuser"))
				.build();
	}

}
