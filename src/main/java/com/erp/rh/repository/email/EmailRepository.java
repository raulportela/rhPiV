package com.erp.rh.repository.email;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erp.rh.entidade.email.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {

}
