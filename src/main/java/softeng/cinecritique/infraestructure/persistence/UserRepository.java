package softeng.cinecritique.infraestructure.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import softeng.cinecritique.infraestructure.entity.UserEntity;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {


    boolean existsByUsername(String userName);

    Optional<UserEntity> findByUsername(String userName);

    @Query("SELECT COUNT(u) > 0 FROM UserEntity u WHERE LOWER(u.username) = LOWER(?1) AND (u.id <> ?2 or ?2 is null)")
    boolean existsByIgnoreCaseUserNameAndIdNot(String userName, UUID id);


    Page<UserEntity> findAllByUsernameContainingIgnoreCase(String name, Pageable pageable);
}
