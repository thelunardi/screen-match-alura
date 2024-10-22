package br.com.alura.screenmatch;

import br.com.alura.screenmatch.calculate.RecommendationFilter;
import br.com.alura.screenmatch.calculate.TimeCalculator;
import br.com.alura.screenmatch.model.Episode;
import br.com.alura.screenmatch.model.Movie;
import br.com.alura.screenmatch.model.Serie;

import java.util.ArrayList;
import java.util.logging.Filter;

public class Main {
    public static void main(String[] args) {
        Movie movie = new Movie();
        Movie movie2 = new Movie();
        RecommendationFilter recommendationFilter = new RecommendationFilter();

        movie.setName("Lilo & Stich");
        movie.setDurationInMinutes(140);
        movie.setReleseYear(2003);

        TimeCalculator timeCalculator = new TimeCalculator();
        timeCalculator.include(movie);

        movie.evaluate(9.0);
        movie.evaluate(8.0);
        movie.evaluate(7.5);

        System.out.println("Nome do filme: " + movie.getName());
        System.out.println("Nota média do filme: " + movie.getReview());
        System.out.println("Classificação: " + movie.getReviewInStars() + " estrelas");
        recommendationFilter.filter(movie);

        movie2.setName("Lilo & Stich - 2");
        movie2.setDurationInMinutes(110);
        movie2.setReleseYear(2022);
        timeCalculator.include(movie2);

        System.out.println("Nome do filme: " + movie2.getName());

        movie2.evaluate(8.0);
        movie2.evaluate(8.0);
        movie2.evaluate(7.5);

        System.out.println("Nota média do filme: " + movie2.getReview());
        System.out.println("Classificação: " + movie2.getReviewInStars() + " estrelas");

        Serie serie = new Serie();
        serie.setName("Lost");
        serie.setActive(false);
        serie.setSeasons(6);
        serie.setMinutesPerEpisode(50);
        serie.setEpisodesPerSeason(14);
        serie.setIncludedOnPlan(true);
        serie.setReleseYear(2002);

        Episode lostEpisode = new Episode();
        lostEpisode.setName("Pilot");
        lostEpisode.setNumber(1);
        lostEpisode.setSerie(serie);
        lostEpisode.setViews(500);
        System.out.println("Duração total da série: " + serie.getDurationInMinutes() + " minutos");

        timeCalculator.include(serie);
        System.out.println("Total: " + timeCalculator.getTotalTime());
        recommendationFilter.filter(lostEpisode);

        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(movie);
        movies.add(movie2);

        System.out.println("Tamanho da lista: " + movies.size());
        System.out.println("Primeiro filme: " + movies.get(0).getName());
        System.out.println("Lista de filmes: " + movies);
    }
}