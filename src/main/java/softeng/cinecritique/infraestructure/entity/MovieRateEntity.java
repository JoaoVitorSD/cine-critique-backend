package softeng.cinecritique.infraestructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NotFound;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieRateEntity {

    @Id
    private UUID id;

    @ManyToOne
    private MovieEntity movie;

    private Float rate;

    @ManyToOne
    private UserEntity user;
}