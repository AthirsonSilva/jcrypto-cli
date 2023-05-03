package org.com.commands;

import org.com.lib.SMSService;
import org.com.payload.PriceData;

public class SMS {
    public static void sendSMS() {
        PriceData priceData = Check.fetchPriceData();

        if (priceData == null)
            throw new IllegalStateException("You must provide both a cryptocurrency and a exchange currency");

        String message =  String.format("""         
                        %n----------------------------------------------------
                        Price of %s in %s: %s
                        
                        Fetched at: %s
                        ----------------------------------------------------
                        """, priceData.asset_id_base(), priceData.asset_id_quote(), priceData.rate(), priceData.time());

        SMSService.sendSMS(message);
    }
}
