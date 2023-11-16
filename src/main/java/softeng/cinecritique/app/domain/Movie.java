package softeng.cinecritique.app.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    UUID id;
    String name;
    String description;
    Date filmedAt;
    Date createdAt;

    List<Genre> genres;
}
