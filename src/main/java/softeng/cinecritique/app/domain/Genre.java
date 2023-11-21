package softeng.cinecritique.app.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.sql.Date;
import java.util.UUID;

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

    public Genre(UUID id, String name, LocalDate createdAt, List<Movie> movies) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.movies = movies;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
