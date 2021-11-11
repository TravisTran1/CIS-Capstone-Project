package Data;

/**
 * @author Travis Tran
 * @version 2020.11.29
 * Class that handles all the queries required for the sending and logging messages to subscribers
 */

public class MessageQueryHandler {
    private static String SQL_QUERY_LOG_MESSAGE = "INSERT INTO MS_Notification (TemplateID, UserID, DateCreated, SentTo, Subject, Message)" +
            "values (NULL, CONVERT(int, ?), ?, (SELECT COUNT(UserID) FROM MS_Users WHERE SendEmail = 1), ?, ?)";
    private static String SQL_QUERY_GET_SUBSCRIBER_EMAIL = "SELECT Email FROM MS_Users WHERE SendEmail = 1";
    private static String SQL_QUERY_GET_PHONE_NUMBER = "SELECT Phone FROM MS_Users WHERE SendSMS = 1";

    public MessageQueryHandler(){

    }

    public String getLogQuery(){
        return SQL_QUERY_LOG_MESSAGE;
    }

    public String getSubscriberQuery(){
        return SQL_QUERY_GET_SUBSCRIBER_EMAIL;
    }

    public String getPhoneNumberQuery(){
        return SQL_QUERY_GET_PHONE_NUMBER;
    }
}
