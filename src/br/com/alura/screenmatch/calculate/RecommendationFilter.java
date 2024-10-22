package br.com.alura.screenmatch.calculate;

public class RecommendationFilter {
    public void filter(Reviewable r) {
        if (r.getReviewInStars() >= 4) {
            System.out.println("Está entre os preferidos");
        } else if (r.getReviewInStars() >= 2) {
            System.out.println("Bem avaliado no momento");
        } else {
            System.out.println("Coloque na lista para assistir posteriormente");
        }
    }
}
