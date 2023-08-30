package com.bdjpa.db_jpa.REST_testes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bdjpa.db_jpa.REST_testes.objetos.noti_objeto;
import com.bdjpa.db_jpa.modal.NOTIFICACAO;
import com.bdjpa.db_jpa.repodata.repoNOTIFICACAO;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/cep")
public class rest_cep {

    @Autowired
    private repoNOTIFICACAO repon ;

    @GetMapping
    public List<NOTIFICACAO> listar() {
        return repon.findNotificacoesCEP();
    }
    @PutMapping
    public void alterar (@RequestBody noti_objeto noti) {
        String status = noti.getStatus();
        String nprocesso = noti.getN_processo();

        NOTIFICACAO edit = repon.findnotificacao(nprocesso);
        if(edit != null){
            edit.setStatuss(status);
            repon.save(edit);
        } 
    }
    
}
