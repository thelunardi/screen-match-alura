package br.com.alura.screenmatch.model;

import br.com.alura.screenmatch.calculate.Reviewable;

public class Movie extends Title implements Reviewable {
    String director;

    public Movie(String name, int releseYear) {
        super(name, releseYear);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getReviewInStars() {
        return (int) (this.getReview() / 2);
    }

    @Override
    public String toString() {
        return "Filme: " + this.getName() + " (" + this.getReleseYear() + ")";
    }
}
