package softeng.cinecritique.infrastructure.gateways;

import org.springframework.data.domain.PageRequest;
import softeng.cinecritique.app.domain.Genre;
import softeng.cinecritique.app.domain.PageModel;
import softeng.cinecritique.app.gateway.GenreGateway;
import softeng.cinecritique.infrastructure.entity.GenreEntity;
import softeng.cinecritique.infrastructure.gateways.mapper.GenreEntityMapper;
import softeng.cinecritique.infrastructure.persistence.GenreRepository;

import java.util.Optional;
import java.util.UUID;

public class GenreRepositoryGateway implements GenreGateway {
    private final GenreRepository genreRepository;

    public GenreRepositoryGateway(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }
    @Override
    public Genre createGenre(Genre genre){
        GenreEntity entity = GenreEntityMapper.toEntity(genre);
        return GenreEntityMapper.toModel(genreRepository.save(entity));

    }

    @Override
    public Genre updateGenre(Genre genre) {
        GenreEntity entity = GenreEntityMapper.toEntity(genre);
        return GenreEntityMapper.toModel(genreRepository.save(entity));
    }

    @Override
    public PageModel<Genre> listGenre(Integer page, Integer size, String name) {
        return GenreEntityMapper.toPageModel(genreRepository.findByNameContainingIgnoreCase(name, PageRequest.of(page, size)));
    }

    @Override
    public boolean existsByNameWithDifferentId(String name, UUID id) {
        return genreRepository.existsByIgnoreCaseNameAndIdNot(name, id);
    }

    @Override
    public Optional<Genre> findById(UUID id) {
        return genreRepository.findById(id).map(GenreEntityMapper::toModel);
    }
}
