package softeng.cinecritique.app.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Genre {

    private UUID id;
    private String name;

    private LocalDate createdAt;

    private List<Movie> movies;

    public Genre(UUID id) {
        this.id = id;
    }

    public void update(Genre genre){
        this.name = genre.name;
    }
}
