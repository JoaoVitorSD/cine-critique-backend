package softeng.cinecritique.infraestructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import java.util.List;
import java.sql.Date;
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

    private Date filmedAt;
    private Date createdAt;

    @ManyToMany
    private List<GenreEntity> genres;
}
