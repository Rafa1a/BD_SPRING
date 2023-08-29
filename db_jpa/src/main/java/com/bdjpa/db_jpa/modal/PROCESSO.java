 package com.bdjpa.db_jpa.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PROCESSO {

    @Id
    private String n_processo;
    @Column(nullable = false)
    private String orgao_julgado;
    @Column(nullable = false)
    private String valor_causa;
    @Column(nullable = false)
    private String nivel_sigilo;
    @Column(nullable = false)
    private String prioridade;

    public String getN_processo() {
        return n_processo;
    }

    public void setN_processo(String n_processo) {
        this.n_processo = n_processo;
    }

    public String getOrgao_julgado() {
        return orgao_julgado;
    }

    public void setOrgao_julgado(String orgao_julgado) {
        this.orgao_julgado = orgao_julgado;
    }

    public String getValor_causa() {
        return valor_causa;
    }

    public void setValor_causa(String valor_causa) {
        this.valor_causa = valor_causa;
    }

    public String getNivel_sigilo() {
        return nivel_sigilo;
    }

    public void setNivel_sigilo(String nivel_sigilo) {
        this.nivel_sigilo = nivel_sigilo;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    
}