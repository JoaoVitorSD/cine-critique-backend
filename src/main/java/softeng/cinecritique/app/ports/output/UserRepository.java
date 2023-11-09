package softeng.cinecritique.app.ports.output;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softeng.cinecritique.app.domain.entity.UserEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {


    List<UserEntity> findByAge(Integer age);
    boolean existsByEmail(String email);
}
