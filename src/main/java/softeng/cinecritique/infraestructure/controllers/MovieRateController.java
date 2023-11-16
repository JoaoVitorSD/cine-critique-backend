package softeng.cinecritique.infraestructure.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import softeng.cinecritique.app.domain.input.MovieRateInput;
import softeng.cinecritique.app.usecases.MovieRateInteractor;
import softeng.cinecritique.infraestructure.controllers.mapper.MovieRateDTOMapper;
import softeng.cinecritique.infraestructure.controllers.request.MovieRateRequest;
import softeng.cinecritique.infraestructure.controllers.response.MovieRateResponse;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/movie/rate")
public class MovieRateController {
    private final MovieRateInteractor movieRateInteractor;
    private final MovieRateDTOMapper movieRateDTOMapper;

    public MovieRateController(MovieRateInteractor movieRateInteractor, MovieRateDTOMapper movieRateDTOMapper) {
        this.movieRateInteractor = movieRateInteractor;
        this.movieRateDTOMapper = movieRateDTOMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieRateResponse createMovie(@RequestBody @Valid MovieRateRequest request) {
        MovieRateInput rate = movieRateDTOMapper.toMovieRateInput(request);
        return movieRateDTOMapper.toResponse(movieRateInteractor.rateMovie(rate));
    }

    @PutMapping
    public MovieRateResponse updateMovie(@RequestBody @Valid MovieRateRequest request) {
        MovieRateInput rate = movieRateDTOMapper.toMovieRateInput(request);
        return movieRateDTOMapper.toResponse(movieRateInteractor.updateRate(rate));
    }

    @GetMapping
    public List<MovieRateResponse> listMovies(@RequestParam(defaultValue = "0") Integer page,
                                               @RequestParam(defaultValue = "10") Integer size,
                                               @RequestParam(required = false) UUID movie,
                                               @RequestParam(required = false) UUID user

    ) {
        return movieRateInteractor.getRates(page, size, movie, user).stream()
                .map(movieRateDTOMapper::toResponse).toList();
    }
}
