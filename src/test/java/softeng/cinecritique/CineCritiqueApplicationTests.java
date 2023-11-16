package softeng.cinecritique;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import softeng.cinecritique.infraestructure.controllers.request.GenreRequest;
import softeng.cinecritique.infraestructure.controllers.response.GenreResponse;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class CineCritiqueApplicationTests {

	@Autowired
	private MockMvc mockMvc;


	@Autowired
	private ObjectMapper objectMapper;


	@Test
	@Transactional
	@Rollback
	public void GivenCreatingGenre_WhenValid_Return201() throws Exception{

		GenreRequest request = new GenreRequest(null, "Animation");

		GenreResponse response =  objectMapper.readValue(mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/genre")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isCreated()).andReturn().getResponse().getContentAsString(), GenreResponse.class);

		Assertions.assertEquals(request.name(), response.name());
	}

	@Test
	@Transactional
	@Rollback
	public void GivenCreatingGenre_WhenNameEmpty_Return400() throws Exception{

		GenreRequest request = new GenreRequest(null, "");

		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/genre")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isBadRequest());

	}

	@Test
	@Transactional
	@Rollback
	public void GivenCreatingGenre_WhenNameInUse_Return400() throws Exception{

		GenreRequest request = new GenreRequest(null, "Animation");

		GenreResponse response =  objectMapper.readValue(mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/genre")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isCreated()).andReturn().getResponse().getContentAsString(), GenreResponse.class);

		Assertions.assertEquals(request.name(), response.name());

		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/genre")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isBadRequest());

	}

	@Test
	@Transactional
	@Rollback
	public void GivenCreatingGenre_WhenNameIgnoreCaseInUse_Return400() throws Exception{

		GenreRequest request = new GenreRequest(null, "Animation");

		GenreResponse response =  objectMapper.readValue(mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/genre")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isCreated()).andReturn().getResponse().getContentAsString(), GenreResponse.class);

		Assertions.assertEquals(request.name(), response.name());

		request = new GenreRequest(null, "animation");

		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/genre")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isBadRequest());

	}
	@Test
	@Transactional
	@Rollback
	public void GivenUpdatingGenre_WhenValid_Return200() throws Exception{

		GenreRequest request = new GenreRequest(null, "Animation");

		GenreResponse response =  objectMapper.readValue(mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/genre")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isCreated()).andReturn().getResponse().getContentAsString(), GenreResponse.class);

		GenreRequest request2 = new GenreRequest(response.id(), "Animation2");

		mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/genre")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(request2)))
				.andExpect(status().isOk());

	}

	@Test
	@Transactional
	@Rollback
	public void GivenUpdatingGenre_WhenNameInUse_Return400() throws Exception{

		GenreRequest request = new GenreRequest(null, "Animation");

		GenreResponse response =  objectMapper.readValue(mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/genre")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isCreated()).andReturn().getResponse().getContentAsString(), GenreResponse.class);

		GenreRequest request2 = new GenreRequest(null, "Animation2");

		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/genre")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(request2)))
				.andExpect(status().isCreated());

		request = new GenreRequest(response.id(), "Animation2");

		mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/genre")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isBadRequest());

	}
}
