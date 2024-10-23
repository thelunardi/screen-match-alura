package br.com.alura.screenmatch.model;

public class Title implements Comparable<Title> {
    private String name;
    private int releseYear;
    private boolean includedOnPlan;
    private int durationInMinutes;
    private double review;
    private double reviewSum;
    private int totalReviews;

    public Title(String name, int releseYear) {
        this.name = name;
        this.releseYear = releseYear;
    }

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

    public int getReleseYear() {
        return releseYear;
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

    @Override
    public int compareTo(Title t) {
        return this.getName().compareTo(t.getName());
    }
}
