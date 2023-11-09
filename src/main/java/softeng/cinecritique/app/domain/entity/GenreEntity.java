package softeng.cinecritique.app.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GenreEntity {

    @Id
    @Column(name = "genre_id")
    private UUID id;

    private String name;

    private Date creation_date;

    @ManyToMany
    private List<MovieEntity> movies;
}
