package org.com;

import org.com.commands.Check;
import org.com.commands.Key;
import org.com.commands.SMS;

import java.util.Scanner;

public class MainApplication {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("\n-------------------------\nWelcome to JCryptoCLI!!!\n-------------------------");

        while (true) {
            printCommands();

            System.out.print("Enter command: ");
            String cmd = scanner.nextLine().toLowerCase();

            switch (cmd) {
                case "exit" -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                case "key" -> {
                    String manageKey = Key.manageKey();

                    if (manageKey != null && manageKey.equals("back")) {
                        continue;
                    }
                }
                case "check" -> Check.fetchPriceData();
                case "sms" -> SMS.sendSMS();
                default -> System.out.println("Invalid command");
            }
        }
    }

    private static void printCommands() {
        System.out.println("""
                \n
                ----------------------------------------------------
                Type `exit` to exit the program.
                Type `key` to manage your API key.
                Type `check` to check the price of a cryptocurrency.
                Type `sms` to send a SMS message with the price of a cryptocurrency.
                ----------------------------------------------------
                """);
    }
}
