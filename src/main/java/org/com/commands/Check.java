package org.com.commands;

import org.com.lib.CryptoAPI;
import org.com.lib.KeyManager;
import org.com.payload.PriceData;
import org.com.utils.ValidateInput;

import java.util.Map;
import java.util.Scanner;

public class Check {
    private static final Scanner scanner = new Scanner(System.in);

    public static void fetchPriceData() {
        Map<String, String> cmd = readInputs();

        if (cmd == null)
            throw new IllegalStateException("You must provide both a cryptocurrency and a exchange currency");

        try {
            if (KeyManager.hasApiKey()) {
                CryptoAPI api = new CryptoAPI();
                PriceData priceData = api.getPriceData(cmd.get("coin"), cmd.get("crypto"), KeyManager.getApiKey());

                System.out.printf("""         
                        %n----------------------------------------------------
                        Price of %s in %s: %s
                        ----------------------------------------------------
                        """, cmd.get("crypto"), cmd.get("coin"), priceData.rate());
            } else {
                System.out.println("No API key found. Use `setkey` to set your API key.");
            }
        } catch (Exception e) {
            System.err.print("Hmm, it seems something went wrong finishing your request: \n\tERR: " + e.getMessage());
        }
    }

    public static Map<String, String> readInputs() {
        System.out.print("Enter a cryptocurrency to check the price of (Ex.: BTC): ");
        String crypto = scanner.nextLine().toUpperCase();

        System.out.print("Enter a exchange currency to check the price of (Ex.: USD): ");
        String currency = scanner.nextLine().toUpperCase();

        if (ValidateInput.validate(crypto) && ValidateInput.validate(currency))
            return Map.of("crypto", crypto, "coin", currency);


        return null;
    }
}
