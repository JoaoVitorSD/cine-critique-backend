package softeng.cinecritique.app.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    private UUID id;
    private String name;
    private String description;
    private LocalDate filmedAt;
    private LocalDate createdAt;

    private List<Genre> genres;

    private List<MovieRate> rates;

    public void update(Movie movie) {
        this.name = movie.getName();
        this.description = movie.getDescription();
        this.filmedAt = movie.getFilmedAt();
        this.genres = movie.getGenres();
    }
}
