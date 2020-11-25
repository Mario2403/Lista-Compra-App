package com.home.listaCompra.service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;

public class MailService {

    public static void sendMail(String excelFileName){
        String from = "listadelacompradecasa@gmail.com";


        ArrayList<String> recipients = new ArrayList<>();
        recipients.add("mariojuso2011@gmail.com");
        //recipients.add("loliso1310@gmail.com");

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); //TLS

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("listadelacompradecasa@gmail.com", "ComprasCasa");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(false);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            for (String to : recipients){
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            }


            Calendar today = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            String date = simpleDateFormat.format(today.getTime());

            message.setSubject("Lista de la Compra - " +date );

            Multipart multipart = new MimeMultipart();
            MimeBodyPart attachmentPart = new MimeBodyPart();
            MimeBodyPart textPart = new MimeBodyPart();


            try {
                File f =new File(excelFileName);

                attachmentPart.attachFile(f);
                textPart.setText("Hola, \n En este correo encontrarás tu lista de la compra. \n ¡Que tengas un buen día!");
                multipart.addBodyPart(textPart);
                multipart.addBodyPart(attachmentPart);
                message.setContent(multipart);

            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
