package com.bdjpa.db_jpa.REST_testes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bdjpa.db_jpa.REST_testes.objetos.noti_objeto;
import com.bdjpa.db_jpa.modal.NOTIFICACAO;
import com.bdjpa.db_jpa.modal.PARTE;
import com.bdjpa.db_jpa.repodata.repoNOTIFICACAO;
import com.bdjpa.db_jpa.repodata.repoPARTE;


@RestController
@RequestMapping("/dje")
public class rest_dje {
    
    @Autowired
    private repoNOTIFICACAO repon ;

    @Autowired
    private repoPARTE repop ;

    @GetMapping
    public List<NOTIFICACAO> listar() {
        return repon.findNotificacoesDJE();
    }
    @PutMapping
    public ResponseEntity<String> alterar (@RequestBody noti_objeto noti) {

        String status = noti.getStatus();
        int idnotificacao = noti.getId_notificacao();

        NOTIFICACAO edit = repon.findnotificacao(idnotificacao);
        String nprocesso = edit.getN_processo();
        String statuss   = edit.getStatuss();

        PARTE part      = repop.findparte(nprocesso);
        String cep      = part.getCep();
        String numero   = part.getNumero();
        String email    = part.getE_mail();

        if(edit != null && cep == null && numero == null && email == null && "pendente".equals(statuss)){

            edit.setStatuss(status);
            repon.save(edit);

            return ResponseEntity.ok("Processo editado como enviado!");

        }else if(edit != null && cep == null && numero == null && email == null && "enviado".equals(statuss)){
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Processo ja foi enviado!");

        }else{

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Processo possui cep, numero ou email!");
        }
    }
}
