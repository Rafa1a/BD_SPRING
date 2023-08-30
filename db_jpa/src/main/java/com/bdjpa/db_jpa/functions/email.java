package com.bdjpa.db_jpa.functions;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class email {

    public Boolean sendEmail(String toEmail, String subject, String body) {
        // Configurações do servidor SMTP do Gmail
        String host = "smtp.gmail.com";
        String port = "587"; // Porta TLS
        String username = "rafa.altero@gmail.com";
        String password = "mgxrwdvblvtbggfj";

        // Propriedades
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        // Autenticação
        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };

        // Criação da sessão
        Session session = Session.getInstance(props, auth);

        try {
            // Criação da mensagem
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(body);

            // Envio do e-mail
            Transport.send(message);
            System.out.println("E-mail enviado com sucesso para: " + toEmail);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            System.err.println("Erro ao enviar o e-mail.");
            return false;
        }
    }
}
