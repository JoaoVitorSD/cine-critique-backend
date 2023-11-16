package softeng.cinecritique;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Cine Critique Rest Api",
		description = "Movies rating and classification by genre",
		version = "1.0.0", contact = @Contact(name = "Grupo 11", email = "joaovitorsantanadepollo@gmail.com")))

public class CineCritiqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(CineCritiqueApplication.class, args);
	}

}
