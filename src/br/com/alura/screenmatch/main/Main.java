package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.calculate.RecommendationFilter;
import br.com.alura.screenmatch.calculate.TimeCalculator;
import br.com.alura.screenmatch.model.Episode;
import br.com.alura.screenmatch.model.Movie;
import br.com.alura.screenmatch.model.Serie;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        RecommendationFilter recommendationFilter = new RecommendationFilter();
        Movie movie = new Movie("Lilo & Stich", 2003);

        movie.setDurationInMinutes(140);

        TimeCalculator timeCalculator = new TimeCalculator();
        timeCalculator.include(movie);

        movie.evaluate(9.0);
        movie.evaluate(8.0);
        movie.evaluate(7.5);

        System.out.println("Nome do filme: " + movie.getName());
        System.out.println("Nota média do filme: " + movie.getReview());
        System.out.println("Classificação: " + movie.getReviewInStars() + " estrelas");
        recommendationFilter.filter(movie);

        Movie movie2 = new Movie("Lilo & Stich - 2", 2022);
        movie2.setDurationInMinutes(110);
        timeCalculator.include(movie2);

        System.out.println("Nome do filme: " + movie2.getName());

        movie2.evaluate(8.0);
        movie2.evaluate(8.0);
        movie2.evaluate(7.5);

        System.out.println("Nota média do filme: " + movie2.getReview());
        System.out.println("Classificação: " + movie2.getReviewInStars() + " estrelas");

        Serie serie = new Serie("Lost", 2006);
        serie.setActive(false);
        serie.setSeasons(6);
        serie.setMinutesPerEpisode(50);
        serie.setEpisodesPerSeason(14);
        serie.setIncludedOnPlan(true);

        Episode lostEpisode = new Episode();
        lostEpisode.setName("Pilot");
        lostEpisode.setNumber(1);
        lostEpisode.setSerie(serie);
        lostEpisode.setViews(500);
        System.out.println("Duração total da série: " + serie.getDurationInMinutes() + " minutos");

        timeCalculator.include(serie);
        System.out.println("Total: " + timeCalculator.getTotalTime());
        recommendationFilter.filter(lostEpisode);

        Movie movie3 = new Movie("Top Gun", 2022);

        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(movie);
        movies.add(movie2);
        movies.add(movie3);

        System.out.println("Tamanho da lista: " + movies.size());
        System.out.println("Primeiro filme: " + movies.get(0).getName());
        System.out.println("Lista de filmes: " + movies);
    }
}