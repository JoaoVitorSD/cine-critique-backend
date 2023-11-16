package softeng.cinecritique.infraestructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import softeng.cinecritique.infraestructure.entity.MovieRateEntity;
import java.util.List;
import java.util.UUID;

public interface MovieRateRepository extends JpaRepository<MovieRateEntity, UUID> {


    @Query("select m from MovieRateEntity m where m.movie.id = ?1 and m.user.id = ?2")
    List<MovieRateEntity> findByMovieAndUserName(UUID movie, UUID user);
}
