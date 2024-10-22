package br.com.alura.screenmatch.model;

import br.com.alura.screenmatch.calculate.Reviewable;

public class Episode implements Reviewable {
    private int number;
    private String name;
    private Serie serie;
    private int views;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    @Override
    public int getReviewInStars() {
        if (views > 500) {
            return 4;
        } else {
            return 2;
        }
    }
}
