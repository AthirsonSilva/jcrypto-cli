package org.com.commands;

import org.com.lib.KeyManager;

import java.util.Scanner;

public class Key {
    private final static Scanner scanner = new Scanner(System.in);

    public static String manageKey() {
        System.out.println("""
                You are in the key management section. Available commands:
                
                set - Set your API Key value
                show - Show your API Key value
                remove - Remove your API Key value
                back - Return to main menu
                """);

        System.out.print("Enter command: ");
        String cmd = scanner.nextLine().toLowerCase();

        switch (cmd) {
            case "set" -> setKey();
            case "show" -> showKey();
            case "remove" -> removeKey();
            case "back" -> {
                return "back";
            }
            default -> System.out.println("Invalid command");
        }

        return null;
    }

    public static void setKey() {
        System.out.print("Enter your API key, if you don't have one, visit https://coinapi.io/pricing" +
                " to get one.");

        String apiKey = scanner.nextLine();

        if (apiKey.isEmpty() || apiKey.isBlank()) {
            System.out.println("API key cannot be empty");
            return;
        }

        KeyManager.setApiKey(apiKey);
    }

    public static void showKey() {
        if (KeyManager.hasApiKey()) {
            System.out.println("Your API key is: " + KeyManager.getApiKey());
        } else {
            System.out.println("No API key found. Use `setkey` to set your API key.");
        }
    }

    public static void removeKey() {
        KeyManager.removeApiKey();
    }
}
