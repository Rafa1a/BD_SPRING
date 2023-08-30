package com.bdjpa.db_jpa.repodata;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bdjpa.db_jpa.modal.NOTIFICACAO;


public interface repoNOTIFICACAO extends JpaRepository<NOTIFICACAO,Integer>{
       
    @Query("SELECT n FROM NOTIFICACAO n JOIN PARTE p ON n.n_processo = p.n_processo " +
           "WHERE p.cep IS NULL AND p.numero IS NULL AND p.e_mail IS NULL")
    List<NOTIFICACAO> findNotificacoesDJE();

    @Query("SELECT n FROM NOTIFICACAO n JOIN PARTE p ON n.n_processo = p.n_processo " +
           "WHERE p.cep IS NOT NULL AND p.numero IS NOT NULL")
    List<NOTIFICACAO> findNotificacoesCEP();

    @Query("SELECT n FROM NOTIFICACAO n WHERE n.n_processo = :processo")
    NOTIFICACAO findnotificacao(@Param("processo") String processo);
}
