package org.com.lib;

import io.github.cdimascio.dotenv.Dotenv;
import org.com.payload.PriceData;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.http.HttpClient.newHttpClient;

public class CryptoAPI {
    private static final String BASE_URL = Dotenv.load().get("API_URL");

    public PriceData getPriceData(String coinOption, String currencyOption, String apiKey) {
        try {
            String endpoint = String.format("%s/%s/%s", BASE_URL, coinOption, currencyOption);

            HttpRequest request = HttpRequest.newBuilder().uri(new URI(endpoint)).GET().header("X-CoinAPI-Key", apiKey).build();

            HttpResponse<String> response = newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            return new PriceData().fromJson(response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
