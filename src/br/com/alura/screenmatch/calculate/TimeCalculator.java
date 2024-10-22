package br.com.alura.screenmatch.calculate;

import br.com.alura.screenmatch.model.Title;

public class TimeCalculator {
    private int totalTime;

    public int getTotalTime() {
        return totalTime;
    }

//    public void include(Movie m) {
//        totalTime += m.getDurationInMinutes();
//    }
//
//    public void include(Serie s) {
//        totalTime += s.getDurationInMinutes();
//    }

    public void include(Title t) {
        totalTime += t.getDurationInMinutes();
    }
}
