package softeng.cinecritique.app.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

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

    public Movie(UUID id, String name, String description, LocalDate filmedAt, LocalDate createdAt, List<Genre> genres, List<MovieRate> rates) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.filmedAt = filmedAt;
        this.createdAt = createdAt;
        this.genres = genres;
        this.rates = rates;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getFilmedAt() {
        return filmedAt;
    }

    public void setFilmedAt(LocalDate filmedAt) {
        this.filmedAt = filmedAt;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<MovieRate> getRates() {
        return rates;
    }

    public void setRates(List<MovieRate> rates) {
        this.rates = rates;
    }
}
