package softeng.cinecritique.app.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "movie")
public class MovieEntity {

    @Id
    @Column(name = "movie_id")
    private UUID id;

    private String name;

    private Date releaseDate;

    @ManyToOne
    private GenreEntity genre;
}
