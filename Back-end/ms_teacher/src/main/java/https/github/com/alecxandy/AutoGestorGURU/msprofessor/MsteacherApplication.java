package https.github.com.alecxandy.AutoGestorGURU.msprofessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsteacherApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsteacherApplication.class, args);
	}

	//comando gerar build/jar da aplicação sem testes
	// ./mvnw clean package -DskipTests

	// comando para subir aplicação
	// cd target
	// java -jar .\eureka-0.0.1-SNAPSHOT.jar

	//gerar o imagem
	// nao esquecer de voltar para pastar principal
	//docker build --tag eureka .

	//rodar container
	//comando, nome , portas, network_de_comunicao, nome_imagem
	//docker run --name eureka -p 8761:8761 --network network eureka

	//criar um network para comunicao entre os microservicos
	//docker network create network

	//criando uma imagem e container postgresql com banco de dados
	//docker run --name some-postgres -p 5433:5432 -e POSTGRES_PASSWORD=123456 e- POSTGRES_DB=endereco_db --network network
	// -d postgres

    /*
    FROM openjdk:17
    WORKDIR /app
    COPY ./target/eureka-0.0.1-SNAPSHOT.jar  app.jar
    EXPOSE 8761
    ENTRYPOINT java -jar app.jar
    */

    /*
	FROM maven:3.8.5-openjdk-17 as build
	WORKDIR /app
	COPY . .
	RUN mvn clean package -DskipTests
    */


}
