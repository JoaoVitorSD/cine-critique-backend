package softeng.cinecritique.app.gateway;

import softeng.cinecritique.app.domain.Genre;
import softeng.cinecritique.app.domain.PageModel;

import java.util.Optional;
import java.util.UUID;

public interface GenreGateway {

    Genre createGenre(Genre genre);

    Genre updateGenre(Genre genre);

    PageModel<Genre> listGenre(Integer page, Integer size, String name);

    boolean existsByNameWithDifferentId(String name, UUID id);


    Optional<Genre> findById(UUID id);
}
