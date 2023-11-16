package softeng.cinecritique.infraestructure.entity;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class MovieGenreKey {

    UUID movieId;
    UUID genreId;

}
