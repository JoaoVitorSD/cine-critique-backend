package softeng.cinecritique.infraestructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import softeng.cinecritique.infraestructure.entity.GenreEntity;
import softeng.cinecritique.infraestructure.entity.MovieEntity;

import java.util.UUID;

public interface MovieRepository extends JpaRepository<MovieEntity, UUID> {
}
