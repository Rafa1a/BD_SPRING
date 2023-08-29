package com.bdjpa.db_jpa.REST_testes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bdjpa.db_jpa.REST_testes.objetos.noti_objeto;
import com.bdjpa.db_jpa.modal.NOTIFICACAO;
import com.bdjpa.db_jpa.modal.PROCESSO;
import com.bdjpa.db_jpa.repodata.repoNOTIFICACAO;
import com.bdjpa.db_jpa.repodata.repoPROCESSO;

@RestController
@RequestMapping("/dje")
public class rest_dje {
    @Autowired
    private repoPROCESSO repop ;
    @Autowired
    private repoNOTIFICACAO repon ;
    
    @GetMapping
    public List<NOTIFICACAO> listar() {
        return repon.findNotificacoesDJE();
    }
    @PostMapping
    public void alterar (@RequestBody noti_objeto noti) {
        String status = noti.getStatus();
        String nprocesso = noti.getN_processo();

        NOTIFICACAO edit = repon.findnotificacao(nprocesso);

        if(edit != null) {
            
        }
        

    }

}
