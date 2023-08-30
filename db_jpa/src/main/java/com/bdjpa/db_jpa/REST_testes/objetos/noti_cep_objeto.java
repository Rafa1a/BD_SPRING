package com.bdjpa.db_jpa.REST_testes.objetos;

public class noti_cep_objeto {
    
    private int id_notificacao;
    private String n_processo;
    private String statuss ; 
    private String motivo_de_notificacao ;

    private String cep;
    private String numero;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    
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
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getLocalidade() {
        return localidade;
    }
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }
    public String getUf() {
        return uf;
    }
    public void setUf(String uf) {
        this.uf = uf;
    }
    



}
