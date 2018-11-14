package com.swm.datatracker.services;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

@Service
public class SmsSender {

        // Find your Account Sid and Auth Token at twilio.com/console
        public static final String ACCOUNT_SID =
                "ACdc9284a8640258b7480d2ae8a7024dc5";
        public static final String AUTH_TOKEN =
                "faef8d383b899030a394d1558c5c9a6a";

//        public static void main(String[] args) {
        public void sendText(String theMessage) {
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

            Message message = Message
                    .creator(new PhoneNumber("+12109006297"), // to
                            new PhoneNumber("+18302660548"), // from
                            theMessage)
                    .create();

            System.out.println(message.getSid());
        }
}
