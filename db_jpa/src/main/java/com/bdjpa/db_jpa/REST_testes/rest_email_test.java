package com.bdjpa.db_jpa.REST_testes;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bdjpa.db_jpa.REST_testes.objetos.email_objeto;
import com.bdjpa.db_jpa.functions.email;

@RestController
@RequestMapping("/email")
public class rest_email_test {
    
    @PostMapping
    public void enviar(@RequestBody email_objeto o_email) {  

        email e_mail = new email();
        e_mail.sendEmail(o_email.getToEmail(), o_email.getSubject(), o_email.getBody());

    }
}
