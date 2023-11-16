package softeng.cinecritique.app.domain;

import java.util.UUID;

public class MovieRate {
    UUID id;

    Movie movie;

    Float rate;

    User user;

    public MovieRate() {
    }

    public void update(MovieRate update){
        this.rate = update.rate;
    }
    public MovieRate(UUID id, Movie movie, Float rate, User user) {
        this.id = id;
        this.movie = movie;
        this.rate = rate;
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
