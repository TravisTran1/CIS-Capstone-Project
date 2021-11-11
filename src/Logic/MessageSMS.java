package Logic;

import Data.Database;
import Data.MessageQueryHandler;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.util.ArrayList;

/**
 * @author Travis Tran
 * @version 2020.11.29
 * Sends SMS messages to subscribers who opt in for SMS notifications
 *
 * TT: sendSMS iterates through list of phone numbers
 */

public class MessageSMS {
    public static final String ACCOUNT_SID = "ACa41ae51a4651e8e627e314a7ce2cbe5e";
    public static final String AUTH_TOKEN = "400c43b0e81b3cb2f5dc49d655a11328";

    SubscriberInfo subscriber = new SubscriberInfo();
    MessageQueryHandler query = new MessageQueryHandler();

    public MessageSMS(){
    }

    /**
     * Sends message via SMS
     * @param body message body
     */
    public void sendSMS(String body) throws Exception {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        ArrayList<String> numbersList;
        try {
            numbersList = subscriber.getPhoneNumberList(Database.runQuery(query.getPhoneNumberQuery()));
        } catch (Exception e) {
            throw new Exception(e);
        }

        for (String i : numbersList) {
            Message message = Message.creator(new PhoneNumber("+1" + i), //send to
                    new PhoneNumber("+18305218585"), //sender
                    body).create();

        }
    }


}
