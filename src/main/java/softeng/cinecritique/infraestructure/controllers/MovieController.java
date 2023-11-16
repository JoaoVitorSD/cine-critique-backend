package softeng.cinecritique.infraestructure.controllers;

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
@RequestMapping("v1/movie")
public class MovieController {
    private final MovieInteractor movieInteractor;
    private final MovieDTOMapper genreDTOMapper;

    public MovieController(MovieInteractor movieInteractor, MovieDTOMapper genreDTOMapper) {
        this.movieInteractor = movieInteractor;
        this.genreDTOMapper = genreDTOMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieResponse createMovie(@RequestBody MovieRequest request){
        Movie genre = genreDTOMapper.toModel(request);
        return genreDTOMapper.toResponse(movieInteractor.createMovie(genre));
    }

    @PutMapping
    public MovieResponse updateMovie(@RequestBody MovieRequest request){
        Movie genre = genreDTOMapper.toModel(request);
        return genreDTOMapper.toResponse(movieInteractor.updateMovie(genre));
    }

    @GetMapping
    public PageModel<MovieResponse> getMovies(@RequestParam(defaultValue = "0") Integer page,
                                              @RequestParam(defaultValue = "10") Integer size, @RequestParam(defaultValue = "") String name,  @RequestParam(defaultValue = "") String genre){
        return movieInteractor.getMovies(page, size, name, genre).map(genreDTOMapper::toResponse);
    }
}
