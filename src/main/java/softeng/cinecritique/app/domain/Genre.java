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

    UUID id;
    String name;

    LocalDate createdAt;

    List<Movie> movies;

    public void update(Genre genre){
        this.name = genre.name;
    }
}
