package com.bdjpa.db_jpa.REST_testes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bdjpa.db_jpa.REST_testes.objetos.noti_objeto;
import com.bdjpa.db_jpa.modal.NOTIFICACAO;
import com.bdjpa.db_jpa.repodata.repoNOTIFICACAO;


@RestController
@RequestMapping("/dje")
public class rest_dje {
    
    @Autowired
    private repoNOTIFICACAO repon ;
    
    @GetMapping
    public List<NOTIFICACAO> listar() {
        return repon.findNotificacoesDJE();
    }
    @PutMapping
    public String alterar (@RequestBody noti_objeto noti) {
        String status = noti.getStatus();
        String nprocesso = noti.getN_processo();

        NOTIFICACAO edit = repon.findnotificacao(nprocesso);

        edit.setStatuss(status);
        repon.save(edit);

        return nprocesso;
  
    }

}
