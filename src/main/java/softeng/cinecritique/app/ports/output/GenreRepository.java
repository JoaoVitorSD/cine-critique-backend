package softeng.cinecritique.app.ports.output;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import softeng.cinecritique.app.domain.entity.GenreEntity;
import softeng.cinecritique.app.domain.entity.MovieEntity;

import java.util.List;
import java.util.UUID;

public interface GenreRepository extends JpaRepository<GenreEntity, UUID>{
    @Query("SELECT  m from MovieEntity m where m.genre = :genre")
    List<MovieEntity> findByGenre(@Param("genre") GenreEntity genre);
}
