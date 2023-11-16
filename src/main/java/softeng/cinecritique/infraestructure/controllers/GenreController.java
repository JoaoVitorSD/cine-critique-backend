package softeng.cinecritique.infraestructure.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import softeng.cinecritique.app.domain.Genre;
import softeng.cinecritique.app.domain.PageModel;
import softeng.cinecritique.app.usecases.GenreInteractor;
import softeng.cinecritique.infraestructure.controllers.mapper.GenreDTOMapper;
import softeng.cinecritique.infraestructure.controllers.request.GenreRequest;
import softeng.cinecritique.infraestructure.controllers.response.GenreResponse;

@RestController
@RequestMapping("api/v1/genre")
@Tag(name = "Genre", description = "Creating, Updating and Listing Genres")
public class GenreController {
    private final GenreInteractor genreInteractor;
    private final GenreDTOMapper genreDTOMapper;

    public GenreController(GenreInteractor genreInteractor, GenreDTOMapper genreDTOMapper) {
        this.genreInteractor = genreInteractor;
        this.genreDTOMapper = genreDTOMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary ="Create")
    public GenreResponse createGenre(@RequestBody @Valid GenreRequest request){
        Genre genre = genreDTOMapper.toModel(request);
        return genreDTOMapper.toResponse(genreInteractor.createGenre(genre));
    }

    @PutMapping
    @Operation(summary ="Update")
    public GenreResponse updateGenre(@RequestBody @Valid GenreRequest request){
        Genre genre = genreDTOMapper.toModel(request);
        return genreDTOMapper.toResponse(genreInteractor.updateGenre(genre));
    }

    @GetMapping
    @Operation(summary ="Listing by name")
    public PageModel<GenreResponse> getGenres(@RequestParam(defaultValue = "0") Integer page,
                                              @RequestParam(defaultValue = "10") Integer size, @RequestParam(defaultValue = "") String name){
        return genreInteractor.listGenres(page, size, name).map(genreDTOMapper::toResponse);
    }
}
