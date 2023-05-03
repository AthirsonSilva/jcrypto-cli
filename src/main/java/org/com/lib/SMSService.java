package org.com.lib;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.Scanner;

public class SMSService {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String ACCOUNT_SID = Dotenv.load().get("TWILIO_ACCOUNT_SID");
    private static final String AUTH_TOKEN = Dotenv.load().get("TWILIO_AUTH_TOKEN");
    private static final String TWILIO_NUMBER = Dotenv.load().get("TWILIO_PHONE_NUMBER");
    private static final String MY_NUMBER = Dotenv.load().get("MY_PHONE_NUMBER");


    public static void sendSMS(String smsBody) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(MY_NUMBER),
                new com.twilio.type.PhoneNumber(TWILIO_NUMBER),
                smsBody)
            .create();

        System.out.println(message.getSid());
    }
}
