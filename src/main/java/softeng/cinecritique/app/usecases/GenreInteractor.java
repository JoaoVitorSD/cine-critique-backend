package softeng.cinecritique.app.usecases;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import softeng.cinecritique.app.domain.Genre;
import softeng.cinecritique.app.domain.PageModel;
import softeng.cinecritique.app.gateway.GenreGateway;
import softeng.cinecritique.app.domain.exception.ApiException;

import java.time.LocalDate;

public class GenreInteractor {

    GenreGateway genreGateway;

    public GenreInteractor(GenreGateway genreGateway) {
        this.genreGateway = genreGateway;
    }

    public Genre createGenre(Genre genre){
        if(genreGateway.existsByNameWithDifferentId(genre.getName(), genre.getId())){
            throw new ApiException(String.format("Genre %s already in use", genre.getName()));
        }
        genre.setCreatedAt(LocalDate.now());
        return genreGateway.createGenre(genre);
    }


    public Genre updateGenre(Genre genre){
        if(genre.getId() == null){
            throw new ApiException("Genre id is required for update");
        }
        Genre genreUpdated = genreGateway.findById(genre.getId())
                .orElseThrow(() -> new EntityNotFoundException("Genre not found"));

        if(genreGateway.existsByNameWithDifferentId(genre.getName(), genre.getId())){
            throw new ApiException(String.format("Genre %s already in use", genre.getName()));
        }

        genreUpdated.update(genre);
        return genreGateway.updateGenre(genreUpdated);
    }
    public PageModel<Genre> listGenres(Integer page, Integer size, String name){
        return genreGateway.listGenre(page, size, name);
    }
}
