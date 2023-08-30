package com.bdjpa.db_jpa.REST_testes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bdjpa.db_jpa.REST_testes.objetos.notificacao_post_objeto;
import com.bdjpa.db_jpa.functions.email;
import com.bdjpa.db_jpa.modal.NOTIFICACAO;
import com.bdjpa.db_jpa.modal.PARTE;
import com.bdjpa.db_jpa.repodata.repoNOTIFICACAO;
import com.bdjpa.db_jpa.repodata.repoPARTE;

@RestController
@RequestMapping("/notificacao")
public class rest_email_test {

    @Autowired
    private repoPARTE repop;

    @Autowired
    private repoNOTIFICACAO repon;

    @PostMapping
    public ResponseEntity<String> enviar(@RequestBody notificacao_post_objeto e_email) {
        String n_processo = e_email.getN_processo();
        String motivo = e_email.getMotivo_notificacao();
        String status = "enviado";

        // parte
        PARTE pegar = repop.findparte(n_processo);
        String cep = pegar.getCep();
        String numero = pegar.getNumero();
        String email = pegar.getE_mail();
        String tribunal = "Tribunal de Justiça";

        try {
            if (email != null && cep == null && numero == null) {
                NOTIFICACAO noti = new NOTIFICACAO();
                noti.setN_processo(n_processo);
                noti.setStatuss(status);
                noti.setMotivo_de_notificacao(motivo);

                email e_mail = new email();
                boolean emailSent = e_mail.sendEmail(email, tribunal, motivo);

                if (emailSent) {
                    repon.save(noti);
                    return ResponseEntity.ok("E-mail enviado");
                } else {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao enviar o e-mail");
                }
                
            } else if (cep != null && numero != null){
                NOTIFICACAO noti = new NOTIFICACAO();
                noti.setN_processo(n_processo);
                noti.setStatuss("pendente");
                noti.setMotivo_de_notificacao(motivo);

                repon.save(noti);
                return ResponseEntity.ok("Processo cadastrado sera enviado pelo e-cartas!");
            }else {
                NOTIFICACAO noti = new NOTIFICACAO();
                noti.setN_processo(n_processo);
                noti.setStatuss("pendente");
                noti.setMotivo_de_notificacao(motivo);

                repon.save(noti);
                return ResponseEntity.ok("Processo cadastrado sera enviado por DJe!");
            }

        } catch (DataAccessException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao acessar os dados");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro inesperado");
        }
    }
}