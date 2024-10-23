package br.com.alura.screenmatch.model;

import br.com.alura.screenmatch.calculate.Reviewable;

public class Serie extends Title implements Reviewable {
    private int seasons;
    private boolean active;
    private int minutesPerEpisode;
    private int episodesPerSeason;
    private int views;

    public Serie(String name, int releseYear) {
        super(name, releseYear);
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getMinutesPerEpisode() {
        return minutesPerEpisode;
    }

    public void setMinutesPerEpisode(int minutesPerEpisode) {
        this.minutesPerEpisode = minutesPerEpisode;
    }

    public int getEpisodesPerSeason() {
        return episodesPerSeason;
    }

    public void setEpisodesPerSeason(int episodesPerSeason) {
        this.episodesPerSeason = episodesPerSeason;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    @Override
    public int getDurationInMinutes() {
        return minutesPerEpisode * episodesPerSeason * seasons;
    }

    @Override
    public int getReviewInStars() {
        if (views > 100) {
            return 4;
        } else {
            return 5;
        }
    }

    @Override
    public String toString() {
        return "Série: " + this.getName() + " (" + this.getReleseYear() + ")";
    }
}
