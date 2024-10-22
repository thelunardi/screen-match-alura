package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.calculate.RecommendationFilter;
import br.com.alura.screenmatch.calculate.TimeCalculator;
import br.com.alura.screenmatch.model.Episode;
import br.com.alura.screenmatch.model.Movie;
import br.com.alura.screenmatch.model.Serie;
import br.com.alura.screenmatch.model.Title;

import java.util.ArrayList;

public class MainList {
    public static void main(String[] args) {
        Movie movie = new Movie("Lilo & Stich", 2003);
        movie.evaluate(10);
        movie.setDurationInMinutes(100);
        Movie movie2 = new Movie("Lilo & Stich - 2", 2022);
        movie2.evaluate(7);
        movie2.setDurationInMinutes(110);
        Serie serie = new Serie("Lost", 2006);
        Movie movie3 = new Movie("Top Gun", 2022);
        movie3.evaluate(9);
        movie3.setDurationInMinutes(120);

        ArrayList<Title> titles = new ArrayList<>();
        titles.add(movie);
        titles.add(movie2);
        titles.add(movie3);
        titles.add(serie);

        for (Title title: titles) {
            System.out.println(title.getName());
            if (title instanceof Movie movieList && movieList.getReviewInStars() > 3) {
                movieList.setDurationInMinutes(5000);
                System.out.println("Classificação do filme: " + movieList.getReviewInStars() + ". Duração: " + movieList.getDurationInMinutes());
            }
        }

        System.out.println(movie.getDurationInMinutes());
        System.out.println(movie2.getDurationInMinutes());
        System.out.println(movie3.getDurationInMinutes());
    }
}