package com.bdjpa.db_jpa.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PARTE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_parte;
    @Column(nullable = false)
    private String n_processo;
    
    private String cpf ;
    private String cnpj ;
    @Column(nullable = false)
    private String parte ;
    @Column(nullable = false)
    private String nome ;
    private String e_mail;
    private String cep ;
    private String numero ;
    
    public int getId_parte() {
        return id_parte;
    }
    public void setId_parte(int id_parte) {
        this.id_parte = id_parte;
    }
    public String getN_processo() {
        return n_processo;
    }
    public void setN_processo(String n_processo) {
        this.n_processo = n_processo;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getParte() {
        return parte;
    }
    public void setParte(String parte) {
        this.parte = parte;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getE_mail() {
        return e_mail;
    }
    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
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

}
