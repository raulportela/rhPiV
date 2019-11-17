package com.erp.rh.repository.endereco;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erp.rh.entidade.endereco.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	Endereco findById(long id);
}
