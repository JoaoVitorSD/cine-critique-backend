package softeng.cinecritique.infraestructure.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import softeng.cinecritique.infraestructure.entity.GenreEntity;

import java.util.UUID;

public interface GenreRepository extends JpaRepository<GenreEntity, UUID> {


    @Query("SELECT COUNT(g) > 0 FROM GenreEntity g WHERE LOWER(g.name) = LOWER(?1) AND (g.id <> ?2 or ?2 is null)")
    boolean existsByIgnoreCaseNameAndIdNot(String name, UUID id);

    Page<GenreEntity> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
