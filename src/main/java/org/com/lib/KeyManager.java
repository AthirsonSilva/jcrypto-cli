package org.com.lib;

import io.github.cdimascio.dotenv.Dotenv;

public class KeyManager {
    private static String apiKey = Dotenv.load().get("API_KEY");

    public KeyManager() {
        apiKey = Dotenv.load().get("API_KEY");
    }

    public static String getApiKey() {
        return apiKey;
    }

    public static void setApiKey(String apiKey) {
        KeyManager.apiKey = apiKey;
    }

    public static boolean hasApiKey() {
        return !apiKey.isEmpty();
    }

    public static void removeApiKey() {
        apiKey = "";
    }
}
