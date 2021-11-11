package Logic;

import Data.Database;
import Data.MessageQueryHandler;

import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @author Travis Tran
 * @version 2020.11.29
 * Sends email to subscribers through MessageGUI
 *
 * TT: added method to send emails
 * TT: sends emails to subscribers
 * TT: changed recipient type to BCC
 * TT: added exception handling for new database changes
 * TT: renamed to MessageEmail
 */

public class MessageEmail {
    SubscriberInfo email = new SubscriberInfo();
    MessageQueryHandler query = new MessageQueryHandler();

    public MessageEmail(){
    }

    /**
     * Sends email using Jakarta Mail
     * @param subject
     * @param body
     */
    public void sendEmail(String subject, String body) {
        final String username = "missingsemicolons234@gmail.com";
        final String password = "missingsemicolons";

        Properties props = new Properties();

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from-email@gmail.com"));
            try {
                message.setRecipients(Message.RecipientType.BCC,
                        InternetAddress.parse(email.getEmailsString(Database.runQuery(query.getSubscriberQuery()))));
            } catch (Exception e) {}
            message.setSubject(subject);
            message.setDataHandler(new DataHandler(body, "text/plain"));

            Transport.send(message);

        } catch (AddressException e) {
            throw new RuntimeException(e);
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
    }

}
