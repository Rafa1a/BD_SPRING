package com.bdjpa.db_jpa.REST_testes;

public class email_objeto {
    private String toEmail;
    private String subject;
    private String body ;
    
    public String getToEmail() {
        return toEmail;
    }
    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }

    
}