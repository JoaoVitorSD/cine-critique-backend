package softeng.cinecritique;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CineCritiqueApplicationTests {



	@Autowired
	private ObjectMapper objectMapper;


	@Test
	public void GivenCreatingGenre_WhenValid_Return201() throws Exception{

	}
}
