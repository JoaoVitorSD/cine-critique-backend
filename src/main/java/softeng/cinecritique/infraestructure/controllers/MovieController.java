package softeng.cinecritique.infraestructure.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import softeng.cinecritique.app.domain.Movie;
import softeng.cinecritique.app.domain.PageModel;
import softeng.cinecritique.app.usecases.MovieInteractor;
import softeng.cinecritique.app.usecases.MovieInteractor;
import softeng.cinecritique.infraestructure.controllers.mapper.MovieDTOMapper;
import softeng.cinecritique.infraestructure.controllers.request.MovieRequest;
import softeng.cinecritique.infraestructure.controllers.response.MovieResponse;

@RestController
@RequestMapping("api/v1/movie")
@Tag(name = "Movie Managing", description = "Saving, updating and listing movies")
public class MovieController {
    private final MovieInteractor movieInteractor;
    private final MovieDTOMapper genreDTOMapper;

    public MovieController(MovieInteractor movieInteractor, MovieDTOMapper genreDTOMapper) {
        this.movieInteractor = movieInteractor;
        this.genreDTOMapper = genreDTOMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary ="Create")
    public MovieResponse createMovie(@RequestBody MovieRequest request){
        Movie genre = genreDTOMapper.toModel(request);
        return genreDTOMapper.toResponse(movieInteractor.createMovie(genre));
    }

    @PutMapping
    @Operation(summary ="Update")
    public MovieResponse updateMovie(@RequestBody MovieRequest request){
        Movie genre = genreDTOMapper.toModel(request);
        return genreDTOMapper.toResponse(movieInteractor.updateMovie(genre));
    }

    @GetMapping
    @Operation(summary ="Listing")
    public PageModel<MovieResponse> getMovies(@RequestParam(defaultValue = "0") Integer page,
                                              @RequestParam(defaultValue = "10") Integer size, @RequestParam(defaultValue = "") String name,  @RequestParam(defaultValue = "") String genre){
        return movieInteractor.getMovies(page, size, name, genre).map(genreDTOMapper::toResponse);
    }
}
