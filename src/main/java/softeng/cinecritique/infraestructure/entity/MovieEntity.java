package softeng.cinecritique.infraestructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Fetch;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.sql.Date;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "movie")
@AllArgsConstructor
@NoArgsConstructor
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @ColumnDefault("random_uuid()")
    private UUID id;

    private String name;
    private String description;

    private LocalDate filmedAt;
    private LocalDate createdAt;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<GenreEntity> genres = new HashSet<>();
}
