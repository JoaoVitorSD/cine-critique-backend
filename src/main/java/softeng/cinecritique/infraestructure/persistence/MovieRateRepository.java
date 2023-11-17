package softeng.cinecritique.infraestructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import softeng.cinecritique.infraestructure.entity.MovieRateEntity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MovieRateRepository extends JpaRepository<MovieRateEntity, UUID> {


    @Query("select m from MovieRateEntity m where m.movie.id = ?1 and m.user.id = ?2")
    Optional<MovieRateEntity> findByMovieAndUser(UUID movie, UUID user);

    @Query("select m from MovieRateEntity m where (m.movie.id = ?1 or ?1 is null) and( m.user.id = ?2 or ?2 is null)")
    List<MovieRateEntity> findByMovieAndUserNulls(UUID movie, UUID user);
}
