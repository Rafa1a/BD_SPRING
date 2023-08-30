package com.bdjpa.db_jpa.REST_testes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bdjpa.db_jpa.REST_testes.objetos.ViaCepResponse;
import com.bdjpa.db_jpa.REST_testes.objetos.noti_cep_objeto;
import com.bdjpa.db_jpa.REST_testes.objetos.noti_objeto;
import com.bdjpa.db_jpa.functions.ceprequest;
import com.bdjpa.db_jpa.modal.NOTIFICACAO;
import com.bdjpa.db_jpa.modal.PARTE;
import com.bdjpa.db_jpa.repodata.repoNOTIFICACAO;
import com.bdjpa.db_jpa.repodata.repoPARTE;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/cep")
public class rest_cep {

    @Autowired
    private repoNOTIFICACAO repon ;

    @Autowired
    private repoPARTE repop ;

    @GetMapping
    public List<noti_cep_objeto> listar() {

        List<NOTIFICACAO> listanoti = repon.findNotificacoesCEP();
        List<noti_cep_objeto> notificacoesPendentes = new ArrayList<>();

        for (NOTIFICACAO notificacao : listanoti) {
            //notificacao dados
            int     id_notificacao  = notificacao.getId_notificacao();
            String nprocesso        = notificacao.getN_processo();
            String  statuss         = notificacao.getStatuss();
            String  motivo          = notificacao.getMotivo_de_notificacao();
            //parte dados
            PARTE part              = repop.findparte(nprocesso);
            String cep              = part.getCep();
            String numero           = part.getNumero();
            //requisicao
            ceprequest resquest     = new ceprequest();
            ViaCepResponse response = resquest.cep(cep);
            //setar valores capturados
            noti_cep_objeto noti_cep = new noti_cep_objeto();
            noti_cep.setId_notificacao(id_notificacao);
            noti_cep.setN_processo(nprocesso);
            noti_cep.setStatuss(statuss);
            noti_cep.setMotivo_de_notificacao(motivo);
            noti_cep.setCep(cep);
            noti_cep.setNumero(numero);
            noti_cep.setLogradouro(response.getLogradouro());
            noti_cep.setComplemento(response.getComplemento());
            noti_cep.setBairro(response.getBairro());
            noti_cep.setLocalidade(response.getLocalidade());
            noti_cep.setUf(response.getUf());

            notificacoesPendentes.add(noti_cep);
            
        }

        return notificacoesPendentes;
        
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

        if(edit != null && cep != null && numero != null && "pendente".equals(statuss)){
            edit.setStatuss(status);
            repon.save(edit);

            return ResponseEntity.ok("Processo editado como enviado!");

        }else if(edit != null && cep != null && numero != null && "enviado".equals(statuss)){
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Processo ja foi enviado!");

        }else{

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Processo não possui cep ou numero!");
        }
    }
    
}
