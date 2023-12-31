package softeng.cinecritique.infrastructure.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import softeng.cinecritique.infrastructure.entity.MovieEntity;

import java.util.UUID;

public interface MovieRepository extends JpaRepository<MovieEntity, UUID> {

    @Query("SELECT m FROM MovieEntity m WHERE m.name LIKE %?1%")
    Page<MovieEntity> findByNameAndGenre(String name,String genre , Pageable pageable);
}
