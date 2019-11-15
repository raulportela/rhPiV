package com.erp.rh.repository.acesso;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erp.rh.entidade.acesso.Acesso;

public interface AcessoRepository extends JpaRepository<Acesso, Long>{

	Acesso findByUsuario(String usuario);
	
}
