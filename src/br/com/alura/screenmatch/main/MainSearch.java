package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.exception.YearConversionException;
import br.com.alura.screenmatch.model.OmdbTitle;
import br.com.alura.screenmatch.model.Title;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Year;
import java.util.Properties;
import java.util.Scanner;

public class MainSearch {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe um filme:");
        String filter = scanner.nextLine();

        var props = new Properties();
        var envFile = Paths.get(".env");
        try (var inputStream = Files.newInputStream(envFile)) {
            props.load(inputStream);
        }
        var apiKey = props.get("API_KEY");

        String address = "https://www.omdbapi.com/?t=" + filter.replace(" ", "+") + "&apikey=" + apiKey.toString();

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(address))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();

            OmdbTitle omdbTitle = gson.fromJson(response.body(), OmdbTitle.class);
            System.out.println("Título: " + omdbTitle.title() + " (" + omdbTitle.year() + ")");

            // try {
            Title title = new Title(omdbTitle);
            System.out.println("Título: " + title.getName() + " (" + title.getReleseYear() + ") - " + title.getDurationInMinutes() + " minutos");
        } catch (NumberFormatException e) {
            System.out.println("Aconteceu um erro");
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro de argumento na busca");
        } catch (YearConversionException e) {
            System.out.println(e.getMessage());
        }


        //        client.sendAsync(request, BodyHandlers.ofString())
//                .thenApply(HttpResponse::body)
//                .thenAccept(System.out::println)
//                .join();
    }
}
