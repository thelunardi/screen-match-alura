package br.com.alura.screenmatch.model;

public class Title {
    private String name;
    private int releseYear;
    private boolean includedOnPlan;
    private int durationInMinutes;
    private double review;
    private double reviewSum;
    private int totalReviews;

    public void evaluate(double value) {
        this.reviewSum += value;
        this.totalReviews++;
        this.review = this.reviewSum / this.totalReviews;
    }

    public double getReview() {
        return review;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReleseYear() {
        return releseYear;
    }

    public void setReleseYear(int releseYear) {
        this.releseYear = releseYear;
    }

    public boolean isIncludedOnPlan() {
        return includedOnPlan;
    }

    public void setIncludedOnPlan(boolean includedOnPlan) {
        this.includedOnPlan = includedOnPlan;
    }

    public int getTotalReviews() {
        return totalReviews;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }
}