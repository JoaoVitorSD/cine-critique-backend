package softeng.cinecritique.infraestructure.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import softeng.cinecritique.app.domain.exception.ElementNotFoundException;
import softeng.cinecritique.app.domain.input.MovieRateInput;
import softeng.cinecritique.app.usecases.MovieRateInteractor;
import softeng.cinecritique.infraestructure.controllers.mapper.MovieRateDTOMapper;
import softeng.cinecritique.infraestructure.controllers.request.MovieRateRequest;
import softeng.cinecritique.infraestructure.controllers.response.MovieRateResponse;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/movie/rate")
@Tag(name = "Movie Rating", description = "Movie rating and listing by movie and user")
public class MovieRateController {
    private final MovieRateInteractor movieRateInteractor;
    private final MovieRateDTOMapper movieRateDTOMapper;

    public MovieRateController(MovieRateInteractor movieRateInteractor, MovieRateDTOMapper movieRateDTOMapper) {
        this.movieRateInteractor = movieRateInteractor;
        this.movieRateDTOMapper = movieRateDTOMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary ="Create")
    public MovieRateResponse createMovie(@RequestBody @Valid MovieRateRequest request) throws ElementNotFoundException {
        MovieRateInput rate = movieRateDTOMapper.toMovieRateInput(request);
        return movieRateDTOMapper.toResponse(movieRateInteractor.rateMovie(rate));
    }

    @PutMapping
    @Operation(summary ="Update")
    public MovieRateResponse updateMovie(@RequestBody @Valid MovieRateRequest request) throws ElementNotFoundException {
        MovieRateInput rate = movieRateDTOMapper.toMovieRateInput(request);
        return movieRateDTOMapper.toResponse(movieRateInteractor.updateRate(rate));
    }

    @GetMapping
    @Operation(summary ="Listing")
    public List<MovieRateResponse> listMovies(@RequestParam(required = false) UUID movie,
                                               @RequestParam(required = false) UUID user

    ) {
        return movieRateInteractor.getRates(movie, user).stream()
                .map(movieRateDTOMapper::toResponse).toList();
    }
}
