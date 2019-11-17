package com.erp.rh.repository.contato;

import org.springframework.data.jpa.repository.JpaRepository;


import com.erp.rh.entidade.contato.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
	
	Contato findById(long id);
	
}
