package com.bdjpa.db_jpa.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class NOTIFICACAO {
    @Id
    @GeneratedValue
    private int id_notificacao;
    @Column(nullable = false)
    private String n_processo;
    @Column(nullable = false)
    private String statuss ; 
    @Column(nullable = false)
    private String motivo_de_notificacao ;

    public int getId_notificacao() {
        return id_notificacao;
    }

    public void setId_notificacao(int id_notificacao) {
        this.id_notificacao = id_notificacao;
    }

    public String getN_processo() {
        return n_processo;
    }

    public void setN_processo(String n_processo) {
        this.n_processo = n_processo;
    }

    public String getStatuss() {
        return statuss;
    }

    public void setStatuss(String statuss) {
        this.statuss = statuss;
    }

    public String getMotivo_de_notificacao() {
        return motivo_de_notificacao;
    }

    public void setMotivo_de_notificacao(String motivo_de_notificacao) {
        this.motivo_de_notificacao = motivo_de_notificacao;
    }

    
}
