package softeng.cinecritique;

import com.fasterxml.jackson.core.type.TypeReference;
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
import softeng.cinecritique.infrastructure.controllers.request.MovieRateRequest;
import softeng.cinecritique.infrastructure.controllers.response.MovieRateResponse;
import softeng.cinecritique.infrastructure.entity.UserEntity;
import softeng.cinecritique.infrastructure.persistence.MovieRepository;
import softeng.cinecritique.infrastructure.persistence.UserRepository;

import java.util.List;
import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class MovieRateTests {

    @Autowired
    private MockMvc mockMvc;


    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieRepository movieRepository;

    private UUID getNewUser(int number){
        return userRepository.save(new UserEntity(null, "Docinho de Leite"+ number, "123456","docinhoLeite"+number, 20, number+"docinho@leite.com")).getId();
    }
    @Test
    @Transactional
    @Rollback
    public void GivenRatingMovie_WhenValid_Return201() throws Exception{

        MovieRateRequest request = new MovieRateRequest(null, movieRepository.findAll().get(0).getId(),10f,getNewUser(0));

        MovieRateResponse response =  objectMapper.readValue(mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/movie/rate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString(), MovieRateResponse.class);

        Assertions.assertEquals(request.rate(), response.rate());
    }

    @Test
    @Transactional
    @Rollback
    public void GivenRatingMovie_WhenRateGreaterThan10_Return400() throws Exception{

        MovieRateRequest request = new MovieRateRequest(null, movieRepository.findAll().get(0).getId(),11f,getNewUser(0));

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/movie/rate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());

    }

    @Test
    @Transactional
    @Rollback
    public void GivenRatingMovie_WhenRateLessThan0_Return400() throws Exception{

        MovieRateRequest request = new MovieRateRequest(null, movieRepository.findAll().get(0).getId(),-1f,getNewUser(0));

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/movie/rate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());

    }


    @Test
    @Transactional
    @Rollback
    public void GivenRatingMovie_WhenUserNull_Return400() throws Exception{

        MovieRateRequest request = new MovieRateRequest(null, movieRepository.findAll().get(0).getId(),1f,null);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/movie/rate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());

    }

    @Test
    @Transactional
    @Rollback
    public void GivenRatingMovie_WhenUserNotExists_Return404() throws Exception{

        MovieRateRequest request = new MovieRateRequest(null, movieRepository.findAll().get(0).getId(),1f, UUID.randomUUID());

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/movie/rate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isNotFound());

    }


    @Test
    @Transactional
    @Rollback
    public void GivenRatingMovie_WhenMovieNull_Return400() throws Exception{

        MovieRateRequest request = new MovieRateRequest(null,null,1f, getNewUser(0));

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/movie/rate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());

    }

    @Test
    @Transactional
    @Rollback
    public void GivenRatingMovie_WhenMovieNotExists_Return404() throws Exception{

        MovieRateRequest request = new MovieRateRequest(null,UUID.randomUUID(),1f, getNewUser(0));

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/movie/rate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isNotFound());

    }


    @Test
    @Transactional
    @Rollback
    public void GivenRatingMovie_WhenUserAlreadyRated_Return400() throws Exception{

        MovieRateRequest request = new MovieRateRequest(null,movieRepository.findAll().get(0).getId(),1f, getNewUser(0));

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/movie/rate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated());


        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/movie/rate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());

    }

    @Test
    @Transactional
    @Rollback
    public void GivenRatingMovie_WhenValid_Return201AndChangeRateAvg() throws Exception{

        MovieRateRequest request = new MovieRateRequest(null,movieRepository.findAll().get(0).getId(),1f, getNewUser(0));

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/movie/rate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated());


        List<MovieRateResponse> rates = objectMapper.readValue(mockMvc
                        .perform(MockMvcRequestBuilders.get("/api/v1/movie/rate")
                        .param("movie", movieRepository.findAll().get(0).getId().toString()))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString(), new TypeReference<>() {
        });

        float oldAvg =  rates.stream().reduce(0f, (acc,rate) -> acc + rate.rate(), Float::sum)/rates.size();

        request = new MovieRateRequest(null,movieRepository.findAll().get(0).getId(),10f, getNewUser(1));

        float newAvg = (oldAvg*rates.size() +request.rate())/(rates.size()+1);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/movie/rate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated());

        newAvg = Float.parseFloat(String.format("%.2f", newAvg).replace(",", "."));
        rates = objectMapper.readValue(mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/movie/rate").param("movie", movieRepository.findAll().get(0).getId().toString()))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString(), new TypeReference<>() {});

        float finalNewAvg  = rates.stream().reduce(0f, (acc, rate) -> acc + rate.rate(), Float::sum)/rates.size();

        finalNewAvg = Float.parseFloat(String.format("%.2f", finalNewAvg).replace(",", "."));
        Assertions.assertEquals(newAvg, finalNewAvg);

    }


}

