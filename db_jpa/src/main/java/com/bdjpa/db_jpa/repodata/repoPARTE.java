package com.bdjpa.db_jpa.repodata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bdjpa.db_jpa.modal.PARTE;

public interface repoPARTE extends JpaRepository<PARTE,Integer>{
    @Query("SELECT p FROM PARTE p WHERE p.n_processo = :processo AND p.parte = 'reu'")
    PARTE findparte(@Param("processo") String processo);
}
